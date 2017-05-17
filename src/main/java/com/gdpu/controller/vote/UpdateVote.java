package com.gdpu.controller.vote;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdpu.controller.rootcontroller.VoteRoot;
import com.gdpu.entity.Vote;
import com.gdpu.service.VoteService;

@Controller
public class UpdateVote{
	@Resource
	private VoteService voteService;

	@RequestMapping("vote/updateVote")
	public String updateVote(HttpSession session,Integer type,Integer publish) throws Exception {
		// 从session中获得投票信息
		Vote vote = (Vote) session.getAttribute("vote");
		// 如果页面请求中的投票类型及投票状态与数据库中信息相符，不做操作
		if (vote.getType().equals(type) && vote.getPublish().equals(publish)) {
			return "redirect:findVote.do";
		} else {
			// 否则，将页面请求中信息更新到数据库
			vote.setType(type);
			vote.setPublish(publish);
			voteService.updateVote(vote);
			return "redirect:findVote.do";
		}
	}
}
