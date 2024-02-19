/**

 * Project:Solo Lab3
 * Purpose DataNase
 * Course:IST242
 * Author:Houde Yu
 * Date Developed:2024/2/12
 * Last Date Changed:2024/2/18
 * Rev:1.9

 */
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDBDatabase {
    private static final String DATABASE_NAME = "Customer";
    private static final String COLLECTION_NAME = "customer";

    public void insertCustomer(Customer customer) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            Document document = new Document("id", customer.getId())
                    .append("name", customer.getName())
                    .append("address", customer.getAddress())
                    .append("phoneNumber", customer.getPhoneNumber());
            collection.insertOne(document);

            System.out.println("Customer inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            for (Document document : collection.find()) {
                int id = document.getInteger("id");
                String name = document.getString("name");
                String address = document.getString("address");
                String phoneNumber = document.getString("phoneNumber");
                customers.add(new Customer(id, name, address, phoneNumber));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void updateCustomer(Customer customer) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            collection.updateOne(Filters.eq("id", customer.getId()), new Document("$set",
                    new Document("name", customer.getName())
                            .append("address", customer.getAddress())
                            .append("phoneNumber", customer.getPhoneNumber())));

            System.out.println("Customer updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int customerId) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            collection.deleteOne(Filters.eq("id", customerId));

            System.out.println("Customer deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
