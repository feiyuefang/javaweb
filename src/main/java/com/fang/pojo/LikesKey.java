package com.fang.pojo;

public class LikesKey {
    private Integer toTalk;

    private String fromUid;

    public Integer getToTalk() {
        return toTalk;
    }

    public void setToTalk(Integer toTalk) {
        this.toTalk = toTalk;
    }

    public String getFromUid() {
        return fromUid;
    }

    public void setFromUid(String fromUid) {
        this.fromUid = fromUid == null ? null : fromUid.trim();
    }
}