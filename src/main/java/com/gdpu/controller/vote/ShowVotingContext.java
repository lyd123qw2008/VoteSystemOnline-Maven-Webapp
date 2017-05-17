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
		// 从session中获得投票信息，主要是投票编号
		Vote vote = (Vote) session.getAttribute("vote2");
		// 通过投票编号查找对应投票选项信息
		List<Votecontext> list = voteContextService
				.findVoteContextByVoteId(vote);
		Map<Integer,String> map = new HashMap<Integer, String>();
		for (int i = 0; i < list.size(); i++) {
			// 将投票选项编号及内容存入map
			map.put(list.get(i).getVotecontextId(), list.get(i).getContext());
		}
		// 将map及投票类型传送给对应页面
		model.addAttribute("map", map);
		model.addAttribute("type", vote.getType());
		return "vote/showvoting";
	}
}
