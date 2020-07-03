public class InvoiceReport implements Report {

    private final ReportData reportData;

    public InvoiceReport(ReportData reportData) {
        this.reportData = reportData;
    }

    @Override
    public ReportData getReportData() {
        return reportData;
    }

    @Override
    public String printReport() {
        return  "\n\nYour invoice report has been generated: \n\n" +

                getReportData().getCustomerDetails() + ", Order #: " + getReportData().getOrderId() + "\n\n" +

                "|          | red | blue | yellow | \n" +
                "|  square  |  " + getReportData().getRedSquare() + "  |  " + getReportData().getBlueSquare() + "   |   " + getReportData().getYellowSquare() + "    | \n"
                + "| triangle |  "  + getReportData().getRedTriangle() + "  |  "  + getReportData().getBlueTriangle() +  "   |   "  + getReportData().getYellowTriangle() +  "    | \n"
                + "|  circle  |  " + getReportData().getRedCircle()+ "  |  " + getReportData().getBlueCircle() + "   |   " + getReportData().getYellowCircle() + "    | \n" +
                 "|  hexagon  |  " + getReportData().getRedHexagon()+ "  |  " + getReportData().getBlueHexagon() + "   |   " + getReportData().getYellowHexagon() + "    | \n" +

                "Squares " + getReportData().getTotalSquareCount() + " @ $1 ppi =  $" + getReportData().getTotalSquareCount() + "\n" +
                "Triangles " + getReportData().getTotalTriangleCount() + " @ $2 ppi =  $" + getReportData().getTotalTriangleCount() * 2 + "\n" +
                "Circles " + getReportData().getTotalCircleCount() + " @ $3 ppi =  $" + getReportData().getTotalCircleCount() * 3 + "\n" +

                "Hexagon " + getReportData().getTotalHexagonCount() + " @ $4 ppi =  $" + getReportData().getTotalHexagonCount() * 4 + "\n" +
                "Red colour surcharge " + getReportData().getTotalRedCount() + " @ $1 ppi =  $" + getReportData().getTotalRedCount() + "\n\n" +
                "Total:  $" + getReportData().getSumOfCosts() + "\n\n";
    }
}
