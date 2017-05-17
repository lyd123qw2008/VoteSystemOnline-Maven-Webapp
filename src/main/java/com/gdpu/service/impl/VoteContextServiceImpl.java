package com.gdpu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdpu.dao.VoteContextDao;
import com.gdpu.entity.Vote;
import com.gdpu.entity.Votecontext;
import com.gdpu.service.VoteContextService;

@Service("voteContextService")
public class VoteContextServiceImpl implements VoteContextService {
	@Resource
	private VoteContextDao voteContextDao;

	public VoteContextDao getVoteContextDao() {
		return voteContextDao;
	}

	public void setVoteContextDao(VoteContextDao voteContextDao) {
		this.voteContextDao = voteContextDao;
	}

	public void addVoteContext(Votecontext voteContext) {
		voteContextDao.addVoteContext(voteContext);
	}

	public List<Votecontext> findVoteContextByVoteId(Vote vote) {
		return voteContextDao.findVoteContextByVoteId(vote);
	}

	public void delVoteContext(Votecontext voteContext) {
		voteContextDao.delVoteContext(voteContext);
	}

	public void addOneVoteContext(Votecontext voteContext) {
		voteContextDao.addOneVoteContext(voteContext);
	}

	public void updateVoteContext(Votecontext voteContext) {
		voteContextDao.updateVoteContext(voteContext);
	}

	public Votecontext findVCCountByVCId(Votecontext voteContext) {
		return voteContextDao.findVCCountByVCId(voteContext);
	}

	public Long findTotalCountByVoteId(Integer voteId) {
		return voteContextDao.findTotalCountByVoteId(voteId);
	}

}
