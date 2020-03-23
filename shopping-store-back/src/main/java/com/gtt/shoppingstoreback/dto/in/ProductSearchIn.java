package com.gtt.shoppingstoreback.dto.in;

public class ProductSearchIn {
    private String keyword;
    private Byte sortBy;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Byte getSortBy() {
        return sortBy;
    }

    public void setSortBy(Byte sortBy) {
        this.sortBy = sortBy;
    }
}
