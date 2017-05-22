package com.gdpu.controller.vote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gdpu.controller.rootcontroller.VoteContextRoot;
import com.gdpu.entity.Vote;
import com.gdpu.entity.Votecontext;
import com.gdpu.service.VoteContextService;

@Controller
@SessionAttributes({"voteContextRoot","typeMap","publishMap"})
public class ShowVote {
	@Resource
	private VoteContextService voteContextService;
	
	@RequestMapping("vote/showVote")
	public String showVote(HttpSession session,VoteContextRoot voteContextRoot,Map<String, Object> map) {
		// ��session�л��ͶƱ��Ϣ
		Vote vote = (Vote) session.getAttribute("vote");
		// ͨ��ͶƱ��Ų���ͶƱ��ѡ����Ϣ������list
		List<Votecontext> list = voteContextService
				.findVoteContextByVoteId(vote);
		String[] context =new String[list.size()] ;
		for (int i = 0; i < list.size(); i++) {
			context[i]=list.get(i).getContext();
		}
		voteContextRoot.setContext(context);
		// ������ͶƱ��ѡ����Ϣ��list����session�ġ�list��
		session.setAttribute("list", list);
		
		Map<Integer,String> typeMap = new HashMap<Integer,String>();
		Map<Integer,String> publishMap = new HashMap<Integer,String>();
		typeMap.put(0, "��ѡ");
		typeMap.put(1, "��ѡ");
		publishMap.put(0, "��");
		publishMap.put(1, "��");
		map.put("typeMap", typeMap);
		map.put("publishMap", publishMap);
		
		voteContextRoot.setType(vote.getType());
		voteContextRoot.setPublish(vote.getPublish());
		return "vote/managevote";
	}

}
