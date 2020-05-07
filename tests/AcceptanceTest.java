import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AcceptanceTest {

    @Test
    void canGetTotalPriceOfAllItemsInOrder() {
        Customer customer = new Customer("Mark Pearl" , "Somewhere, Aus", "19 Oct 2019");
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

        Assertions.assertEquals(16, invoice.getSumOfCosts());

    }

    @Test
    void canGenerateANewInvoiceReport() {

        Customer customer = new Customer("Mark Pearl" , "Somewhere, Aus", "19 Oct 2019");
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

        Assertions.assertEquals(2, invoice.getTotalSquareCount(), "Not the correct number of squares in the order");

    }

    @Test
    void canGenerateBluePaintReportFromTheOrder() {

        Customer customer = new Customer("Mark Pearl" , "Somewhere, Aus", "19 Oct 2019");
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

        Assertions.assertEquals(3, invoice.getTotalBlueCount(), "Not the correct number of blue paint items in the order");
    }
}


