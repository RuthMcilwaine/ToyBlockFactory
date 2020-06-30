import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReportTests {
    ReportData reportData = new ReportData();

    @Test
    void canGenerateANewCuttingReport() {
        reportData.setCustomerDetails(new Customer("Mark Pearl", "1 Bob Ave", "19/01/2019"));
        reportData.setOrderId(0001);
        reportData.setSquarePaintColours(2, 0, 0);
        reportData.setTrianglePaintColours(1, 1, 0);
        reportData.setCirclePaintColours(1, 1, 1);

        CuttingReport cuttingReport = new CuttingReport(reportData);

        Assertions.assertEquals("\n\nYour cutting report has been generated: \n\n" +
                        "Name: Mark Pearl, Address: 1 Bob Ave, Due Date: 19/01/2019, Order #: 0001\n\n" +

                        "|          | Qty |\n" +
                        "|  square  |  2  |\n" +
                        "| triangle |  2  |\n" +
                        "|  circle  |  3  |\n\n",

                cuttingReport.printReport());
    }

    @Test
    void canGenerateANewPaintingReport() {
        reportData.setCustomerDetails(new Customer("Mark Pearl", "1 Bob Ave", "19/01/2019"));
        reportData.setOrderId(0001);
        reportData.setSquarePaintColours(2, 0, 0);
        reportData.setTrianglePaintColours(1, 1, 0);
        reportData.setCirclePaintColours(1, 1, 1);

        PaintingReport paintingReport = new PaintingReport(reportData);
        Assertions.assertEquals("\n\nYour painting report has been generated: \n\n" +
                        "Name: Mark Pearl, Address: 1 Bob Ave, Due Date: 19/01/2019, Order #: 0001\n\n" +
                        "|          | red | blue | yellow | \n" +
                        "|  square  |  2  |  0   |   0    | \n" +
                        "| triangle |  1  |  1   |   0    | \n" +
                        "|  circle  |  1  |  1   |   1    | \n\n",

                paintingReport.printReport());
    }

    @Test
    void canGenerateANewInvoiceReport() {

        reportData.setCustomerDetails(new Customer("Mark Pearl", "1 Bob Ave", "19/01/2019"));
        reportData.setOrderId(0001);
        reportData.setSquarePaintColours(2, 0, 0);
        reportData.setTrianglePaintColours(1, 1, 0);
        reportData.setCirclePaintColours(1, 1, 1);
        reportData.setSumOfCosts(19);

        InvoiceReport invoiceReport = new InvoiceReport(reportData);
        Assertions.assertEquals("\n\nYour invoice report has been generated: \n\n" +
                "Name: Mark Pearl, Address: 1 Bob Ave, Due Date: 19/01/2019, Order #: 0001\n\n" +
                "|          | red | blue | yellow | \n" +
                "|  square  |  2  |  0   |   0    | \n" +
                "| triangle |  1  |  1   |   0    | \n" +
                "|  circle  |  1  |  1   |   1    | \n" +
                "Squares 2 @ $1 ppi =  $2\n" +
                "Triangles 2 @ $2 ppi =  $4\n" +
                "Circles 3 @ $3 ppi =  $9\n" +
                "Red colour surcharge 4 @ $1 ppi =  $4\n\n" +

                "Total:  $19\n\n", invoiceReport.printReport());
    }

}

