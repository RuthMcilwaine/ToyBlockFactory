
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TakingOrder takingOrder = new TakingOrder();
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Scanner input = new Scanner(System.in);

        System.out.println("\nWelcome to the Toy Block Factory! \n");

        takingOrder.setOrder(input);

        Invoice invoice = invoiceGenerator.createInvoice(takingOrder.getOrder());
        System.out.println(invoice);
    }
}
