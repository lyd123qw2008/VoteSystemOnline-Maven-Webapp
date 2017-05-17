package com.gdpu.controller.vote;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdpu.entity.Vote;
import com.gdpu.entity.Votecontext;
import com.gdpu.entity.VotingInfo;
import com.gdpu.service.VoteContextService;

@Controller
public class ShowVotingResult{
	
	@Resource
	private VoteContextService voteContextService;

	@RequestMapping("vote/showVotingResult")
	public String showVotingResult(HttpSession session,Model model) {
		List<VotingInfo>list2 = new ArrayList<VotingInfo>();
		// ��session���ͶƱ���
		Integer vid = ((Vote) session.getAttribute("vote2")).getVoteId();
		// �����ݿ��ѯ�õ���ӦͶƱ�����ͶƱ��
		Long totalcount = voteContextService.findTotalCountByVoteId(vid);
		// ��ͶƱ������session�ġ�totalcount��
		session.setAttribute("totalcount", totalcount);
		Vote vote = new Vote();
		vote.setVoteId(vid);
		// ͨ��ͶƱ��Ų��Ҷ�Ӧ�ñ�ŵ���ѡ������
		List<Votecontext> list = voteContextService
				.findVoteContextByVoteId(vote);
		for (int i = 0; i < list.size(); i++) {
			// �����ѡ��ͶƱ�����������ռ����ѡ���ӦͶƱ����Ʊ���İٷֱ�
			Integer count = list.get(i).getCount();
			BigDecimal bd = new BigDecimal((double) count / totalcount);
			double per = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			NumberFormat percentFormat = NumberFormat.getPercentInstance();
			String percent = percentFormat.format(per);
			VotingInfo votingInfo = new VotingInfo();
			// ������ѡ������
			votingInfo.setContext(list.get(i).getContext());
			votingInfo.setCount(count);
			// ���ðٷֱ�
			votingInfo.setPercent(percent);
			list2.add(votingInfo);
		}
		model.addAttribute("list2", list2);
		return "vote/showvotingresult";
	}
}
