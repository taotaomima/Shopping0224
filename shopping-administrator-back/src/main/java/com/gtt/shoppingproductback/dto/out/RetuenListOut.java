package com.gtt.shoppingproductback.dto.out;

public class RetuenListOut {
    private Integer retuenId;
    private Long orderId;
    private Integer customerId;
    private String customerName;
    private String productCode;
    private String prodeuctName;
    private Byte status;
    private Long createTimeTamp;
    private Long updateTimeTamp;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getRetuenId() {
        return retuenId;
    }

    public void setRetuenId(Integer retuenId) {
        this.retuenId = retuenId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProdeuctName() {
        return prodeuctName;
    }

    public void setProdeuctName(String prodeuctName) {
        this.prodeuctName = prodeuctName;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCreateTimeTamp() {
        return createTimeTamp;
    }

    public void setCreateTimeTamp(Long createTimeTamp) {
        this.createTimeTamp = createTimeTamp;
    }

    public Long getUpdateTimeTamp() {
        return updateTimeTamp;
    }

    public void setUpdateTimeTamp(Long updateTimeTamp) {
        this.updateTimeTamp = updateTimeTamp;
    }
}
