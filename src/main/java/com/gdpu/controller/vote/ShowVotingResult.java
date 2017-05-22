package com.gdpu.controller.vote;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdpu.entity.Vote;
import com.gdpu.entity.Votecontext;
import com.gdpu.service.VoteContextService;
import com.gdpu.util.ResponseUtil;

/**
 * @author lyd
 *
 */
/**
 * @author lyd
 *
 */
@Controller
public class ShowVotingResult{
	
	@Resource
	private VoteContextService voteContextService;

	@RequestMapping("vote/showVotingResult")
	public String showVotingResult(HttpSession session) {
		// ��session���ͶƱ���
		Integer vid = ((Vote) session.getAttribute("vote2")).getVoteId();
		// �����ݿ��ѯ�õ���ӦͶƱ�����ͶƱ��
		Long totalcount = voteContextService.findTotalCountByVoteId(vid);
		// ��ͶƱ������session�ġ�totalcount��
		session.setAttribute("totalcount", totalcount);
		return "redirect:/vote/showvotingresult.jsp";
	}
	
	/**
	 * ��������ͼ������ͼjson����ǰ̨
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("vote/showVotingResult1")
	public String showVotingResult1(HttpSession session,HttpServletResponse response)throws Exception{
		// ��session���ͶƱ���
		Integer vid = ((Vote) session.getAttribute("vote2")).getVoteId();
		Vote vote = new Vote();
		vote.setVoteId(vid);
		// ͨ��ͶƱ��Ų��Ҷ�Ӧ�ñ�ŵ���ѡ������
		List<Votecontext> list = voteContextService
				.findVoteContextByVoteId(vote);
		JSONObject result=new JSONObject();
		String[] categories = new String[list.size()];
		Integer[] data = new Integer[list.size()];
		for (int i = 0; i < list.size(); i++) {
			categories[i] = list.get(i).getContext();
			data[i] = list.get(i).getCount();
		}
		result.put("categories", categories);
		result.put("data", data);
		ResponseUtil.write(response, result);
		return null;
		
	}
	/**
	 * �����ͼjson����ǰ̨
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("vote/showVotingResult2")
	public String showVotingResult2(HttpSession session,HttpServletResponse response)throws Exception{
		// ��session���ͶƱ���
		Integer vid = ((Vote) session.getAttribute("vote2")).getVoteId();
		Vote vote = new Vote();
		vote.setVoteId(vid);
		// ͨ��ͶƱ��Ų��Ҷ�Ӧ�ñ�ŵ���ѡ������
		List<Votecontext> list = voteContextService
				.findVoteContextByVoteId(vote);	
		String[] categories = new String[list.size()];
		JSONArray array = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject result=new JSONObject();
			categories[i] = list.get(i).getContext();
			result.put("name", list.get(i).getContext());
			result.put("value", list.get(i).getCount());
			array.add(result);
		}
		JSONObject result=new JSONObject();
		result.put("array", array);
		result.put("categories", categories);
		ResponseUtil.write(response, result);
		return null;
		
	}
}
