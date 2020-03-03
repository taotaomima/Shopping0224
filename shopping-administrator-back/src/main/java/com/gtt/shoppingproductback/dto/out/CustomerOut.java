package com.gtt.shoppingproductback.dto.out;

import java.util.Date;

public class CustomerOut {
    private String username;
    private String mobile;
    private String email;
    private String realName;
    private Byte status;
    private Date createTimeTemp;
    private String defaultAddress;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }



    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTimeTemp() {
        return createTimeTemp;
    }

    public void setCreateTimeTemp(Date createTimeTemp) {
        this.createTimeTemp = createTimeTemp;
    }

    public String getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(String defaultAddress) {
        this.defaultAddress = defaultAddress;
    }
}
