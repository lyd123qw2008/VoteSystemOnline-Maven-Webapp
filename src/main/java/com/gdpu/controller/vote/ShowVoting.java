package com.gdpu.controller.vote;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdpu.controller.rootcontroller.VoteRoot;
import com.gdpu.entity.Vote;
import com.gdpu.service.VoteService;

@Controller
public class ShowVoting{
	
	@Resource
	private VoteService voteService;

	@RequestMapping("vote/showVoting")
	public String showVoting(HttpSession session,Integer voteId){
		// ͨ��ͶƱ��Ų���ͶƱ��Ϣ
		Vote vote2 = voteService.findVoteById(voteId);
		// ���publish!=0,˵��ͶƱ״̬Ϊδ����
		if (vote2.getPublish() != 0) {
			return "vote/voteclose";
		} else {
			// ���ͶƱ״̬Ϊ���ţ���ͶƱ��Ϣ����session�ġ�vote����
			session.setAttribute("vote2", vote2);
			return "forward:showVotingContext.do";
		}
	}
}
