
public class CuttingReport implements Report {

    private final ReportData reportData;

    public CuttingReport(ReportData reportData) {
        this.reportData = reportData;
    }

    @Override
    public ReportData getReportData() {
        return reportData;
    }

    @Override
    public String printReport() {
        return "\n\nYour cutting report has been generated: \n\n" +

                getReportData().getCustomerDetails() + ", Order #: " + getReportData().getOrderId() + "\n\n" +
                "|          | Qty |\n" +
                "|  square  |  " + getReportData().getTotalSquareCount() + "  |\n"
                + "| triangle |  " + getReportData().getTotalTriangleCount() + "  |\n"
                + "|  circle  |  " + getReportData().getTotalCircleCount() + "  |\n"
                + "| hexagon |  " + getReportData().getTotalHexagonCount() + "  |\n\n";

    }
}

