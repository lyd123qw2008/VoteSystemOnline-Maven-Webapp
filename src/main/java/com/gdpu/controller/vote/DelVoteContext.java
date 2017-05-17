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
		// 通过投票ID查找投票选项信息并封装到list
		List<Votecontext> list = voteContextService
				.findVoteContextByVoteId(vote);
		System.out.println("==========" + list.size());
		// 如果对应某投票ID的投票选项数小于或等于2则不可继续删除
		if (list.size() > 2) {
			Votecontext voteContext = new Votecontext();
			voteContext.setVotecontextId(votecontextId);
			voteContextService.delVoteContext(voteContext);
			return "redirect:findOneVote.do?voteId="+voteId;
		} else {
			request.setAttribute("error", "投票子选项个数不能少于2个！");
			return "vote/managevote";
		}
	}
}
