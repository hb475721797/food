package com.learn.pojo.vo;

public class SubCategoryVO {

    private Integer subId;

    private String subName;

    private Integer subType;

    private Integer subFatherId;

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public void setSubFatherId(Integer subFatherId) {
        this.subFatherId = subFatherId;
    }

    public Integer getSubId() {
        return subId;
    }

    public String getSubName() {
        return subName;
    }

    public Integer getSubType() {
        return subType;
    }

    public Integer getSubFatherId() {
        return subFatherId;
    }
}
