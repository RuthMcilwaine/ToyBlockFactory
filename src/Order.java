
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private Customer customer;
    private String orderId;
    int totalOrders = 1;
    private List<Block> blocks = new ArrayList<>();
    private LocalDate dueDate;
//

    public Order(Customer customer) {
        this.customer = customer;
    }

    public Order(Customer customer, List<Block> blocks) {
        this.customer = customer;
        this.setDueDate(dueDate.plusWeeks(3));
        this.setOrderId(String.format("E%04d", ++totalOrders));
        this.blocks = blocks;

    }

    public Customer getCustomer() {
        return customer;
    }


    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    public void setDueDate(LocalDate dueDate) {
        LocalDate today = LocalDate.now();
        this.dueDate = today.plusWeeks(3);
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

