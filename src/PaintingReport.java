public class PaintingReport implements Report {

    private final ReportData reportData;


    public PaintingReport(ReportData reportData) {
        this.reportData = reportData;
    }

    @Override
    public ReportData getReportData() {
        return reportData;
    }

    @Override
    public String printReport() {
        return "\n\nYour painting report has been generated: \n\n" +

                getReportData().getCustomerDetails() + ", Order #: " + getReportData().getOrderId() + "\n\n" +

                "|          | red | blue | yellow | \n" +
                "|  square  |  " + getReportData().getRedSquare() + "  |  " + getReportData().getBlueSquare() + "   |   " + getReportData().getYellowSquare() + "    | \n"
                + "| triangle |  " + getReportData().getRedTriangle() + "  |  " + getReportData().getBlueTriangle() + "   |   " + getReportData().getYellowTriangle() + "    | \n"
                + "|  circle  |  " + getReportData().getRedCircle() + "  |  " + getReportData().getBlueCircle() + "   |   " + getReportData().getYellowCircle() + "    | \n" +
                "| hexagon |  " + getReportData().getRedHexagon() + "  |  " + getReportData().getBlueHexagon() + "   |   " + getReportData().getYellowHexagon() + "    | \n\n";

    }
}
