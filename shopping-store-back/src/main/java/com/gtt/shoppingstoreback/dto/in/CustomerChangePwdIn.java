package com.gtt.shoppingstoreback.dto.in;

public class CustomerChangePwdIn {
    private String orderPwd;
    private String newPwd;

    public String getOrderPwd() {
        return orderPwd;
    }

    public void setOrderPwd(String orderPwd) {
        this.orderPwd = orderPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
