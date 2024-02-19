/**

 * Project:Solo Lab3
 * Purpose DataNase
 * Course:IST242
 * Author:Houde Yu
 * Date Developed:2024/2/12
 * Last Date Changed:2024/2/18
 * Rev:1.9

 */
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = 4; // Suppose choice Blockchain
        switch (choice) {
            case 1:
                testMySQL();
                break;
            case 2:
                testMongoDB();
                break;
            case 3:
                // Test Redis
                break;
            case 4:
                testBlockchain();
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private static void testMySQL() {
        MySQLDatabase mySQLDatabase = new MySQLDatabase();

        // Test MySQL database operations
        // Insert customer information
        Customer customer1 = new Customer(1, "John Doe", "123 Main St", "555-1234");
        mySQLDatabase.insertCustomer(customer1);

        // View all customer information
        List<Customer> customers = mySQLDatabase.getAllCustomers();
        System.out.println("All Customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        // Update customer information
        Customer updatedCustomer = new Customer(1, "John Doe", "456 Oak St", "555-5678");
        mySQLDatabase.updateCustomer(updatedCustomer);

        // Delete customer information
        mySQLDatabase.deleteCustomer(1);
    }

    private static void testMongoDB() {
        MongoDBDatabase mongoDBDatabase = new MongoDBDatabase();

        // Test MongoDB database operations
        // Insert customer information
        Customer customer1 = new Customer(1, "Jane Smith", "456 Elm St", "555-9876");
        mongoDBDatabase.insertCustomer(customer1);

        // View all customer information
        List<Customer> customers = mongoDBDatabase.getAllCustomers();
        System.out.println("All Customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        // Update customer information
        Customer updatedCustomer = new Customer(1, "Jane Smith", "789 Pine St", "555-5432");
        mongoDBDatabase.updateCustomer(updatedCustomer);

        // Delete customer information
        mongoDBDatabase.deleteCustomer(1);
    }

    private static void testBlockchain() {
        Blockchain blockchain = new Blockchain();

        // Test blockchain operations
        // Add new blocks
        blockchain.addBlock("Transaction 1");
        blockchain.addBlock("Transaction 2");
        blockchain.addBlock("Transaction 3");

        // Print the entire blockchain
        blockchain.printBlockchain();
    }
}
