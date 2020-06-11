
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TakingOrder takingOrder = new TakingOrder();
        ReportGenerator reportGenerator = new ReportGenerator();
        Scanner input = new Scanner(System.in);

        System.out.println("\nWelcome to the Toy Block Factory! \n");

        takingOrder.setOrder(input);

        Report invoiceReport = reportGenerator.createInvoiceReport(takingOrder.getOrder());
        System.out.println(invoiceReport.printReport());

        Report cuttingReport = reportGenerator.createCuttingReport(takingOrder.getOrder());
        System.out.println(cuttingReport.printReport());

        Report paintingReport = reportGenerator.createPaintingReport(takingOrder.getOrder());
        System.out.println(paintingReport.printReport());

    }
}
