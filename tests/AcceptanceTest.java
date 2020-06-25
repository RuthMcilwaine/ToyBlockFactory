import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;


class AcceptanceTest {
    Order order = new Order();
    ReportGenerator reportGenerator = new ReportGenerator();

    @Test
    void canGetTotalPriceOfAllItemsInOrder() {

        addBlocksToOrder();

        Report report = reportGenerator.createInvoiceReport(order);
        Assertions.assertEquals(16, report.getReportData().getSumOfCosts());
    }

    @Test
    void canGenerateANewInvoiceReport() {

        addBlocksToOrder();

        Report report = reportGenerator.createInvoiceReport(order);
        Assertions.assertEquals(2, report.getReportData().getTotalSquareCount());
    }

    @Test
    void canGenerateBluePaintReportFromTheOrder() {

        addBlocksToOrder();

        Report report = reportGenerator.createInvoiceReport(order);
        Assertions.assertEquals(2, report.getReportData().getBlueTriangle());
    }

    private void addBlocksToOrder() {
        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.YELLOW, Shape.SQUARE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));
    }
}


