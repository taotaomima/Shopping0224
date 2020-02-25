package com.gtt.shoppingstoreback.dto.out;

public class OrderListOut {
    private Long orderId;
    private Integer customerId;
    private Double shipPrice;
    private Short shipMethod;
    private Byte status;
    private String productName;
    private Double unitPrice;
    private Integer quantity;
    private Double totalPrice;
    private Long createTimeTamp;

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


    public Double getShipPrice() {
        return shipPrice;
    }

    public void setShipPrice(Double shipPrice) {
        this.shipPrice = shipPrice;
    }


    public Short getShipMethod() {
        return shipMethod;
    }

    public void setShipMethod(Short shipMethod) {
        this.shipMethod = shipMethod;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getCreateTimeTamp() {
        return createTimeTamp;
    }

    public void setCreateTimeTamp(Long createTimeTamp) {
        this.createTimeTamp = createTimeTamp;
    }
}
