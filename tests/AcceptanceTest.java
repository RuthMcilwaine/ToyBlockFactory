import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AcceptanceTest {
    Order order = new Order();
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @Test
    void canGetTotalPriceOfAllItemsInOrder() {

        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.YELLOW, Shape.SQUARE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));

        Invoice invoice = invoiceGenerator.createInvoice(order);
        Assertions.assertEquals(16, invoice.getSumOfCosts());
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

        Invoice invoice = invoiceGenerator.createInvoice(order);
        Assertions.assertEquals(2, invoice.getTotalSquareCount(), "Not the correct number of squares in the order");
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

        Invoice invoice = invoiceGenerator.createInvoice(order);
        Assertions.assertEquals(3, invoice.getTotalBlueCount(), "Not the correct number of blue paint items in the order");
    }
}


