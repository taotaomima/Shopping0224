package com.gtt.shoppingstoreback.dto.in;

public class ReturnCreateIn {

    private String customerName;
    private String email;
    private String mobile;
    private Long orderId;
    private Long orderTimesTamp;
    private String productName;
    private String productCode;
    private Integer quantity;
    private Byte reason;
    private Boolean opened;
    private String comment;
    private Byte action;
    private Long createTimeTamp;

    public Long getCreateTimeTamp() {
        return createTimeTamp;
    }

    public void setCreateTimeTamp(Long createTimeTamp) {
        this.createTimeTamp = createTimeTamp;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public Byte getAction() {
        return action;
    }

    public void setAction(Byte action) {
        this.action = action;
    }
}
