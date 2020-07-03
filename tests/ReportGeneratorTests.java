import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReportGeneratorTests {
    private Order order = new Order();
    private ReportGenerator reportGenerator = new ReportGenerator();

    private void addBlocksToOrder() {
        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.YELLOW, Shape.SQUARE));
        order.add(new Block(PaintColour.RED, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.RED, Shape.CIRCLE));
        order.add(new Block(PaintColour.BLUE, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));
    }

    @Test
    void reportHasNoBlueSquaresWhenNoneInOrder() {
        addBlocksToOrder();
        Report report = reportGenerator.createInvoiceReport(order);
        Assertions.assertEquals(0, report.getReportData().getBlueSquare());
    }

    @Test
    void reportHasTwoBlueTrianglesWhenInOrder() {
        addBlocksToOrder();
        Report report = reportGenerator.createInvoiceReport(order);

        Assertions.assertEquals(2, report.getReportData().getBlueTriangle());
    }

    @Test
    void reportHasOneBlueCircleWhenInOrder() {
        addBlocksToOrder();
        Report report = reportGenerator.createInvoiceReport(order);

        Assertions.assertEquals(1, report.getReportData().getBlueCircle());
    }

    @Test
    void reportAddsRedSurchargeWhenRedIsInOrder() {
        order.add(new Block(PaintColour.RED, Shape.CIRCLE));
        Report report = reportGenerator.createInvoiceReport(order);

        Assertions.assertEquals(4, report.getReportData().getSumOfCosts());
    }

    @Test
    void reportHasOneRedSquareWhenInOrder() {
        addBlocksToOrder();
        Report report = reportGenerator.createInvoiceReport(order);

        Assertions.assertEquals(1, report.getReportData().getRedSquare());
    }

    @Test
    void reportHasOneRedTriangleWhenInOrder() {
        addBlocksToOrder();
        Report report = reportGenerator.createInvoiceReport(order);

        Assertions.assertEquals(1, report.getReportData().getRedTriangle());
    }

    @Test
    void reportHasOneRedCircleWhenInOrder() {
        addBlocksToOrder();
        Report report = reportGenerator.createInvoiceReport(order);

        Assertions.assertEquals(1, report.getReportData().getRedCircle());
    }

    @Test
    void reportHasTwoYellowCirclesWhenInOrder() {
        addBlocksToOrder();
        Report report = reportGenerator.createInvoiceReport(order);

        Assertions.assertEquals(2, report.getReportData().getYellowCircle());
    }

    @Test
    void canGetTotalPriceOfItemsInOrder() {
        addBlocksToOrder();
        Report report = reportGenerator.createInvoiceReport(order);

        Assertions.assertEquals(23, report.getReportData().getSumOfCosts());
    }

    @Test
    void canGetTotalSquaresFromOrder() {
        addBlocksToOrder();

        Report report = reportGenerator.createInvoiceReport(order);
        Assertions.assertEquals(2, report.getReportData().getTotalSquareCount());
    }


    @Test
    void canGetSameTotalSquaresCountWhenCallingThreeTimes() {
        addBlocksToOrder();

        Report report = reportGenerator.createInvoiceReport(order);
        Assertions.assertEquals(2, report.getReportData().getTotalSquareCount());

        Report report2 = reportGenerator.createCuttingReport(order);
        Assertions.assertEquals(2, report2.getReportData().getTotalSquareCount());

        Report report3 = reportGenerator.createPaintingReport(order);
        Assertions.assertEquals(2, report3.getReportData().getTotalSquareCount());
    }


}
