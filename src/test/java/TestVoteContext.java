import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdpu.dao.VoteContextDao;
import com.gdpu.entity.Vote;
import com.gdpu.entity.Votecontext;
import com.gdpu.service.VoteContextService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestVoteContext {
	@Resource
	private VoteContextDao voteContextDao;
	@Resource
	private VoteContextService voteContextService;
	@Test
	public void testfindVoteContextByVoteId(){
		Vote vote = new Vote();
		vote.setVoteId(77);
	    List<Votecontext> list= voteContextDao.findVoteContextByVoteId(vote);
	    System.out.println(list);
	}
	@Test
	public void testdelVoteContext(){
		Votecontext voteContext = new Votecontext();
		Integer votecontextId = 152;
		voteContext.setVotecontextId(votecontextId);
		voteContextService.delVoteContext(voteContext);
	}
	@Test
	public void testfindTotalCountByVoteId(){
		Integer vid = 152;
		Long l = voteContextService.findTotalCountByVoteId(vid);
		System.out.println(l);
	}
}
