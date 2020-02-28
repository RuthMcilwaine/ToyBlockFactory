import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;


public class AcceptanceTest {

    @Test
    void canGetTotalPriceOfAllItemsInOrder() {
//        Customer customer = new Customer("Mark Pearl", "Somewhere, Aus");

        Order order = new Order();

        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.YELLOW, Shape.SQUARE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));

        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Invoice invoice = invoiceGenerator.createInvoice(order);

        Assertions.assertEquals(16, invoice.getTotalPrice());

    }

    @Test
    void canGenerateANewInvoiceReport() {

//        Customer customer = new Customer("Mark Pearl", "Somewhere, Aus");
        Order order = new Order();

        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.YELLOW, Shape.SQUARE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));

        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Invoice invoice = invoiceGenerator.createInvoice(order);

        Assertions.assertEquals(2, invoice.getSquareCounter(), "Not the correct number of squares in the order");

    }

    @Test
    void canGeneratePaintingReportFromTheOrder() {

//        Customer customer = new Customer("Mark Pearl", "Somewhere, Aus");
        Order order = new Order();

        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.YELLOW, Shape.SQUARE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        order.add(new Block(PaintColour.BLUE, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));

        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Invoice invoice = invoiceGenerator.createInvoice(order);

        Assertions.assertEquals(3, invoice.getBluePaintColour(), "Not the correct number of blue paint items in the order");
    }
}


