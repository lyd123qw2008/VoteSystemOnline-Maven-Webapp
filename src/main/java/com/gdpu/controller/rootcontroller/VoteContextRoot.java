package com.gdpu.controller.rootcontroller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.gdpu.entity.VotingInfo;
import com.gdpu.service.VoteContextService;
import com.gdpu.service.VoteService;


public class VoteContextRoot{
	/**
	 * @param context
	 *            ��ѡ�����ݣ���������
	 * @param voteId
	 *            ͶƱ���
	 * @param list
	 * @param list2
	 *            ��װͶƱ�����Ϣ
	 * @param votecontextId
	 *            ͶƱ��ѡ����
	 * @param type
	 *            ͶƱ����
	 * @param publish
	 *            �Ƿ񷢲�
	 * @param map
	 *            ��װͶƱѡ���ż�����
	 */
	protected String[] context;
	protected Integer voteId;
	protected List<VotingInfo> list2;
	protected Integer votecontextId;
	protected Integer type;
	protected Integer publish;
	protected Map<Integer,String> map;

	public Integer getPublish() {
		return publish;
	}

	public void setPublish(Integer publish) {
		this.publish = publish;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getVotecontextId() {
		return votecontextId;
	}

	public void setVotecontextId(Integer votecontextId) {
		this.votecontextId = votecontextId;
	}

	public Integer getVoteId() {
		return voteId;
	}

	public void setVoteId(Integer voteId) {
		this.voteId = voteId;
	}

	public String[] getContext() {
		return context;
	}

	public void setContext(String[] context) {
		this.context = context;
	}

	public List<VotingInfo> getList2() {
		return list2;
	}

	public void setList2(List<VotingInfo> list2) {
		this.list2 = list2;
	}

	public Map<Integer, String> getMap() {
		return map;
	}

	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "VoteContextRoot [context=" + Arrays.toString(context)
				+ ", voteId=" + voteId + ", list2=" + list2
				+ ", votecontextId=" + votecontextId + ", type=" + type
				+ ", publish=" + publish + ", map=" + map + "]";
	}

}
