import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

class Blockchain {
    private List<Block> chain;

    public Blockchain() {
        chain = new ArrayList<>();
        // 创建创世区块
        createGenesisBlock();
    }

    private void createGenesisBlock() {
        chain.add(new Block(0, "0", null)); // 假设创世区块的前一个哈希为 "0"，数据为 null
    }

    public void addBlock(String data) {
        Block previousBlock = chain.get(chain.size() - 1);
        Block newBlock = new Block(previousBlock.getIndex() + 1, previousBlock.getHash(), data);
        chain.add(newBlock);
    }

    public void printBlockchain() {
        for (Block block : chain) {
            System.out.println(block);
        }
    }
}
