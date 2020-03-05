package com.gtt.shoppingproductback.dto.out;

import java.util.Date;

public class CustomerShowOut {
    private Integer customerId;
    private String username;
    private String realName;
    private String mobile;
    private String email;
    private String avatarUrl;
    private Byte status;
    private Integer rewordPoints;
    private Boolean newsSubscribed;
    private Long createTimeTemp;
    private Integer defaultAddressId;
    private String defaultAddress;

    public String getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(String defaultAddress) {
        this.defaultAddress = defaultAddress;
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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getRewordPoints() {
        return rewordPoints;
    }

    public void setRewordPoints(Integer rewordPoints) {
        this.rewordPoints = rewordPoints;
    }

    public Boolean getNewsSubscribed() {
        return newsSubscribed;
    }

    public void setNewsSubscribed(Boolean newsSubscribed) {
        this.newsSubscribed = newsSubscribed;
    }

    public Long getCreateTimeTemp() {
        return createTimeTemp;
    }

    public void setCreateTimeTemp(Long createTimeTemp) {
        this.createTimeTemp = createTimeTemp;
    }

    public Integer getDefaultAddressId() {
        return defaultAddressId;
    }

    public void setDefaultAddressId(Integer defaultAddressId) {
        this.defaultAddressId = defaultAddressId;
    }
}
