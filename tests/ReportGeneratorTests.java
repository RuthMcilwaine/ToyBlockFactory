import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReportGeneratorTests {
    private Order order = new Order();
    private ReportGenerator reportGenerator = new ReportGenerator();

    @Test
    void invoiceHasCorrectNumberOfSquares() {
        order.add(new Block(PaintColour.BLUE, Shape.SQUARE));
        Report report = reportGenerator.createInvoiceReport(order);

        Assertions.assertEquals(1, report.getReportData().getTotalSquareCount(), "Not the correct number of squares in the order");
    }

    @Test
    void invoiceHasCorrectNumberOfTriangles() {
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        Report report = reportGenerator.createInvoiceReport(order);

        Assertions.assertEquals(1, report.getReportData().getTriangleCounter(), "Not the correct number of triangles in the order");
    }

    @Test
    void invoiceHasCorrectNumberOfCircles() {
        order.add(new Block(PaintColour.BLUE, Shape.CIRCLE));
        Report report = reportGenerator.createInvoiceReport(order);

        Assertions.assertEquals(1, report.getReportData().getCircleCounter(), "Not the correct number of circles in the order");
    }

    @Test
    void invoiceAddsRedSurchargeWhenRedIsInOrder() {
        order.add(new Block(PaintColour.RED, Shape.CIRCLE));
        Report report = reportGenerator.createInvoiceReport(order);

        Assertions.assertEquals(1, report.getReportData().getTotalRedCount(), "Not the correct number of red paint items in the order");
    }

    @Test
    void invoiceHasCorrectNumberOfYellowCirclesInOrder() {
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));
        Report report = reportGenerator.createInvoiceReport(order);

        Assertions.assertEquals(1, report.getReportData().getYellowCircle(), "Not the correct number of yellow paint items in the order");
    }

    @Test
    void invoiceAddsRedSquareWhenInOrder() {
        Customer customer = new Customer("Mark Pearl", "1 Bob Ave", "19/01/2019");
        order.add(new Block(PaintColour.RED, Shape.SQUARE));

        Report report = reportGenerator.createInvoiceReport(order);
        report.getReportData().setCustomerDetails(customer);

        Assertions.assertEquals(1, report.getReportData().getRedSquare(), "Not the correct number of red paint items in the order");
        Assertions.assertEquals("\n\nYour invoice report has been generated: \n\n" +
                "Name: Mark Pearl, Address: 1 Bob Ave, Due Date: 19/01/2019\n\n" +
                "|          | red | blue | yellow | " + "\n" +
                "|  square  |  1  |  0   |   0    | " + "\n" +
                "| triangle |  0  |  0   |   0    | " + "\n" +
                "|  circle  |  0  |  0   |   0    | " + "\n" +
                "Squares 1 @ $1 ppi =  $1" + "\n" +
                "Triangles 0 @ $2 ppi =  $0" + "\n" +
                "Circles 0 @ $3 ppi =  $0" + "\n" +
                "Red colour surcharge 1 @ $1 ppi =  $1\n\n" +

                "Total:  $2\n\n", report.printReport());
    }

    @Test
    void invoiceAddsRedTriangleWhenInOrder() {
        Customer customer = new Customer("Mark Pearl", "1 Bob Ave", "19/01/2019");
        order.add(new Block(PaintColour.RED, Shape.TRIANGLE));

        Report report = reportGenerator.createInvoiceReport(order);
        report.getReportData().setCustomerDetails(customer);

        Assertions.assertEquals(1, report.getReportData().getRedTriangle(), "Not the correct number of red paint items in the order");
        Assertions.assertEquals("\n\nYour invoice report has been generated: \n\n" +
                "Name: Mark Pearl, Address: 1 Bob Ave, Due Date: 19/01/2019\n\n" +
                "|          | red | blue | yellow | " + "\n" +
                "|  square  |  0  |  0   |   0    | " + "\n" +
                "| triangle |  1  |  0   |   0    | " + "\n" +
                "|  circle  |  0  |  0   |   0    | " + "\n" +
                "Squares 0 @ $1 ppi =  $0" + "\n" +
                "Triangles 1 @ $2 ppi =  $2" + "\n" +
                "Circles 0 @ $3 ppi =  $0" + "\n" +
                "Red colour surcharge 1 @ $1 ppi =  $1\n\n" +

                "Total:  $3\n\n", report.printReport());
    }

    @Test
    void invoiceDisplayShowsRedCircleWhenOneIsOrdered() {
        Customer customer = new Customer("Mark Pearl", "1 Bob Ave", "19/01/2019");
        order.add(new Block(PaintColour.RED, Shape.CIRCLE));

        Report report = reportGenerator.createInvoiceReport(order);
        report.getReportData().setCustomerDetails(customer);
        Assertions.assertEquals(1, report.getReportData().getRedCircle(), "Not the correct number of red paint items in the order");
        Assertions.assertEquals("\n\nYour invoice report has been generated: \n\n" +
                "Name: Mark Pearl, Address: 1 Bob Ave, Due Date: 19/01/2019\n\n" +

                "|          | red | blue | yellow | " + "\n" +
                "|  square  |  0  |  0   |   0    | " + "\n" +
                "| triangle |  0  |  0   |   0    | " + "\n" +
                "|  circle  |  1  |  0   |   0    | " + "\n" +
                "Squares 0 @ $1 ppi =  $0" + "\n" +
                "Triangles 0 @ $2 ppi =  $0" + "\n" +
                "Circles 1 @ $3 ppi =  $3" + "\n" +
                "Red colour surcharge 1 @ $1 ppi =  $1\n\n" +

                "Total:  $4\n\n", report.printReport());
    }

    @Test
    void invoiceDisplayWhenOrderIsEmpty() {

        Report report = new ReportStub();
        Assertions.assertEquals("", report.printReport());
    }
}
