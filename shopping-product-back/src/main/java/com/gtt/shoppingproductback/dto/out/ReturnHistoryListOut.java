package com.gtt.shoppingproductback.dto.out;

public class ReturnHistoryListOut {
    private Integer returnHistoryId;
    private Integer returnId;
    private Byte returnStatus;
    private Boolean customerNotified;
    private String comment;
    private Long timesTamp;

    public Integer getReturnHistoryId() {
        return returnHistoryId;
    }

    public void setReturnHistoryId(Integer returnHistoryId) {
        this.returnHistoryId = returnHistoryId;
    }

    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    public Byte getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Byte returnStatus) {
        this.returnStatus = returnStatus;
    }

    public Boolean getCustomerNotified() {
        return customerNotified;
    }

    public void setCustomerNotified(Boolean customerNotified) {
        this.customerNotified = customerNotified;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(Long timesTamp) {
        this.timesTamp = timesTamp;
    }
}
