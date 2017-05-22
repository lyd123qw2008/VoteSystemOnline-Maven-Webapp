package com.gdpu.controller.rootcontroller;





public class VoteContextRoot{
	/**
	 * @param context
	 *            子选项内容，数组类型
	 * @param voteId
	 *            投票编号
	 * @param votecontextId
	 *            投票子选项编号
	 * @param type
	 *            投票类型
	 * @param publish
	 *            是否发布
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
