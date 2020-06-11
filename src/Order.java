
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Customer customer;
    private String orderId;
    private List<Block> blocks = new ArrayList<>();


    public Order() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderId() {
//        orderId = String.format("E%04d");
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

