package com.gdpu.dao;

import java.util.List;
import java.util.Map;

import com.gdpu.entity.Vote;



public interface VoteDao {
	/**
	 * 增加投票主题
	 * 
	 * @param vote
	 *            投票信息
	 */
	public void addVote(Vote vote);
	

	/**
	 * 通过投票主题查找投票编号
	 * 
	 * @param vote
	 *            投票主题信息
	 * @return 投票编号
	 */
	public Integer findIdByTitle(Vote vote);

	/**
	 * 查找所有投票主题
	 * 
	 * @return VoteV（List类型）
	 */
	public List<Vote> findVote();

	/**
	 * 通过投票编号查找投票主题
	 * 
	 * @param voteId
	 *            投票编号
	 * @return VoteV（Vote类型）
	 */
	public Vote findVoteById(Integer voteId);

	/**
	 * 修改投票信息
	 * 
	 * @param vote
	 *            投票信息
	 */
	public void updateVote(Vote vote);

	/**
	 * 通过投票主题查找投票
	 * 
	 * @param vote
	 *            投票信息
	 * @return VoteV（List类型）
	 */
	public List<Vote> findVoteByTitle(Vote vote);

	/**
	 * 通过投票类型查找投票数
	 * 
	 * @param type
	 *            投票类型
	 * @return 投票数
	 */
	public Long findVoteCountByType(Integer type);

	/**
	 * 查找投票个数
	 * 
	 * @return 投票个数
	 */
	public Long findVoteCount();
	
	/**
	 * 分页查询投票
	 * @return
	 */
	public List<Vote> list(Map<String,Object> map);
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	/**
	 * 删除投票信息
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
	
}
