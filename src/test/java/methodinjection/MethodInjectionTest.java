package methodinjection;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/methodinjection.xml")
public class MethodInjectionTest {

	@Autowired
	private Producer producer;

	@Test
	public void product() {
		Product product = producer.produceProduct();
		assertNotNull(product);
		assertNotSame(product, producer.produceProduct());
	}

}
