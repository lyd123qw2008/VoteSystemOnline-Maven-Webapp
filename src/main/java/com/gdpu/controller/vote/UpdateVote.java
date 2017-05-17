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
		// ��session�л��ͶƱ��Ϣ
		Vote vote = (Vote) session.getAttribute("vote");
		// ���ҳ�������е�ͶƱ���ͼ�ͶƱ״̬�����ݿ�����Ϣ�������������
		if (vote.getType().equals(type) && vote.getPublish().equals(publish)) {
			return "redirect:findVote.do";
		} else {
			// ���򣬽�ҳ����������Ϣ���µ����ݿ�
			vote.setType(type);
			vote.setPublish(publish);
			voteService.updateVote(vote);
			return "redirect:findVote.do";
		}
	}
}
