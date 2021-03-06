package com.example.mad_new;

import java.util.Date;

public class BrighterBee {

    private Integer no;
    private String due_date;
    private String subject;
    private String description;

    public BrighterBee(Integer no, String due_date, String subject, String description) {
        this.no = no;
        this.due_date = due_date;
        this.subject = subject;
        this.description = description;
    }

    public BrighterBee() {
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString (){
        return  this + ""+no+""+due_date+""+subject+""+description;
    }
}

