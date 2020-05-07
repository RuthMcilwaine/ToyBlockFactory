
import java.util.HashMap;
import java.util.Map;

public class InvoiceGenerator {
    private int sumOfCosts;
    private int totalSquareCount;
    private int totalTriangleCount;
    private int totalCircleCount;
    private int redSquare;
    private int blueSquare;
    private int yellowSquare;
    private int redTriangle;
    private int blueTriangle;
    private int yellowTriangle;
    private int redCircle;
    private int blueCircle;
    private int yellowCircle;


    Map<Shape, Integer> pricePerShape = new HashMap<>();

    public InvoiceGenerator() {
        pricePerShape.put(Shape.SQUARE, 1);
        pricePerShape.put(Shape.TRIANGLE, 2);
        pricePerShape.put(Shape.CIRCLE, 3);
    }

    public Invoice createInvoice(Order order) {
        for (Block block : order.getBlocks()) {
            sumOfCosts += getPrice(block);

            countSquaresPaintColoursFromOrder(block);
            countTrianglesPaintColoursFromOrder(block);
            countCirclesPaintColoursFromOrder(block);
        }

        int totalRedCount = redSquare + redTriangle + redCircle;
        int totalBlueCount = blueSquare + blueTriangle + blueCircle;
        int totalYellowCount = yellowSquare + yellowTriangle + yellowCircle;

        Invoice invoice = new Invoice(sumOfCosts, totalSquareCount, totalTriangleCount, totalCircleCount, totalRedCount, totalBlueCount, totalYellowCount);
        invoice.setSquarePaintColours(redSquare, blueSquare, yellowSquare);
        invoice.setCirclePaintColours(redCircle,blueCircle,yellowCircle);
        invoice.setTrianglePaintColours(redTriangle, blueTriangle,yellowTriangle);
        return invoice;
    }

    public Integer getPrice(Block block) {
        if (block.getPaintcolour().equals(PaintColour.RED)) {
            return pricePerShape.get(block.getShape()) + 1;
        }
        return pricePerShape.get(block.getShape());
    }

    private void countSquaresPaintColoursFromOrder(Block block) {
        if (block.getShape().equals(Shape.SQUARE)) {
            totalSquareCount++;

            redSquare = incrementingRedValue(block.getPaintcolour(), redSquare);
            blueSquare = incrementingBlueValue(block.getPaintcolour(), blueSquare);
            yellowSquare = incrementingYellowValue(block.getPaintcolour(),yellowSquare);
        }
    }

    private void countTrianglesPaintColoursFromOrder(Block block) {
        if (block.getShape().equals(Shape.TRIANGLE)) {
            totalTriangleCount++;

            redTriangle = incrementingRedValue(block.getPaintcolour(),redTriangle);
            blueTriangle = incrementingBlueValue(block.getPaintcolour(),blueTriangle);
            yellowTriangle = incrementingYellowValue(block.getPaintcolour(),yellowTriangle);
        }
    }


    private void countCirclesPaintColoursFromOrder(Block block) {
        if (block.getShape().equals(Shape.CIRCLE)) {
            totalCircleCount++;

            redCircle = incrementingRedValue(block.getPaintcolour(), redCircle);
            blueCircle = incrementingBlueValue(block.getPaintcolour(),blueCircle);
            yellowCircle = incrementingYellowValue(block.getPaintcolour(),yellowCircle);
        }
    }

    private int incrementingRedValue(PaintColour paintColour, int redValue) {
        if (paintColour.equals(PaintColour.RED)) {
            redValue++;
        }
        return redValue;
    }

    private int incrementingBlueValue(PaintColour paintColour, int blueValue) {
        if(paintColour.equals(PaintColour.BLUE)) {
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
