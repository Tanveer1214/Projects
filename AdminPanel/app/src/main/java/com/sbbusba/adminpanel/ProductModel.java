package com.sbbusba.adminpanel;

public class ProductModel {

    private String id;
    private String title;
    private String description;
    private String material;
    private String width;
    private String height;
    private String category;
    private String price;
    private String stock;
    private String image;
    private boolean show;

    public ProductModel() {
    }

    public ProductModel(String id, String title, String description, String material, String width, String height, String category, String price, String stock, String image, boolean show) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.material = material;
        this.width = width;
        this.height = height;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.show = show;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
