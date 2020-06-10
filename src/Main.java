
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TakingOrder takingOrder = new TakingOrder();
        ReportGenerator reportGenerator = new ReportGenerator();
        Scanner input = new Scanner(System.in);

        System.out.println("\nWelcome to the Toy Block Factory! \n");

        takingOrder.setOrder(input);

        Report report = reportGenerator.createInvoice(takingOrder.getOrder());
        System.out.println(report.printReport());
    }
}
