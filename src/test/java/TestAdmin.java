import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdpu.dao.AdminDao;
import com.gdpu.entity.Admin;
import com.gdpu.service.AdminService;
import com.gdpu.util.CryptographyUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestAdmin {
	@Resource
	private AdminDao adminDao;
	@Resource
	private AdminService adminService;
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
	@Test
	public void testchangepwd(){
		Admin admin=new Admin();
		admin.setPassword(CryptographyUtil.md5("1", "gdpu"));
		int resultTotal=adminService.changepwd(admin);
	}
	

}
