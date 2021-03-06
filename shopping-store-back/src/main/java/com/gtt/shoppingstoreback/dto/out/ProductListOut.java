package com.gtt.shoppingstoreback.dto.out;

import java.util.List;

public class ProductListOut {
    private Integer productId;
    private String productName;
    private Integer productCode;
    private Double price;
    private Double discount;
    private String description;
    private Integer stockQuantity;
    private Integer sortOrder;
    private String mianPicUrl;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }


    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getMianPicUrl() {
        return mianPicUrl;
    }

    public void setMianPicUrl(String mianPicUrl) {
        this.mianPicUrl = mianPicUrl;
    }

}
