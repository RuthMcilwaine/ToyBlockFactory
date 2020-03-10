
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

            Counter orderCounter = new Counter(squareCounter, triangleCounter, circleCounter, redSurcharge, bluePaintColour, yellowPaintColour, block).invoke();
            squareCounter = orderCounter.getSquareCounter();
            triangleCounter = orderCounter.getTriangleCounter();
            circleCounter = orderCounter.getCircleCounter();
            redSurcharge = orderCounter.getRedSurcharge();
            bluePaintColour = orderCounter.getBluePaintColour();
            yellowPaintColour = orderCounter.getYellowPaintColour();
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
