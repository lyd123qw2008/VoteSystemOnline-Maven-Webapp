package com.gdpu.controller.vote;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gdpu.controller.rootcontroller.VoteContextRoot;
import com.gdpu.entity.Vote;
import com.gdpu.entity.Votecontext;
import com.gdpu.service.VoteContextService;


@Controller
public class DelVoteContext{
	
	@Resource
	private VoteContextService voteContextService;
	@RequestMapping("vote/delVoteContext")
	public String delVoteContext(HttpSession session,VoteContextRoot voteContextRoot,HttpServletRequest request,ModelMap map){
		Vote vote = new Vote();
		Integer votecontextId = voteContextRoot.getVotecontextId();
		Integer voteId = voteContextRoot.getVoteId();
		voteContextRoot = (VoteContextRoot)session.getAttribute("voteContextRoot");
		map.addAttribute("voteContextRoot", voteContextRoot);
		vote.setVoteId(voteId);
		// ͨ��ͶƱID����ͶƱѡ����Ϣ����װ��list
		List<Votecontext> list = voteContextService
				.findVoteContextByVoteId(vote);
		System.out.println("==========" + list.size());
		// �����ӦĳͶƱID��ͶƱѡ����С�ڻ����2�򲻿ɼ���ɾ��
		if (list.size() > 2) {
			Votecontext voteContext = new Votecontext();
			voteContext.setVotecontextId(votecontextId);
			voteContextService.delVoteContext(voteContext);
			return "redirect:findOneVote.do?voteId="+voteId;
		} else {
			request.setAttribute("error", "ͶƱ��ѡ�������������2����");
			return "vote/managevote";
		}
	}
}
