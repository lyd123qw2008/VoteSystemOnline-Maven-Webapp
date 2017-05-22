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
		// 通过投票编号查找投票信息
		Vote vote2 = voteService.findVoteById(voteId);
		// 如果publish!=0,说明投票状态为未开放
		if (vote2.getPublish() != 0) {
			return "vote/voteclose";
		} else {
			// 如果投票状态为开放，将投票信息放入session的“vote”中
			session.setAttribute("vote2", vote2);
			return "forward:showVotingContext.do";
		}
	}
}
