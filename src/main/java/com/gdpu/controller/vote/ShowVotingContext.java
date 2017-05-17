package com.gdpu.controller.vote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdpu.entity.Vote;
import com.gdpu.entity.Votecontext;
import com.gdpu.service.VoteContextService;

@Controller
public class ShowVotingContext{
	
	@Resource
	private VoteContextService voteContextService;
	
	@RequestMapping("vote/showVotingContext")
	public String showVotingContext(HttpSession session,Model model){
		// ��session�л��ͶƱ��Ϣ����Ҫ��ͶƱ���
		Vote vote = (Vote) session.getAttribute("vote2");
		// ͨ��ͶƱ��Ų��Ҷ�ӦͶƱѡ����Ϣ
		List<Votecontext> list = voteContextService
				.findVoteContextByVoteId(vote);
		Map<Integer,String> map = new HashMap<Integer, String>();
		for (int i = 0; i < list.size(); i++) {
			// ��ͶƱѡ���ż����ݴ���map
			map.put(list.get(i).getVotecontextId(), list.get(i).getContext());
		}
		// ��map��ͶƱ���ʹ��͸���Ӧҳ��
		model.addAttribute("map", map);
		model.addAttribute("type", vote.getType());
		return "vote/showvoting";
	}
}
