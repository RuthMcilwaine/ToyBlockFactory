
import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public void add(Block block) {
        if (!block.equals("")) {
            blocks.add(block);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(blocks, order.blocks);
    }

}

