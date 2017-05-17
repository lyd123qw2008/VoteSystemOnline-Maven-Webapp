import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdpu.dao.VoteDao;
import com.gdpu.entity.Vote;
import com.gdpu.service.VoteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestVote {
	@Resource
	private VoteDao voteDao; 
	@Resource
	private VoteService voteService;
	@Test
	public void testfindVoteByTitle(){
		Vote vote = new Vote();
		vote.setTitle("%2%");
		List<Vote> list = voteDao.findVoteByTitle(vote);
		System.out.println(list);	
	}
	
	@Test
	public void testaddVote(){
		Vote vote = new Vote();
		System.out.println(vote.getVoteId());
	}
	@Test
	public void testfindVoteById(){
		Vote vote = null;
		vote = voteDao.findVoteById(87);
		System.out.println(vote);
	}
	@Test
	public void testlist(){
		Map<String,Object> map = new HashMap<String, Object>();
		Vote vote = new Vote();
//		vote.setTitle();
		map.put("page", 1);
		map.put("rows", 10);
		map.put("title", "%1%");
		List<Vote> list = voteDao.list(map);
		System.out.println(list);
	}
	

}
