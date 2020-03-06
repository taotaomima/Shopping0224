package com.gtt.shoppingstoreback.dto.out;

import java.util.List;

public class ReturnShowOut {
    private Integer returnId;
    private Long orderId;
    private Long orderTimesTamp;
    private Long createTimeTamp;
    private Long updateTimeTamp;
    private String productName;
    private String productCode;
    private Integer quantity;
    private Byte reason;
    private Boolean opened;
    private Byte action;
    private Byte status;
    private String customerName;
    private String email;
    private String mobile;
    private String comment;
    private List<ReturnHistoryListOut> returnHistoryListOuts;

    public List<ReturnHistoryListOut> getReturnHistoryListOuts() {
        return returnHistoryListOuts;
    }

    public void setReturnHistoryListOuts(List<ReturnHistoryListOut> returnHistoryListOuts) {
        this.returnHistoryListOuts = returnHistoryListOuts;
    }

    public Long getUpdateTimeTamp() {
        return updateTimeTamp;
    }

    public void setUpdateTimeTamp(Long updateTimeTamp) {
        this.updateTimeTamp = updateTimeTamp;
    }

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

    public Long getCreateTimeTamp() {
        return createTimeTamp;
    }

    public void setCreateTimeTamp(Long createTimeTamp) {
        this.createTimeTamp = createTimeTamp;
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

    public Byte getAction() {
        return action;
    }

    public void setAction(Byte action) {
        this.action = action;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
