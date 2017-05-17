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
		// �������ͶƱ��Ϣ������list
		list = voteService.findVote();
		List<VoteInfo> list2 = new ArrayList<VoteInfo>();
		for (int i = 0; i < list.size(); i++) {
			// ȡ����Ӧĳ��ͶƱ��Ϣ�Ĺ���Ա��ţ��ɹ���Ա��Ų������Ա�û�������װ��admin������
			Admin admin = adminService.findNameById(list.get(i).getAdminId());
			VoteInfo vInfo = new VoteInfo();
			// ���ͶƱ��Ϣ��publish==0����ʾͶƱ״̬Ϊ����
			if (list.get(i).getPublish() == 0)
				vInfo.setPublish("����");
			else
				vInfo.setPublish("�ر�");
			// ���ͶƱ��Ϣ��type==0����ʾͶƱ����Ϊ��ѡ
			if (list.get(i).getType() == 0)
				vInfo.setType("��ѡ");
			else
				vInfo.setType("��ѡ");
			vInfo.setAdminname(admin.getUserName());
			vInfo.setCreatedate(list.get(i).getCreatedate());
			vInfo.setTitle(list.get(i).getTitle());
			vInfo.setVoteId(list.get(i).getVoteId());
			// �����ҳ���ͶƱ��Ϣ��װ��list2
			list2.add(vInfo);
		}
		voteRoot.setList2(list2);
		model.addAttribute("voteRoot", voteRoot);
		return "vote/showresult";
	}
}
