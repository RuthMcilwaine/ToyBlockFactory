import java.util.ArrayList;
import java.util.List;

public class CuttingReport {

    List<Customer> customerDetails;
    List<Order> orderItems = new ArrayList<>();


    public String displayCuttingTable() {
        return null;
    }

    @Override
    public String toString() {
        return "Cutting Report{" +
                "customerDetails=" + customerDetails +
                ", orderItems=" + orderItems +
                '}';
    }
}


