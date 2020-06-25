import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CuttingReportTests {
    ReportData reportData = new ReportData();

    @Test
    void canGenerateANewCuttingReport() {
        reportData.setCustomerDetails(new Customer("Mark Pearl", "1 Bob Ave", "19/01/2019"));

        reportData.setSquarePaintColours(2,0,0);
        reportData.setTrianglePaintColours(1,1,0);
        reportData.setCirclePaintColours(1,1,1);

        CuttingReport cuttingReport = new CuttingReport(reportData);

        Assertions.assertEquals("\n\nYour cutting report has been generated: \n\n" +
                "Name: Mark Pearl, Address: 1 Bob Ave, Due Date: 19/01/2019\n\n" +

                "|          | Qty |\n" +
                "|  square  |  2  |\n" +
                "| triangle |  2  |\n" +
                "|  circle  |  3  |\n\n"
                , cuttingReport.printReport());
    }

}

