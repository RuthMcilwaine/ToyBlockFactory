import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CuttingReportTests {
    Order order = new Order();
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @Test
    void canGenerateANewCuttingReport() {
        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.YELLOW, Shape.SQUARE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));

        Invoice invoice = invoiceGenerator.createCuttingReport(order);
        Assertions.assertEquals(2, invoice.getTotalSquareCount(), "Not the correct number of squares in the order");
    }

}

