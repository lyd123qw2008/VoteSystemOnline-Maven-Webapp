import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdpu.dao.VoterDao;
import com.gdpu.entity.Voter;
import com.gdpu.service.VoterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestVoter {
	@Resource
	private VoterDao voterDao; 
	@Resource
	private VoterService voterService;
	@Test
	public void testaddVoter(){
		Voter voter = new Voter();
		voter.setIp("1111");
		voter.setVoteId(5);
		voterService.addVoter(voter);
	}
}	