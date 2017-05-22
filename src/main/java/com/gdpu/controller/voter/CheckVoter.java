package com.gdpu.controller.voter;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdpu.entity.Vote;
import com.gdpu.entity.Voter;
import com.gdpu.service.VoterService;
@Controller
@RequestMapping("voter")
public class CheckVoter{
	
	@Resource
	private VoterService voterService;

	@RequestMapping("/checkVoter")
	public String checkVoter(HttpSession session,HttpServletRequest request){
		// 从session获得当前投票编号
		Integer vid = ((Vote) session.getAttribute("vote2")).getVoteId();
		// 由投票编号及当前用户Ip查找投票人信息
		String ip = request.getRemoteAddr();
		request.setAttribute("ip", ip);
		Voter voter = voterService.findVoterByIp(ip, vid);
		// 如果为空，说明当前投票人未投过票
		if (voter == null)
			return "forward:/vote/voting.do";
		else {
			return "forward:/vote/showVotingResult.do";
		}
	}
}
