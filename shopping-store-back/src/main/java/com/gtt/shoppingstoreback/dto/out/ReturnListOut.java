package com.gtt.shoppingstoreback.dto.out;

public class ReturnListOut {
    private Integer returnId;
    private Byte returnstatus;
    private Long orderId;
    private String customerName;

    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    public Byte getReturnstatus() {
        return returnstatus;
    }

    public void setReturnstatus(Byte returnstatus) {
        this.returnstatus = returnstatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
