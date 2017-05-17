package com.gdpu.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdpu.dao.VoterDao;
import com.gdpu.entity.Voter;
import com.gdpu.service.VoterService;

@Service("VoterService")
public class VoterServiceImpl implements VoterService {
	@Resource
	private VoterDao voterDao;

	public VoterDao getVoterDao() {
		return voterDao;
	}

	public void setVoterDao(VoterDao voterDao) {
		this.voterDao = voterDao;
	}

	public void addVoter(Voter voter) {
		voterDao.addVoter(voter);
	}

	public Voter findVoterByIp(String ip, Integer voteId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ip", ip);
		map.put("voteId", String.valueOf(voteId));
		return voterDao.findVoterByIp(map);
	}

}
