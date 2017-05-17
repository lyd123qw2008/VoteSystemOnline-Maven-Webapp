package com.gdpu.service;

import java.util.List;
import java.util.Map;

import com.gdpu.entity.Vote;



public interface VoteService {
	public void addVote(Vote vote);

	public Integer findIdByTitle(Vote vote);

	public List<Vote> findVote();
	
	public List<Vote> list(Map<String,Object> map);
	
	public Long getTotal(Map<String,Object> map);
	
	public Vote findVoteById(Integer voteId);
	
	public void updateVote(Vote vote);
	
	public List<Vote> findVoteByTitle(Vote vote);
	
	public Long findVoteCountByType(Integer type);
	
	public Long findVoteCount();
	
	public Integer delete(Integer id);
}
