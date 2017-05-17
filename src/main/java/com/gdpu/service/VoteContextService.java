package com.gdpu.service;

import java.util.List;

import com.gdpu.entity.Vote;
import com.gdpu.entity.Votecontext;



public interface VoteContextService {
	public void addVoteContext(Votecontext voteContext);

	public List<Votecontext> findVoteContextByVoteId(Vote vote);

	public void delVoteContext(Votecontext voteContext);

	public void addOneVoteContext(Votecontext voteContext);

	public void updateVoteContext(Votecontext voteContext);
	
	public Votecontext findVCCountByVCId(Votecontext voteContext);
	
	public Long findTotalCountByVoteId(Integer voteId);
	
}
