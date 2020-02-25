package com.gtt.shoppingstoreback.dto.in;

public class ProductSearchIn {
    private String productName;
    private Integer sortOrder;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
}
