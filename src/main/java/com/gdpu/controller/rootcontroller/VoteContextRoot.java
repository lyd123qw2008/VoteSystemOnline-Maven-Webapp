package com.gdpu.controller.rootcontroller;





public class VoteContextRoot{
	/**
	 * @param context
	 *            ��ѡ�����ݣ���������
	 * @param voteId
	 *            ͶƱ���
	 * @param votecontextId
	 *            ͶƱ��ѡ����
	 * @param type
	 *            ͶƱ����
	 * @param publish
	 *            �Ƿ񷢲�
	 * 
	 */
	private String[] context;
	private Integer voteId;
	private Integer votecontextId;
	private Integer type;
	private Integer publish;

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




}
