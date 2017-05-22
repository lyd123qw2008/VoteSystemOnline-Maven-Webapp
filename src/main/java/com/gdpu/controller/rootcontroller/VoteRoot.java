package com.gdpu.controller.rootcontroller;

import java.util.List;
import com.gdpu.entity.Vote;
import com.gdpu.entity.VoteInfo;


public class VoteRoot{
	/**
	 * @param voteId ͶƱ���
	 * @param title ͶƱ����
	 * @param type ͶƱ����(1Ϊ��ѡ��0Ϊ��ѡ)
	 * @param publish �Ƿ񿪷�ͶƱ(1Ϊ���ţ�0Ϊ������)
	 * @param adminId ����ԱId
	 * @param contextcount ��ѡ�����
	 * @param list ��װȫ��ͶƱ��Ϣ
	 * @param list2 ��װͶƱ�����Ϣ
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
