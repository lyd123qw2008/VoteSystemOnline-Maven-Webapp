package com.gdpu.controller.vote;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdpu.controller.rootcontroller.VoteContextRoot;
import com.gdpu.entity.Votecontext;
import com.gdpu.service.VoteContextService;



@Controller
public class AddOneVoteContext{
	@Resource
	private VoteContextService voteContextService;
	@RequestMapping("vote/addOneVoteContext")
	public String addOneVoteContext(Integer voteId){
		Integer vid = voteId;
		Votecontext voteContext = new Votecontext();
		voteContext.setVoteId(vid);
		voteContext.setContext("<请输入投票选项内容>");
		voteContext.setCount(0);
		voteContextService.addOneVoteContext(voteContext);
		return "redirect:findOneVote.do?voteId="+voteId;
	}
}
