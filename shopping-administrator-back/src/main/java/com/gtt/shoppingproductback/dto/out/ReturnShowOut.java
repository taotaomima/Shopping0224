package com.gtt.shoppingproductback.dto.out;

public class ReturnShowOut {
    private Integer returnId;
    private Long orderId;
    private Long orderTimesTamp;
    private Integer customerId;
    private String customerName;
    private String mobile;
    private String email;
    private Byte status;
    private Byte action;
    private String productCode;
    private String productName;
    private Integer quantity;
    private Byte reason;
    private Boolean opened;
    private String comment;
    private Long createTimeTamp;
    private Long updateTimeTamp;

    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderTimesTamp() {
        return orderTimesTamp;
    }

    public void setOrderTimesTamp(Long orderTimesTamp) {
        this.orderTimesTamp = orderTimesTamp;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getAction() {
        return action;
    }

    public void setAction(Byte action) {
        this.action = action;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Byte getReason() {
        return reason;
    }

    public void setReason(Byte reason) {
        this.reason = reason;
    }

    public Boolean getOpened() {
        return opened;
    }

    public void setOpened(Boolean opened) {
        this.opened = opened;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
