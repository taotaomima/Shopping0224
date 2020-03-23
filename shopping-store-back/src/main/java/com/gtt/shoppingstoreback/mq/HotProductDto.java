package com.gtt.shoppingstoreback.mq;

import java.io.Serializable;

public class HotProductDto implements Serializable {
    private Integer productId;
    private String productCode;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
