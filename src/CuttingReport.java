
public class CuttingReport implements Report {

    private ReportData reportData;

    public CuttingReport(ReportData reportData) {
        this.reportData = reportData;
    }


    @Override
    public String printReport() {
        return "Your cutting report has been generated: \n" +

                "|          | Qty | \n" +
                "|  square  |  " + getReportData().getTotalSquareCount() + "  |  \n"
                + "| triangle |  " + getReportData().getTotalTriangleCount() + "  |  \n"
                + "|  circle  |  " + getReportData().getTotalCircleCount() + "  |  \n";

    }

    @Override
    public ReportData getReportData() {
        return reportData;
    }
}

