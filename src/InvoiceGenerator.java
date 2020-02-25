
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
        }
        Invoice invoice = new Invoice(sumOfCosts);
        return invoice;
    }


    private Integer getPrice(Block block) {
        if (block.getPaintcolour().equals(PaintColour.RED)) {
            return shapePrices.get(block.getShape()) + 1;
        }
        return shapePrices.get(block.getShape());

    }

}
