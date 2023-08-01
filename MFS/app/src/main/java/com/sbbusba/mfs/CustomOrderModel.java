package com.sbbusba.mfs;

public class CustomOrderModel {
    private String id;
    private String sellerUID;
    private String name;
    private String number;
    private String productName; // furniture type
    private String woodType;
    private String width;
    private String height;
    private String productQty;
    private String productPrice;
    private String status;
    private String productImage;
    private boolean show;

    public CustomOrderModel() {
    }

    public CustomOrderModel(String id, String sellerUID, String name, String number, String productName, String woodType, String width, String height, String productQty, String productPrice, String status, String productImage, boolean show) {
        this.id = id;
        this.sellerUID = sellerUID;
        this.name = name;
        this.number = number;
        this.productName = productName;
        this.woodType = woodType;
        this.width = width;
        this.height = height;
        this.productQty = productQty;
        this.productPrice = productPrice;
        this.status = status;
        this.productImage = productImage;
        this.show = show;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSellerUID() {
        return sellerUID;
    }

    public void setSellerUID(String sellerUID) {
        this.sellerUID = sellerUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getWoodType() {
        return woodType;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getProductQty() {
        return productQty;
    }

    public void setProductQty(String productQty) {
        this.productQty = productQty;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}