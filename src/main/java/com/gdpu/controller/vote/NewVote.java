package com.gdpu.controller.vote;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdpu.controller.rootcontroller.VoteRoot;
import com.gdpu.entity.Admin;
import com.gdpu.entity.Vote;
import com.gdpu.service.VoteService;

@Controller
public class NewVote{
	@Resource
	private VoteService voteService;
	@RequestMapping("vote/newVote")
	public String newVote(HttpSession session,VoteRoot voteRoot,HttpServletRequest request){		
		Vote vote = new Vote();
		vote.setTitle(voteRoot.getTitle());
		vote.setType(voteRoot.getType());
		vote.setPublish(voteRoot.getPublish());
		// 获得当前系统时间并格式化，存入创建投票时间
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(date);
		vote.setCreatedate(dateString);
		vote.setAdminId(((Admin) session.getAttribute("currentUser")).getAdminId());
		List<Vote> l = voteService.findVoteByTitle(vote);
		if (l.size()>0) {
			request.setAttribute("error", "该主题已经存在！");
			return "/vote/newvote";
		} else {
			session.setAttribute("vote", vote);
			session.setAttribute("contextcount", voteRoot.getContextcount());
			return "vote/newvotecontext";
		}
	}
}
