package com.gdpu.controller.vote;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdpu.controller.rootcontroller.VoteContextRoot;
import com.gdpu.entity.Votecontext;
import com.gdpu.service.VoteContextService;

@Controller
public class UpdateVoteContext{
	
	@Resource
	private VoteContextService voteContextService;

	@RequestMapping("vote/updateVoteContext")
	public String updateVoteContext(HttpSession session,VoteContextRoot voteContextRoot,Model model){
		// ��session�л��list
		List<Votecontext> list = (List) session.getAttribute("list");
		String[] context = voteContextRoot.getContext();
		model.addAttribute("type", voteContextRoot.getType());
		model.addAttribute("publish", voteContextRoot.getPublish());
		for (int i = 0; i < context.length; i++) {
			Votecontext vc = new Votecontext();
			// ���ҳ��������ͶƱ��ѡ����Ϣ��list�е���Ϣ������˵�����޸ģ�
			// ��ҳ������Ϣ���µ����ݿ⣬����ͶƱ��ѡ��Ʊ����Ϣ����Ϊ0
			if (!context[i].equals(list.get(i).getContext())) {
				vc.setContext(context[i]);
				vc.setCount(0);
				vc.setVoteId(list.get(i).getVoteId());
				vc.setVotecontextId(list.get(i).getVotecontextId());
				voteContextService.updateVoteContext(vc);
			} else
				return "redirect:updateVote.do?type={type}&publish={publish}";
		}
		return "redirect:updateVote.do?type={type}&publish={publish}";
	}
}
