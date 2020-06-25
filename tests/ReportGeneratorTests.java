import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReportGeneratorTests {
    private Order order = new Order();
    private ReportGenerator reportGenerator = new ReportGenerator();

    @Test
    void invoiceHasCorrectNumberOfSquares() {
        order.add(new Block(PaintColour.BLUE, Shape.SQUARE));
        Report report = reportGenerator.createInvoiceReport(order);

        Assertions.assertEquals(1, report.getReportData().getTotalSquareCount());
    }

    @Test
    void invoiceHasCorrectNumberOfTriangles() {
        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
        Report report = reportGenerator.createInvoiceReport(order);

        Assertions.assertEquals(1, report.getReportData().getTotalTriangleCount());
    }

    @Test
    void invoiceHasCorrectNumberOfCircles() {
        order.add(new Block(PaintColour.BLUE, Shape.CIRCLE));
        Report report = reportGenerator.createInvoiceReport(order);



        Assertions.assertEquals(1, report.getReportData().getTotalCircleCount());
    }

    @Test
    void invoiceAddsRedSurchargeWhenRedIsInOrder() {
        order.add(new Block(PaintColour.RED, Shape.CIRCLE));
        Report report = reportGenerator.createInvoiceReport(order);

        Assertions.assertEquals(1, report.getReportData().getTotalRedCount());
    }

    @Test
    void invoiceHasCorrectNumberOfYellowCirclesInOrder() {
        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));
        Report report = reportGenerator.createInvoiceReport(order);

        Assertions.assertEquals(1, report.getReportData().getYellowCircle());
    }

    @Test
    void invoiceAddsRedSquareWhenInOrder() {
        Customer customer = new Customer("Mark Pearl", "1 Bob Ave", "19/01/2019");
        order.add(new Block(PaintColour.RED, Shape.SQUARE));

        Report report = reportGenerator.createInvoiceReport(order);
        report.getReportData().setCustomerDetails(customer);

        Assertions.assertEquals(1, report.getReportData().getRedSquare());
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

        Assertions.assertEquals(1, report.getReportData().getRedTriangle());
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
        Assertions.assertEquals(1, report.getReportData().getRedCircle());
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

}
