package logging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/logging2.xml")
public class LogTest2 {

	@Autowired
	private LogBean logBean;

	@Test
	public void log() {
		logBean.doIt();
	}
	
}
