package com.gdpu.controller.rootcontroller;

import java.util.List;
import com.gdpu.entity.Vote;
import com.gdpu.entity.VoteInfo;


public class VoteRoot{
	/**
	 * @param voteId 投票编号
	 * @param title 投票标题
	 * @param type 投票类型(1为单选，0为多选)
	 * @param publish 是否开放投票(1为开放，0为不开放)
	 * @param adminId 管理员Id
	 * @param contextcount 子选项个数
	 * @param list 封装全部投票信息
	 * @param list2 封装投票相关信息
	 */
	private Integer voteId;
	private String title;
	private Integer type;
	private Integer publish;
	private Integer adminId;
	private Integer contextcount;
	private List<Vote> list;
	private List<VoteInfo> list2;

	public Integer getContextcount() {
		return contextcount;
	}

	public void setContextcount(Integer contextcount) {
		this.contextcount = contextcount;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPublish() {
		return publish;
	}

	public void setPublish(Integer publish) {
		this.publish = publish;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public List<Vote> getList() {
		return list;
	}

	public void setList(List<Vote> list) {
		this.list = list;
	}

	public Integer getVoteId() {
		return voteId;
	}

	public void setVoteId(Integer voteId) {
		this.voteId = voteId;
	}


	public List<VoteInfo> getList2() {
		return list2;
	}

	public void setList2(List<VoteInfo> list2) {
		this.list2 = list2;
	}



}
