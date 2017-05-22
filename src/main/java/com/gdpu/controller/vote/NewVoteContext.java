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
		// ��session�л��ͶƱ��Ϣ
		Vote vote = (Vote) session.getAttribute("vote");
		// ��ͶƱ������Ϣ��ӵ����ݿ�
		voteService.addVote(vote);
		//ȡ��voteId�Ŵ���session
		session.setAttribute("vote", vote);
		Integer vote_id = voteService.findIdByTitle(vote);
		// ��ҳ����ͶƱѡ����Ϣ���������ͣ�
		String[] voteContext = voteContextRoot.getContext();
		Votecontext votecontext;
		for (int i = 0; i < voteContext.length; i++) {
			votecontext = new Votecontext();
			votecontext.setVoteId(vote_id);
			votecontext.setContext(voteContext[i]);
			votecontext.setCount(0);
			// ��ͶƱѡ����Ϣ��ӵ����ݿ�
			voteContextService.addVoteContext(votecontext);
		}
		return "forward:/vote/showVote.do";
	}

}
