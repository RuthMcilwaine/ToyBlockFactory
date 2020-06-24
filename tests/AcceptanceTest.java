import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class AcceptanceTest {
    Order order = new Order();
    ReportGenerator reportGenerator = new ReportGenerator();

    @Test
    void canGetTotalPriceOfAllItemsInOrder() {

        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.YELLOW, Shape.SQUARE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));

        Report report = reportGenerator.createInvoiceReport(order);
        Assertions.assertEquals(16, report.getReportData().getSumOfCosts());
    }

    @Test
    void canGenerateANewInvoiceReport() {

        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.YELLOW, Shape.SQUARE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));

        Report report = reportGenerator.createInvoiceReport(order);
        Assertions.assertEquals(2, report.getReportData().getTotalSquareCount(), "Not the correct number of squares in the order");
    }

    @Test
    void canGenerateBluePaintReportFromTheOrder() {

        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.YELLOW, Shape.SQUARE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));

        Report report = reportGenerator.createInvoiceReport(order);
        Assertions.assertEquals(3, report.getReportData().getTotalBlueCount(), "Not the correct number of blue paint items in the order");
    }
}


