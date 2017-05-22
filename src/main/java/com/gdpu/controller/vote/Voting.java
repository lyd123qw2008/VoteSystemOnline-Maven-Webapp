package com.gdpu.controller.vote;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdpu.controller.rootcontroller.VoteContextRoot;
import com.gdpu.entity.Votecontext;
import com.gdpu.service.VoteContextService;

@Controller
public class Voting{
	
	@Resource
	private VoteContextService voteContextService;

	@RequestMapping("vote/voting")
	public String voting(String[] context) throws Exception {
		Votecontext voteContext;
		String vc[] = context;
		for (int i = 0; i < vc.length; i++) {
			voteContext = new Votecontext();
			// 设置投票子选项编号
			voteContext.setVotecontextId(Integer.parseInt(vc[i]));
			// 由投票子选项编号查找对应系选项信息
			Votecontext votecontext2 = voteContextService
					.findVCCountByVCId(voteContext);
			Integer count = votecontext2.getCount();
			String vccontext = votecontext2.getContext();
			votecontext2.setContext(vccontext);
			// 当前投票子选项票数加一
			votecontext2.setCount(count + 1);
			voteContextService.updateVoteContext(votecontext2);
		}
		return "forward:/voter/addVoter.do";
	}

}
