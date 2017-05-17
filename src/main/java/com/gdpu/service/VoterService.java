package com.gdpu.service;

import com.gdpu.entity.Voter;



public interface VoterService {
	public void addVoter(Voter voter);
	
	public Voter findVoterByIp(String ip,Integer voteId);
}
