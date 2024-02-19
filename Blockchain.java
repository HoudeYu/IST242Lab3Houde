/**

 * Project:Solo Lab3
 * Purpose DataNase
 * Course:IST242
 * Author:Houde Yu
 * Date Developed:2024/2/12
 * Last Date Changed:2024/2/18
 * Rev:1.9

 */
import java.util.ArrayList;
import java.util.List;

// Define a Blockchain class
class Blockchain {
    private List<Block> chain;

    // Constructor
    public Blockchain() {
        chain = new ArrayList<Block>();
        // Create the genesis block (the first block in the chain)
        chain.add(new Block(0, "0", "Genesis Block"));
    }

    // Add a new block to the blockchain
    public void addBlock(String data) {
        Block previousBlock = chain.get(chain.size() - 1);
        Block newBlock = new Block(previousBlock.getIndex() + 1, previousBlock.getHash(), data);
        chain.add(newBlock);
    }

    public void printBlockchain() {
        for (Block block : chain) {
            System.out.println("Block #" + block.getIndex());
            System.out.println("Timestamp: " + block.getTimestamp());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Hash: " + block.getHash());
            System.out.println("Data: " + block.getData());
            System.out.println();
        }
    }

}

