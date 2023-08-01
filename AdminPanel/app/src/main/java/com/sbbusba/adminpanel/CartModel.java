package com.sbbusba.adminpanel;

public class CartModel {

    private String cartid;
    private String productName;
    private String productImage;
    private String productPrice;
    private String productQty;
    private String sellerUid;
    private String orderNumber;
    public boolean is_selected;

    public CartModel() {
    }

    public CartModel(String cartid, String productName, String productImage, String productPrice, String productQty, String sellerUid, String orderNumber) {
        this.cartid = cartid;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productQty = productQty;
        this.sellerUid = sellerUid;
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCartid() {
        return cartid;
    }

    public void setCartid(String cartid) {
        this.cartid = cartid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductQty() {
        return productQty;
    }

    public void setProductQty(String productQty) {
        this.productQty = productQty;
    }

    public String getSellerUid() {
        return sellerUid;
    }

    public void setSellerUid(String sellerUid) {
        this.sellerUid = sellerUid;
    }

}
