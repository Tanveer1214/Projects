package com.sbbusba.adminpanel;

import java.io.Serializable;
import java.util.Date;

public class OrderModel implements Serializable {
    private String orderNumber;
    private String customer_name;
    private String customer_number;
    private String customerEmail;
    private String customer_city;
    private String customer_address;
    private String itemExpense;
    private String delivery_charges;
    private String orderTrackingNumber;
    private String courier;
    private String orderPlacingDate;
    private String order_status;
    private String uid;
    private Date createdOn;
    private Date updatedOn;

    public OrderModel() {
    }

    public OrderModel(String orderNumber, String customer_name, String customer_number, String customer_city, String customer_address, String itemExpense, String delivery_charges, String orderTrackingNumber, String courier, String orderPlacingDate, String order_status, String uid) {
        this.orderNumber = orderNumber;
        this.customer_name = customer_name;
        this.customer_number = customer_number;
        this.customer_city = customer_city;
        this.customer_address = customer_address;
        this.itemExpense = itemExpense;
        this.delivery_charges = delivery_charges;
        this.orderTrackingNumber = orderTrackingNumber;
        this.courier = courier;
        this.orderPlacingDate = orderPlacingDate;
        this.order_status = order_status;
        this.uid = uid;
    }
    public OrderModel(String orderNumber, String customer_name, String customer_number, String customer_city, String customer_address, String itemExpense, String delivery_charges, String orderTrackingNumber, String courier, String orderPlacingDate, String order_status, String uid,
                      Date createdOn, Date updatedOn) {
        this.orderNumber = orderNumber;
        this.customer_name = customer_name;
        this.customer_number = customer_number;
        this.customer_city = customer_city;
        this.customer_address = customer_address;
        this.itemExpense = itemExpense;
        this.delivery_charges = delivery_charges;
        this.orderTrackingNumber = orderTrackingNumber;
        this.courier = courier;
        this.orderPlacingDate = orderPlacingDate;
        this.order_status = order_status;
        this.uid = uid;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public OrderModel(String orderNumber, String customer_name, String customer_number, String customerEmail, String customer_city, String customer_address, String itemExpense, String delivery_charges, String orderTrackingNumber, String courier, String orderPlacingDate, String order_status, String uid, Date createdOn, Date updatedOn) {
        this.orderNumber = orderNumber;
        this.customer_name = customer_name;
        this.customer_number = customer_number;
        this.customerEmail = customerEmail;
        this.customer_city = customer_city;
        this.customer_address = customer_address;
        this.itemExpense = itemExpense;
        this.delivery_charges = delivery_charges;
        this.orderTrackingNumber = orderTrackingNumber;
        this.courier = courier;
        this.orderPlacingDate = orderPlacingDate;
        this.order_status = order_status;
        this.uid = uid;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(String customer_number) {
        this.customer_number = customer_number;
    }

    public String getCustomer_city() {
        return customer_city;
    }

    public void setCustomer_city(String customer_city) {
        this.customer_city = customer_city;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getItemExpense() {
        return itemExpense;
    }

    public void setItemExpense(String itemExpense) {
        this.itemExpense = itemExpense;
    }

    public String getDelivery_charges() {
        return delivery_charges;
    }

    public void setDelivery_charges(String delivery_charges) {
        this.delivery_charges = delivery_charges;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public String getOrderPlacingDate() {
        return orderPlacingDate;
    }

    public void setOrderPlacingDate(String orderPlacingDate) {
        this.orderPlacingDate = orderPlacingDate;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
