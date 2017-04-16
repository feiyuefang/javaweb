package com.fang.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fang.util.GetTime;

public class Talk implements Comparable<Talk>,Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String userId;

    private String content;

    private Date time;

    //0,���ɼ���1���ɼ�
    private Byte state;

    private Integer parentId;
    
    private TbUser tbUser;
    
    //���޵�����
    private int likeNumber;
    
    private List<TbUser> likeList;
    
    //�Ƿ����
    private boolean likeOrNot;
    
    //���۵�����
    private int CommentNumber;
    
    //Ʒ��
    private List<Comment> comms;
    
    private String stringTime;
    
	public String getStringTime() {
		return stringTime;
	}

	public void init(){
		
	}
	public void setStringTime(String stringTime) {
		this.stringTime = stringTime;
		/*this.stringTime=GetTime.format(time,"yyyy-MM-dd hh:mm:ss");*/
	}

	public List<TbUser> getLikeList() {
		return likeList;
	}

	public void setLikeList(List<TbUser> likeList) {
		this.likeList = likeList;
	}

	public List<Comment> getComms() {
		return comms;
	}

	public void setComms(List<Comment> comms) {
		this.comms = comms;
	}

	public int getCommentNumber() {
		return CommentNumber;
	}

	public void setCommentNumber(int commentNumber) {
		CommentNumber = commentNumber;
	}

	public int getLikeNumber() {
		return likeNumber;
	}

	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
	}

	public boolean isLikeOrNot() {
		return likeOrNot;
	}

	public void setLikeOrNot(boolean likeOrNot) {
		this.likeOrNot = likeOrNot;
	}

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    
    /* 1��ģ�ͱ���ʵ��Comparable<T>�ӿڣ�
     * 2��Collections.sort(list);���Զ�����compareTo,���û�����list�ǲ��������Ҳ�������compareTo����
     * 3�� ������������õ���Arrays.sort(a)����*/
    public int compareTo(Talk o) {
		 return this.getTime().compareTo(o.getTime());
	}
    
}