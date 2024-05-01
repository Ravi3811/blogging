package com.blogapp12.payload;

import java.util.Date;

public class ErrorDetails {
    private Date date;
    private String message;

    public ErrorDetails(Date date, String message, String details) {
        this.date = date;
        this.message = message;
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    private String details;
}