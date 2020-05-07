
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Customer customer;
    private int totalOrders = 1;
    private List<Block> blocks = new ArrayList<>();
    private String orderId;


    public Order() { this.blocks = blocks; }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderId() {
        orderId = String.format("E%04d", ++totalOrders);
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

