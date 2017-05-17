package com.gdpu.dao;

import java.util.List;
import java.util.Map;

import com.gdpu.entity.Vote;



public interface VoteDao {
	/**
	 * ����ͶƱ����
	 * 
	 * @param vote
	 *            ͶƱ��Ϣ
	 */
	public void addVote(Vote vote);
	

	/**
	 * ͨ��ͶƱ�������ͶƱ���
	 * 
	 * @param vote
	 *            ͶƱ������Ϣ
	 * @return ͶƱ���
	 */
	public Integer findIdByTitle(Vote vote);

	/**
	 * ��������ͶƱ����
	 * 
	 * @return VoteV��List���ͣ�
	 */
	public List<Vote> findVote();

	/**
	 * ͨ��ͶƱ��Ų���ͶƱ����
	 * 
	 * @param voteId
	 *            ͶƱ���
	 * @return VoteV��Vote���ͣ�
	 */
	public Vote findVoteById(Integer voteId);

	/**
	 * �޸�ͶƱ��Ϣ
	 * 
	 * @param vote
	 *            ͶƱ��Ϣ
	 */
	public void updateVote(Vote vote);

	/**
	 * ͨ��ͶƱ�������ͶƱ
	 * 
	 * @param vote
	 *            ͶƱ��Ϣ
	 * @return VoteV��List���ͣ�
	 */
	public List<Vote> findVoteByTitle(Vote vote);

	/**
	 * ͨ��ͶƱ���Ͳ���ͶƱ��
	 * 
	 * @param type
	 *            ͶƱ����
	 * @return ͶƱ��
	 */
	public Long findVoteCountByType(Integer type);

	/**
	 * ����ͶƱ����
	 * 
	 * @return ͶƱ����
	 */
	public Long findVoteCount();
	
	/**
	 * ��ҳ��ѯͶƱ
	 * @return
	 */
	public List<Vote> list(Map<String,Object> map);
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	/**
	 * ɾ��ͶƱ��Ϣ
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
	
}
