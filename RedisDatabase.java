import redis.clients.jedis.Jedis;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RedisDatabase {
    private static final String HOST = "localhost";
    private static final int PORT = 6379;

    private Gson gson;

    public RedisDatabase() {
        this.gson = new Gson();
    }

    public void insertCustomer(Customer customer) {
        try (Jedis jedis = new Jedis(HOST, PORT)) {
            String customerJson = gson.toJson(customer);
            jedis.hset("customers", String.valueOf(customer.getId()), customerJson);
            System.out.println("Customer inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Jedis jedis = new Jedis(HOST, PORT)) {
            Map<String, String> customerMap = jedis.hgetAll("customers");
            for (Map.Entry<String, String> entry : customerMap.entrySet()) {
                String customerJson = entry.getValue();
                Customer customer = gson.fromJson(customerJson, Customer.class);
                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void updateCustomer(Customer customer) {
        try (Jedis jedis = new Jedis(HOST, PORT)) {
            String customerJson = gson.toJson(customer);
            jedis.hset("customers", String.valueOf(customer.getId()), customerJson);
            System.out.println("Customer updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int customerId) {
        try (Jedis jedis = new Jedis(HOST, PORT)) {
            jedis.hdel("customers", String.valueOf(customerId));
            System.out.println("Customer deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
