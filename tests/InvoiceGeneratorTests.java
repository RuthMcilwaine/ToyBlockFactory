import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTests {
    Order order = new Order();
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @Test
    void invoiceHasCorrectNumberOfSquares() {
        order.add(new Block(PaintColour.BLUE, Shape.SQUARE));
        Invoice invoice = invoiceGenerator.createInvoice(order);

        Assertions.assertEquals(1, invoice.getTotalSquareCount(), "Not the correct number of squares in the order");
    }

    @Test
    void invoiceHasCorrectNumberOfTriangles() {
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        Invoice invoice = invoiceGenerator.createInvoice(order);

        Assertions.assertEquals(1, invoice.getTriangleCounter(), "Not the correct number of triangles in the order");
    }

    @Test
    void invoiceHasCorrectNumberOfCircles() {
        order.add(new Block(PaintColour.BLUE, Shape.CIRCLE));
        Invoice invoice = invoiceGenerator.createInvoice(order);

        Assertions.assertEquals(1, invoice.getCircleCounter(), "Not the correct number of circles in the order");
    }

    @Test
    void invoiceAddsRedSurchargeWhenRedIsInOrder() {
        order.add(new Block(PaintColour.RED, Shape.CIRCLE));
        Invoice invoice = invoiceGenerator.createInvoice(order);

        Assertions.assertEquals(1, invoice.getTotalRedCount(), "Not the correct number of red paint items in the order");
    }

    @Test
    void invoiceHasCorrectNumberOfYellowCirclesInOrder() {
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));
        Invoice invoice = invoiceGenerator.createInvoice(order);

        Assertions.assertEquals(1, invoice.getYellowCircle(), "Not the correct number of yellow paint items in the order");
    }

    @Test
    void invoiceAddsRedSquareWhenInOrder() {
        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        Invoice invoice = invoiceGenerator.createInvoice(order);

        Assertions.assertEquals(1, invoice.getRedSquare(), "Not the correct number of red paint items in the order");
        Assertions.assertEquals("Your invoice report has been generated: " + "\n" +
                "|          | red | blue | yellow | " + "\n" +
                "|  square  |  1  |  0   |   0    | " + "\n" +
                "| triangle |  0  |  0   |   0    | " + "\n" +
                "|  circle  |  0  |  0   |   0    | " + "\n" +
                "Squares 1 @ $1 ppi =  $1" + "\n" +
                "Triangles 0 @ $2 ppi =  $0" + "\n" +
                "Circles 0 @ $3 ppi =  $0" + "\n" +
                "Red colour surcharge 1 @ $1 ppi =  $1" + "\n" + "\n" +

                "Total:  $2", invoice.toString());
    }

    @Test
    void invoiceAddsRedTriangleWhenInOrder() {
        order.add(new Block(PaintColour.RED, Shape.TRIANGLE));
        Invoice invoice = invoiceGenerator.createInvoice(order);

        Assertions.assertEquals(1, invoice.getRedTriangle(), "Not the correct number of red paint items in the order");
        Assertions.assertEquals("Your invoice report has been generated: " + "\n" +
                "|          | red | blue | yellow | " + "\n" +
                "|  square  |  0  |  0   |   0    | " + "\n" +
                "| triangle |  1  |  0   |   0    | " + "\n" +
                "|  circle  |  0  |  0   |   0    | " + "\n" +
                "Squares 0 @ $1 ppi =  $0" + "\n" +
                "Triangles 1 @ $2 ppi =  $2" + "\n" +
                "Circles 0 @ $3 ppi =  $0" + "\n" +
                "Red colour surcharge 1 @ $1 ppi =  $1" + "\n" + "\n" +

                "Total:  $3", invoice.toString());
    }

    @Test
    void invoiceAddsRedCircleWhenInOrder() {
        order.add(new Block(PaintColour.RED, Shape.CIRCLE));
        Invoice invoice = invoiceGenerator.createInvoice(order);

        Assertions.assertEquals(1, invoice.getRedCircle(), "Not the correct number of red paint items in the order");
        Assertions.assertEquals("Your invoice report has been generated: " + "\n" +
                "|          | red | blue | yellow | " + "\n" +
                "|  square  |  0  |  0   |   0    | " + "\n" +
                "| triangle |  0  |  0   |   0    | " + "\n" +
                "|  circle  |  1  |  0   |   0    | " + "\n" +
                "Squares 0 @ $1 ppi =  $0" + "\n" +
                "Triangles 0 @ $2 ppi =  $0" + "\n" +
                "Circles 1 @ $3 ppi =  $3" + "\n" +
                "Red colour surcharge 1 @ $1 ppi =  $1" + "\n" + "\n" +

                "Total:  $4", invoice.toString());
    }
}
