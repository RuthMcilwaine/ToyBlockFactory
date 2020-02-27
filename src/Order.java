
import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private String orderId;
    int totalOrders = 1;
    private List<Block> blocks = new ArrayList<>();
    private LocalDate dueDate;


    public Order() {
        this.customer = customer;
        this.blocks = blocks;
    }

    public Customer getCustomer() {
        return customer;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = (String.format("E%04d", ++totalOrders));
    }

    public void setDueDate(int year, int month, int day) {
        LocalDate today = LocalDate.of(year, month, day);
        this.dueDate = today.plusWeeks(3);
    }

    public LocalDate getDueDate() {
        return dueDate;
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

