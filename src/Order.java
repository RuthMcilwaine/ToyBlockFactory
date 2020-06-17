
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Order {

    private Customer customer;
    private int orderId;
    private List<Block> blocks = new ArrayList<>();


    Order() {
    }

    Customer getCustomer() {
        return customer;
    }

    void setCustomer(Customer customer) {
        this.customer = customer;
    }

    int getOrderId() {
        AtomicInteger seq = new AtomicInteger();
        orderId = seq.incrementAndGet();
        return orderId;
    }

    void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    List<Block> getBlocks() {
        return blocks;
    }


    void add(Block block) {
        if (!block.equals("")) {
            blocks.add(block);
        }
    }
}

