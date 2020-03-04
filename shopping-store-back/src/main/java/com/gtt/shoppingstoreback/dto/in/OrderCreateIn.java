package com.gtt.shoppingstoreback.dto.in;

import java.util.List;

public class OrderCreateIn {
    private Integer shipAddressId;
    private Double shipPrice;
    private Short shipMethod;
    private Integer rewordPoints;
    private Short payMethod;
    private Byte status;
    private Integer invoiceAddressId;
    private String comment;
    private Double invoicePrice;
    private List<OrderProductIn> orderProductInList;
    private Double totalPrice;


    public Integer getShipAddressId() {
        return shipAddressId;
    }

    public void setShipAddressId(Integer shipAddressId) {
        this.shipAddressId = shipAddressId;
    }

    public Integer getInvoiceAddressId() {
        return invoiceAddressId;
    }

    public void setInvoiceAddressId(Integer invoiceAddressId) {
        this.invoiceAddressId = invoiceAddressId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getShipPrice() {
        return shipPrice;
    }

    public void setShipPrice(Double shipPrice) {
        this.shipPrice = shipPrice;
    }

    public Integer getRewordPoints() {
        return rewordPoints;
    }

    public void setRewordPoints(Integer rewordPoints) {
        this.rewordPoints = rewordPoints;
    }

    public Short getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Short payMethod) {
        this.payMethod = payMethod;
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(Double invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public List<OrderProductIn> getOrderProductInList() {
        return orderProductInList;
    }

    public void setOrderProductInList(List<OrderProductIn> orderProductInList) {
        this.orderProductInList = orderProductInList;
    }
}
