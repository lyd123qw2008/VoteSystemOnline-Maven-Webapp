package com.gdpu.controller.rootcontroller;



import com.gdpu.service.VoterService;


public class VoterRoot{
	protected VoterService voterService;
	protected String ip;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public VoterService getVoterService() {
		return voterService;
	}

	public void setVoterService(VoterService voterService) {
		this.voterService = voterService;
	}

}
