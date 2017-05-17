import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdpu.dao.AdminDao;
import com.gdpu.dao.VoteDao;
import com.gdpu.entity.Admin;
import com.gdpu.entity.Vote;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class Test1 {
	@Resource
	private AdminDao adminDao;
	@Test
	public void testfindAll(){
		List<Admin> list = adminDao.findAll();
		System.out.println(list);		
	}
	@Test
	public void testaddAdmin(){
		Admin admin = new Admin("ÕÅÈý","123456",null);
		adminDao.addAdmin(admin);
	}
	@Test
	public void testfindfindAdminByName(){
		List<Admin> list = adminDao.findAdminByName("admin");
		System.out.println("--------------------");
		System.out.println(list.get(0));
		System.out.println("---------------------");
	}
	

}
