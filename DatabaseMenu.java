/**

 * Project:Solo Lab3
 * Purpose DataNase
 * Course:IST242
 * Author:Houde Yu
 * Date Developed:2024/2/12
 * Last Date Changed:2024/2/18
 * Rev:1.9

 */
import java.util.Scanner;

public class DatabaseMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Database Menu:");
        System.out.println("1. MySQL");
        System.out.println("2. MongoDB");
        System.out.println("3. Redis");
        System.out.println("4. Blockchain");
        System.out.println("Please choose an option:");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                MySQLDatabase mySQLDatabase = new MySQLDatabase();
                handleMySQLOperations(mySQLDatabase);
                break;
            case 2:
                MongoDBDatabase mongoDBDatabase = new MongoDBDatabase();
                handleMongoDBOperations(mongoDBDatabase);
                break;
            case 3:
                // Handle Redis operations
                break;
            case 4:
                Blockchain blockchain = new Blockchain();
                handleBlockchainOperations(blockchain);
                break;
            default:
                System.out.println("Invalid option");
        }

        scanner.close();
    }

    private static void handleMySQLOperations(MySQLDatabase mySQLDatabase) {
        // 实现MySQL数据库操作
    }

    private static void handleMongoDBOperations(MongoDBDatabase mongoDBDatabase) {
        // 实现MongoDB数据库操作
    }

    private static void handleBlockchainOperations(Blockchain blockchain) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Blockchain Operations Menu:");
        System.out.println("1. Add Block");
        System.out.println("2. Print Blockchain");
        System.out.println("Please choose an option:");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addBlock(scanner, blockchain);
                break;
            case 2:
                blockchain.printBlockchain();
                break;
            default:
                System.out.println("Invalid option");
        }

        scanner.close();
    }

    private static void addBlock(Scanner scanner, Blockchain blockchain) {
        System.out.println("Enter data for the new block:");
        String data = scanner.next();
        blockchain.addBlock(data);
        System.out.println("Block added successfully.");
    }
}
