package com.gdpu.dao;

import java.util.Map;

import com.gdpu.entity.Voter;

public interface VoterDao {
	/**
	 * 增加投票人信息
	 * @param voter 投票人信息
	 */
	public void addVoter(Voter voter);
	/**
	 * 通过IP，投票编号查找投票人
	 * @param ip IP
	 * @param voteId 投票编号
	 * @return Voter（Voter类型）
	 */
	public Voter findVoterByIp(Map<String,Object> map);
}
