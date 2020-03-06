package com.gtt.shoppingstoreback.dto.out;

public class ReturnHistoryListOut {
    private Long timesTamp;
    private String comment;
    private Byte returnStatus;

    public Long getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(Long timesTamp) {
        this.timesTamp = timesTamp;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Byte getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Byte returnStatus) {
        this.returnStatus = returnStatus;
    }
}
