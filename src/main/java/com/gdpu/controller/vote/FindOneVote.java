package com.gdpu.controller.vote;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdpu.entity.Vote;
import com.gdpu.service.VoteService;

@Controller
public class FindOneVote{
	@Resource
	private VoteService voteService;

	@RequestMapping("vote/findOneVote")
	public String findOneVote(HttpSession httpSession,@RequestParam("voteId")Integer voteId){
		Vote vote = voteService.findVoteById(voteId);
		httpSession.setAttribute("vote", vote);
		return "redirect:showVote.do";
	}

}
