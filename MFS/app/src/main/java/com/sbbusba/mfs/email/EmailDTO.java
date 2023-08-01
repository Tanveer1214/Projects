package com.sbbusba.mfs.email;

public class EmailDTO {

    private String to;
    private String orderNumber;
    private String fullName;
    private String orderStatus;
    private String orderComment;
    public EmailDTO() {}
    public EmailDTO(String to, String orderNumber) {
        this.to = to;
        this.orderNumber = orderNumber;
    }
    public EmailDTO(String to, String orderNumber, String fullName) {
        this.to = to;
        this.orderNumber = orderNumber;
        this.fullName = fullName;
    }
    public EmailDTO(String to, String orderNumber, String fullName, String orderStatus) {
        this.to = to;
        this.orderNumber = orderNumber;
        this.fullName = fullName;
        this.orderStatus = orderStatus;
    }
    public EmailDTO(String to, String orderNumber, String fullName, String orderStatus, String orderComment) {
        this.to = to;
        this.orderNumber = orderNumber;
        this.fullName = fullName;
        this.orderStatus = orderStatus;
        this.orderComment = orderComment;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }
    @Override
    protected EmailDTO clone() {
        return new EmailDTO(to,orderNumber,fullName,orderStatus,orderComment);
    }
}
