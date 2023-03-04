package hu.progmatic.report;

import org.testng.Reporter;

import java.sql.Timestamp;

public class Reporting {

    public void sendDateAndReportMessage(String message) {
        System.out.println(new Timestamp(System.currentTimeMillis())+"      "+message);
        Reporter.log(new Timestamp(System.currentTimeMillis())+"        "+message);

    }
}
