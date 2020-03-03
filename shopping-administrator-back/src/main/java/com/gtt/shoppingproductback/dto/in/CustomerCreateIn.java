package com.gtt.shoppingproductback.dto.in;


import java.util.Date;

public class CustomerCreateIn {
    private Integer customerId;
    private String username;
    private String realName;
    private String email;
    private String mobile;
    private Byte status;
    private Date createTimeTemp;
    private String password;
    private String avatarUrl;

    public Date getCreateTimeTemp() {
        return createTimeTemp;
    }

    public void setCreateTimeTemp(Date createTimeTemp) {
        this.createTimeTemp = createTimeTemp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }


}
