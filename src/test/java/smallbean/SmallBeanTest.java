package smallbean;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/smallbean.xml")
public class SmallBeanTest {

	@Autowired
	private MyService myService;

	@Test
	public void dependencyInjectionWorks() {
		assertNotNull(myService);
		assertNotNull(myService.getMyRepository());
	}

}
