package com.sbbusba.adminpanel;

import java.util.Date;

public class StatusModel {

    private String userID;
    private String orderID;
    private String userName;
    private String comments;
    private String status;
    private Date createdOn;

    public StatusModel() {
    }

    public StatusModel(String userID, String orderID, String userName, String comments, String status) {
        this.userID = userID;
        this.orderID = orderID;
        this.userName = userName;
        this.comments = comments;
        this.status = status;
    }
    public StatusModel(String userID, String orderID, String userName, String comments, String status,Date createdOn) {
        this.userID = userID;
        this.orderID = orderID;
        this.userName = userName;
        this.comments = comments;
        this.status = status;
        this.createdOn = createdOn;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
