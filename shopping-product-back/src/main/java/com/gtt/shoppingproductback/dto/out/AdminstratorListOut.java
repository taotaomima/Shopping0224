package com.gtt.shoppingproductback.dto.out;

public class AdminstratorListOut {
    private Integer adminstratorId;
    private String username;
    private String realName;
    private String email;
    private String mobile;
    private String avatorUrl;
    private String cresteTimeTemp;

    public Integer getAdminstratorId() {
        return adminstratorId;
    }

    public void setAdminstratorId(Integer adminstratorId) {
        this.adminstratorId = adminstratorId;
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

    public String getAvatorUrl() {
        return avatorUrl;
    }

    public void setAvatorUrl(String avatorUrl) {
        this.avatorUrl = avatorUrl;
    }

    public String getCresteTimeTemp() {
        return cresteTimeTemp;
    }

    public void setCresteTimeTemp(String cresteTimeTemp) {
        this.cresteTimeTemp = cresteTimeTemp;
    }
}
