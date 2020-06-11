public class PaintingReport implements Report {

    private ReportData reportData;


    public PaintingReport(ReportData reportData) {
        this.reportData = reportData;
    }

    @Override
    public String printReport() {
        return "Your cutting report has been generated: \n" +

                "|          | red | blue | yellow | \n" +
                "|  square  |  " + getReportData().getRedSquare() + "  |  " + getReportData().getBlueSquare() + "   |   " + getReportData().getYellowSquare() + "    | \n"
                + "| triangle |  "  + getReportData().getRedTriangle() + "  |  "  + getReportData().getBlueTriangle() +  "   |   "  + getReportData().getYellowTriangle() +  "    | \n"
                + "|  circle  |  " + getReportData().getRedCircle()+ "  |  " + getReportData().getBlueCircle() + "   |   " + getReportData().getYellowCircle() + "    | \n";
    }


    @Override
    public ReportData getReportData() {
        return reportData;
    }
}
