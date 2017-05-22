package com.gdpu.entity;

public class Votecontext{

	private Integer votecontextId;
	private String context;
	private Integer count;
	private Integer voteId;

	public Votecontext() {
	}

	public Votecontext(String context, Integer count, Integer voteId) {
		this.context = context;
		this.count = count;
		this.voteId = voteId;
	}

	public Integer getVotecontextId() {
		return this.votecontextId;
	}

	public void setVotecontextId(Integer votecontextId) {
		this.votecontextId = votecontextId;
	}

	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getVoteId() {
		return this.voteId;
	}

	public void setVoteId(Integer voteId) {
		this.voteId = voteId;
	}

	@Override
	public String toString() {
		return "Votecontext [votecontextId=" + votecontextId + ", context="
				+ context + ", count=" + count + ", voteId=" + voteId + "]";
	}

}