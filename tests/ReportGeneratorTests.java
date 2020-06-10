//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//public class ReportGeneratorTests {
//    Order order = new Order();
//    ReportGenerator reportGenerator = new ReportGenerator();
//
//    @Test
//    void invoiceHasCorrectNumberOfSquares() {
//        order.add(new Block(PaintColour.BLUE, Shape.SQUARE));
//        Report report = reportGenerator.createInvoice(order);
//
//        Assertions.assertEquals(1, report.getTotalSquareCount(), "Not the correct number of squares in the order");
//    }
//
//    @Test
//    void invoiceHasCorrectNumberOfTriangles() {
//        order.add(new Block(PaintColour.BLUE, Shape.TRIANGLE));
//        Report report = reportGenerator.createInvoice(order);
//
//        Assertions.assertEquals(1, report.getTriangleCounter(), "Not the correct number of triangles in the order");
//    }
//
//    @Test
//    void invoiceHasCorrectNumberOfCircles() {
//        order.add(new Block(PaintColour.BLUE, Shape.CIRCLE));
//        Report report = reportGenerator.createInvoice(order);
//
//        Assertions.assertEquals(1, report.getCircleCounter(), "Not the correct number of circles in the order");
//    }
//
//    @Test
//    void invoiceAddsRedSurchargeWhenRedIsInOrder() {
//        order.add(new Block(PaintColour.RED, Shape.CIRCLE));
//        Report report = reportGenerator.createInvoice(order);
//
//        Assertions.assertEquals(1, report.getTotalRedCount(), "Not the correct number of red paint items in the order");
//    }
//
//    @Test
//    void invoiceHasCorrectNumberOfYellowCirclesInOrder() {
//        order.add(new Block(PaintColour.YELLOW, Shape.CIRCLE));
//        Report report = reportGenerator.createInvoice(order);
//
//        Assertions.assertEquals(1, report.getYellowCircle(), "Not the correct number of yellow paint items in the order");
//    }
//
//    @Test
//    void invoiceAddsRedSquareWhenInOrder() {
//        order.add(new Block(PaintColour.RED, Shape.SQUARE));
//        Report report = reportGenerator.createInvoice(order);
//
//        Assertions.assertEquals(1, report.getRedSquare(), "Not the correct number of red paint items in the order");
//        Assertions.assertEquals("Your invoice report has been generated: " + "\n" +
//                "|          | red | blue | yellow | " + "\n" +
//                "|  square  |  1  |  0   |   0    | " + "\n" +
//                "| triangle |  0  |  0   |   0    | " + "\n" +
//                "|  circle  |  0  |  0   |   0    | " + "\n" +
//                "Squares 1 @ $1 ppi =  $1" + "\n" +
//                "Triangles 0 @ $2 ppi =  $0" + "\n" +
//                "Circles 0 @ $3 ppi =  $0" + "\n" +
//                "Red colour surcharge 1 @ $1 ppi =  $1" + "\n" + "\n" +
//
//                "Total:  $2", report.toString());
//    }
//
//    @Test
//    void invoiceAddsRedTriangleWhenInOrder() {
//        order.add(new Block(PaintColour.RED, Shape.TRIANGLE));
//        Report report = reportGenerator.createInvoice(order);
//
//        Assertions.assertEquals(1, report.getRedTriangle(), "Not the correct number of red paint items in the order");
//        Assertions.assertEquals("Your invoice report has been generated: " + "\n" +
//                "|          | red | blue | yellow | " + "\n" +
//                "|  square  |  0  |  0   |   0    | " + "\n" +
//                "| triangle |  1  |  0   |   0    | " + "\n" +
//                "|  circle  |  0  |  0   |   0    | " + "\n" +
//                "Squares 0 @ $1 ppi =  $0" + "\n" +
//                "Triangles 1 @ $2 ppi =  $2" + "\n" +
//                "Circles 0 @ $3 ppi =  $0" + "\n" +
//                "Red colour surcharge 1 @ $1 ppi =  $1" + "\n" + "\n" +
//
//                "Total:  $3", report.toString());
//    }
//
//    @Test
//    void invoiceAddsRedCircleWhenInOrder() {
//        order.add(new Block(PaintColour.RED, Shape.CIRCLE));
//        Report report = reportGenerator.createInvoice(order);
//
//        Assertions.assertEquals(1, report.getRedCircle(), "Not the correct number of red paint items in the order");
//        Assertions.assertEquals("Your invoice report has been generated: " + "\n" +
//                "|          | red | blue | yellow | " + "\n" +
//                "|  square  |  0  |  0   |   0    | " + "\n" +
//                "| triangle |  0  |  0   |   0    | " + "\n" +
//                "|  circle  |  1  |  0   |   0    | " + "\n" +
//                "Squares 0 @ $1 ppi =  $0" + "\n" +
//                "Triangles 0 @ $2 ppi =  $0" + "\n" +
//                "Circles 1 @ $3 ppi =  $3" + "\n" +
//                "Red colour surcharge 1 @ $1 ppi =  $1" + "\n" + "\n" +
//
//                "Total:  $4", report.toString());
//    }
//}
