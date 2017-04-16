package com.fang.pojo;

import java.util.Date;

public class Comment {
    private Integer cid;

    private String fromUid;

    private Integer toTalk;

    private String content;

    private Date time;

    private Integer parentCid;

    private Byte state;
    
    //每个评论包含的人
    private TbUser tbuser;
    
    //时间从sql的转化为字符串的
    private String dates;
    
    public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public TbUser getTbuser() {
		return tbuser;
	}

	public void setTbuser(TbUser tbuser) {
		this.tbuser = tbuser;
	}

	public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getFromUid() {
        return fromUid;
    }

    public void setFromUid(String fromUid) {
        this.fromUid = fromUid == null ? null : fromUid.trim();
    }

    public Integer getToTalk() {
        return toTalk;
    }

    public void setToTalk(Integer toTalk) {
        this.toTalk = toTalk;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getParentCid() {
        return parentCid;
    }

    public void setParentCid(Integer parentCid) {
        this.parentCid = parentCid;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}