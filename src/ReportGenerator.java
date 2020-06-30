import java.util.HashMap;
import java.util.Map;

class ReportGenerator {
    private int redSquare;
    private int blueSquare;
    private int yellowSquare;
    private int redTriangle;
    private int blueTriangle;
    private int yellowTriangle;
    private int redCircle;
    private int blueCircle;
    private int yellowCircle;

    private Map<Shape, Integer> pricePerShape = new HashMap<>();

    public ReportGenerator() {
        pricePerShape.put(Shape.SQUARE, 1);
        pricePerShape.put(Shape.TRIANGLE, 2);
        pricePerShape.put(Shape.CIRCLE, 3);
    }

    public Report createInvoiceReport(Order order) {
        ReportData reportData = getReportData(order);
        return new InvoiceReport(reportData);
    }

    public Report createCuttingReport(Order order) {
        ReportData reportData = getReportData(order);
        return new CuttingReport(reportData);
    }

    public Report createPaintingReport(Order order) {
        ReportData reportData = getReportData(order);
        return new PaintingReport(reportData);
    }

    private ReportData getReportData(Order order) {
        Customer customerDetails = order.getCustomer();
        int sumOfCosts = 0;

        for (Block block : order.getBlocks()) {
            sumOfCosts += getPrice(block);

            countSquaresPaintColoursFromOrder(block);
            countTrianglesPaintColoursFromOrder(block);
            countCirclesPaintColoursFromOrder(block);
        }

        ReportData reportData = new ReportData();
        reportData.setCustomerDetails(customerDetails);
        reportData.setOrderId(order.getOrderId());
        reportData.setSquarePaintColours(redSquare, blueSquare, yellowSquare);
        reportData.setCirclePaintColours(redCircle, blueCircle, yellowCircle);
        reportData.setTrianglePaintColours(redTriangle, blueTriangle, yellowTriangle);
        reportData.setSumOfCosts(sumOfCosts);
        return reportData;
    }

    private Integer getPrice(Block block) {
        if (block.getPaintColour().equals(PaintColour.RED)) {
            return pricePerShape.get(block.getShape()) + 1;
        }
        return pricePerShape.get(block.getShape());
    }


    private void countSquaresPaintColoursFromOrder(Block block) {
        if (block.getShape().equals(Shape.SQUARE)) {

            redSquare = incrementingRedValue(block.getPaintColour(), redSquare);
            blueSquare = incrementingBlueValue(block.getPaintColour(), blueSquare);
            yellowSquare = incrementingYellowValue(block.getPaintColour(), yellowSquare);
        }
    }

    private void countTrianglesPaintColoursFromOrder(Block block) {
        if (block.getShape().equals(Shape.TRIANGLE)) {

            redTriangle = incrementingRedValue(block.getPaintColour(), redTriangle);
            blueTriangle = incrementingBlueValue(block.getPaintColour(), blueTriangle);
            yellowTriangle = incrementingYellowValue(block.getPaintColour(), yellowTriangle);
        }
    }


    private void countCirclesPaintColoursFromOrder(Block block) {
        if (block.getShape().equals(Shape.CIRCLE)) {

            redCircle = incrementingRedValue(block.getPaintColour(), redCircle);
            blueCircle = incrementingBlueValue(block.getPaintColour(), blueCircle);
            yellowCircle = incrementingYellowValue(block.getPaintColour(), yellowCircle);
        }
    }

    private int incrementingRedValue(PaintColour paintColour, int redValue) {
        if (paintColour.equals(PaintColour.RED)) {
            redValue++;
        }
        return redValue;
    }

    private int incrementingBlueValue(PaintColour paintColour, int blueValue) {
        if (paintColour.equals(PaintColour.BLUE)) {
            blueValue++;
        }
        return blueValue;
    }

    private int incrementingYellowValue(PaintColour paintColour, int yellowValue) {
        if (paintColour.equals(PaintColour.YELLOW)) {
            yellowValue++;
        }
        return yellowValue;
    }
}
