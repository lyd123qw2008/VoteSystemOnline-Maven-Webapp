package com.gdpu.dao;

import java.util.Map;

import com.gdpu.entity.Voter;

public interface VoterDao {
	/**
	 * ����ͶƱ����Ϣ
	 * @param voter ͶƱ����Ϣ
	 */
	public void addVoter(Voter voter);
	/**
	 * ͨ��IP��ͶƱ��Ų���ͶƱ��
	 * @param ip IP
	 * @param voteId ͶƱ���
	 * @return Voter��Voter���ͣ�
	 */
	public Voter findVoterByIp(Map<String,Object> map);
}