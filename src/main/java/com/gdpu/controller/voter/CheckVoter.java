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
		// ��session��õ�ǰͶƱ���
		Integer vid = ((Vote) session.getAttribute("vote2")).getVoteId();
		// ��ͶƱ��ż���ǰ�û�Ip����ͶƱ����Ϣ
		String ip = request.getRemoteAddr();
		request.setAttribute("ip", ip);
		Voter voter = voterService.findVoterByIp(ip, vid);
		// ���Ϊ�գ�˵����ǰͶƱ��δͶ��Ʊ
		if (voter == null)
			return "forward:/vote/voting.do";
		else {
			return "forward:/vote/showVotingResult.do";
		}
	}
}
