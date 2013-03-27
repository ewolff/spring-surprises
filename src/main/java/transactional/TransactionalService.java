package transactional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionalService {
	
	@Transactional
	public void transactionalMethod() {
	}
	
	public void someOtherMethod() {
		transactionalMethod();
	}

}
