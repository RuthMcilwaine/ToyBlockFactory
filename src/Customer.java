
public class Customer {
    private String name;
    private String address;
    private String dueDate;


    public Customer(String name, String address, String dueDate) {
        this.name = name;
        this.address = address;
        this.dueDate = dueDate;
    }

    public String toString() {
        return "Name: " + name +
                ", Address: " + address +
                ", Due Date: " + dueDate;
    }
}

