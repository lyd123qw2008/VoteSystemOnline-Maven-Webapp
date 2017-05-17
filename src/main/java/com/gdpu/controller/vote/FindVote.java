package com.gdpu.controller.vote;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdpu.controller.rootcontroller.VoteRoot;
import com.gdpu.entity.Admin;
import com.gdpu.entity.Vote;
import com.gdpu.entity.VoteInfo;
import com.gdpu.service.AdminService;
import com.gdpu.service.VoteService;

@Controller
public class FindVote {
	@Resource
	private VoteService voteService;
	@Resource
	private AdminService adminService;
	@RequestMapping("vote/findVote")
	public String findVote(VoteRoot voteRoot,ModelMap model){
		List<Vote> list = new ArrayList<Vote>();
		// 查出所有投票信息并赋给list
		list = voteService.findVote();
		List<VoteInfo> list2 = new ArrayList<VoteInfo>();
		for (int i = 0; i < list.size(); i++) {
			// 取出对应某条投票信息的管理员编号，由管理员编号查出管理员用户名并封装到admin对象中
			Admin admin = adminService.findNameById(list.get(i).getAdminId());
			VoteInfo vInfo = new VoteInfo();
			// 如果投票信息中publish==0，显示投票状态为开放
			if (list.get(i).getPublish() == 0)
				vInfo.setPublish("开放");
			else
				vInfo.setPublish("关闭");
			// 如果投票信息中type==0，显示投票类型为单选
			if (list.get(i).getType() == 0)
				vInfo.setType("单选");
			else
				vInfo.setType("多选");
			vInfo.setAdminname(admin.getUserName());
			vInfo.setCreatedate(list.get(i).getCreatedate());
			vInfo.setTitle(list.get(i).getTitle());
			vInfo.setVoteId(list.get(i).getVoteId());
			// 将查找出的投票信息封装到list2
			list2.add(vInfo);
		}
		voteRoot.setList2(list2);
		model.addAttribute("voteRoot", voteRoot);
		return "vote/showresult";
	}
}
