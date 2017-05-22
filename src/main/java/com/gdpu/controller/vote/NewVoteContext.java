package com.gdpu.controller.vote;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdpu.controller.rootcontroller.VoteContextRoot;
import com.gdpu.entity.Vote;
import com.gdpu.entity.Votecontext;
import com.gdpu.service.VoteContextService;
import com.gdpu.service.VoteService;
import com.gdpu.util.repeat_form_validator.FormToken;

@Controller
public class NewVoteContext{
	@Resource
	private VoteService voteService;
	@Resource
	private VoteContextService voteContextService;
	
	@RequestMapping("vote/newVoteContext")
	public String newvotecontext(VoteContextRoot voteContextRoot,HttpSession session) {
		// 从session中获得投票信息
		Vote vote = (Vote) session.getAttribute("vote");
		// 将投票标题信息添加到数据库
		voteService.addVote(vote);
		//取得voteId号存入session
		session.setAttribute("vote", vote);
		Integer vote_id = voteService.findIdByTitle(vote);
		// 从页面获得投票选项信息（数组类型）
		String[] voteContext = voteContextRoot.getContext();
		Votecontext votecontext;
		for (int i = 0; i < voteContext.length; i++) {
			votecontext = new Votecontext();
			votecontext.setVoteId(vote_id);
			votecontext.setContext(voteContext[i]);
			votecontext.setCount(0);
			// 将投票选项信息添加到数据库
			voteContextService.addVoteContext(votecontext);
		}
		return "forward:/vote/showVote.do";
	}

}
