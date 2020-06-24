public class ReportStub  implements Report {
//has been called set to false. sets this  has been  to  true.

    public String printReport() {
        return "";  //dummy returns empty string
    }
//spy: which reportdata fields has been  called.
    public ReportData getReportData() {
        Customer customerDetails =  new Customer("","",""); //dummy
        ReportData stubReportData =  new ReportData(customerDetails, 0, 0, 0, 0, 0, 0, 0);
        return stubReportData;
    }
}
