import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTests {

    @Test
    void invoiceHasCorrectNumberOfSquares() {
        Order order = new Order();
        order.add(new Block(PaintColour.BLUE, Shape.SQUARE));
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Invoice invoice = invoiceGenerator.createInvoice(order);

        Assertions.assertEquals(1, invoice.getSquareCounter(), "Not the correct number of squares in the order");
    }

    @Test
    void invoiceHasCorrectNumberOfTriangles() {
        Order order = new Order();
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Invoice invoice = invoiceGenerator.createInvoice(order);

        Assertions.assertEquals(1, invoice.getTriangleCounter(), "Not the correct number of triangles in the order");
    }

    @Test
    void invoiceHasCorrectNumberOfCircles() {
        Order order = new Order();
        order.add(new Block(PaintColour.BLUE, Shape.CIRCLE));
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Invoice invoice = invoiceGenerator.createInvoice(order);

        Assertions.assertEquals(1, invoice.getCircleCounter(), "Not the correct number of circles in the order");
    }

    @Test
    void invoiceAddsRedSurchargeWhenRedIsInOrder() {
        Order order = new Order();
        order.add(new Block(PaintColour.RED, Shape.CIRCLE));
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Invoice invoice = invoiceGenerator.createInvoice(order);

        Assertions.assertEquals(1, invoice.getRedSurcharge(), "Not the correct number of red paint items in the order");
    }

    @Test
    void invoiceHasCorrectNumberOfYellowItemsInOrder() {
        Order order = new Order();
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Invoice invoice = invoiceGenerator.createInvoice(order);

        Assertions.assertEquals(1, invoice.getYellowPaintColour(), "Not the correct number of yellow paint items in the order");
    }

}
