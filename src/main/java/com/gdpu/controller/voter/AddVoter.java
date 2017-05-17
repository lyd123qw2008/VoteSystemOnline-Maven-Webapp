package com.gdpu.controller.voter;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdpu.entity.Vote;
import com.gdpu.entity.Voter;
import com.gdpu.service.VoterService;

@Controller
public class AddVoter{
	@Resource
	private VoterService voterService;
	@RequestMapping("voter/addVoter")
	public String addVoter(HttpSession session,@RequestParam("ip") String ip){
		// 从session获得当前投票编号
		Integer vid = ((Vote) session.getAttribute("vote2")).getVoteId();
		Voter voter = new Voter();
		voter.setIp(ip);
		voter.setVoteId(vid);
		// 将当前投票人Ip，当前投票编号存入数据库
		voterService.addVoter(voter);
		return "forward:vote/showVotingResult";
	}

}
