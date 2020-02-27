
import java.util.HashMap;
import java.util.Map;

public class InvoiceGenerator {


    Map<Shape, Integer> shapePrices = new HashMap<>();

    public InvoiceGenerator() {
        shapePrices.put(Shape.SQUARE, 1);
        shapePrices.put(Shape.TRIANGLE, 2);
        shapePrices.put(Shape.CIRCLE, 3);
    }

    public Invoice createInvoice(Order order) {
        int sumOfCosts = 0;
        int squareCounter = 0;
        int triangleCounter = 0;
        int circleCounter = 0;
        int redSurcharge = 0;
        int bluePaintColour = 0;
        int yellowPaintColour = 0;


        for (Block block : order.getBlocks()) {
            sumOfCosts += getPrice(block);
            if (block.getShape().equals(Shape.SQUARE)) {
                squareCounter++;
            }
            if (block.getShape().equals(Shape.TRIANGLE)) {
                triangleCounter++;
            }
            if (block.getShape().equals(Shape.CIRCLE)) {
                circleCounter++;
            }
            if (block.getPaintcolour().equals(PaintColour.RED)) {
                redSurcharge++;
            }
            if (block.getPaintcolour().equals(PaintColour.BLUE)) {
                bluePaintColour++;
            }
            if (block.getPaintcolour().equals(PaintColour.YELLOW)) {
                yellowPaintColour++;
            }
        }
        Invoice invoice = new Invoice(sumOfCosts, squareCounter, triangleCounter, circleCounter, redSurcharge, bluePaintColour, yellowPaintColour);
        return invoice;

    }


    private Integer getPrice(Block block) {
        if (block.getPaintcolour().equals(PaintColour.RED)) {
            return shapePrices.get(block.getShape()) + 1;
        }
        return shapePrices.get(block.getShape());

    }

}
