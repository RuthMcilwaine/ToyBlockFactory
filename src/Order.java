import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Order {
    private Customer customer;
    private int orderId;
    private List<Block> blocks = new ArrayList<>();

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOrderId() {
        AtomicInteger seq = new AtomicInteger(orderId);
        orderId = seq.incrementAndGet();
        return orderId;
    }

    public List<Block> getBlocks() {
        return blocks;
    }


    public void add(Block block) {
        if (!block.equals("")) {
            blocks.add(block);
        }
    }
}

