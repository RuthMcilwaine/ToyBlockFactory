public class InvoiceReport implements Report {

    private ReportData reportData;

    public InvoiceReport(ReportData reportData) {
        this.reportData = reportData;
    }

    @Override
    public String printReport() {
        return  "Your invoice report has been generated: \n" +

                "|          | red | blue | yellow | \n" +
                "|  square  |  " + reportData.getRedSquare() + "  |  " + reportData.getBlueSquare() + "   |   " + reportData.getYellowSquare() + "    | \n"
                + "| triangle |  "  + reportData.getRedTriangle() + "  |  "  + reportData.getBlueTriangle() +  "   |   "  + reportData.getYellowTriangle() +  "    | \n"
                + "|  circle  |  " + reportData.getRedCircle()+ "  |  " + reportData.getBlueCircle() + "   |   " + reportData.getYellowCircle() + "    | \n" +

                "Squares " + reportData.getTotalSquareCount() + " @ $1 ppi =  $" + reportData.getTotalSquareCount()* 1 + "\n" +
                "Triangles " + reportData.getTotalTriangleCount() + " @ $2 ppi =  $" + reportData.getTotalTriangleCount() * 2 + "\n" +
                "Circles " + reportData.getTotalCircleCount() + " @ $3 ppi =  $" + reportData.getTotalCircleCount() * 3 + "\n" +
                "Red colour surcharge " + reportData.getTotalRedCount() + " @ $1 ppi =  $" + reportData.getTotalRedCount() * 1 + "\n" + "\n" +
                "Total:  $" + reportData.getSumOfCosts();
    }

    @Override
    public ReportData getReportData() {
        return reportData;
    }
}
