
public class CuttingReport implements Report {

    private ReportData reportData;

    public CuttingReport(ReportData reportData) {
        this.reportData = reportData;
    }


    @Override
    public String printReport() {
        return "Your cutting report has been generated: \n" +

                "|          | Qty | \n" +
                "|  square  |  " + reportData.getTotalSquareCount() + "  |  \n"
                + "| triangle |  " + reportData.getTotalTriangleCount() + "  |  \n"
                + "|  circle  |  " + reportData.getTotalCircleCount() + "  |  \n";

    }

    @Override
    public ReportData getReportData() {
        return reportData;
    }
}

