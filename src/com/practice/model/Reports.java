package com.practice.model;

import java.util.Date;

public class Reports {
    int reportId;
    String reportName;
    String reportEmail;
    String reportBatch;
    String reportSubject;
    String reportMessage;
    Date date;

    public Date getDate(){return date;}
    public void setDate(Date date){this.date=date;}

    public int getReportId(){return reportId;}
    public void setReportId(int reportId){this.reportId=reportId;}

    public String getReportName(){return reportName;}
    public void setReportName(String reportName){this.reportName=reportName;}

    public String getReportEmail(){return reportEmail;}
    public void setReportEmail(String reportEmail){this.reportEmail=reportEmail;}

    public String getReportBatch(){return reportBatch;}
    public void setReportBatch(String reportBatch){this.reportBatch=reportBatch;}

    public String getReportSubject(){return reportSubject;}
    public void setReportSubject(String reportSubject){this.reportSubject=reportSubject;}

    public String getReportMessage(){return reportMessage;}
    public void setReportMessage(String reportMessage){this.reportMessage=reportMessage;}
}
