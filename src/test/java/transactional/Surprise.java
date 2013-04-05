package transactional;

import org.junit.Before;
import org.junit.Test;

/**
 * Like NormalTest. But this time transactionalMethod() is not called
 * directly. Can you figure out why no tx handling takes place?
 */
public class Surprise extends AbstractTransactionTest {
	
	@Before
	public void setUp() {
		platformTransactionManager.reset();
	}


	@Test
	public void transactionalMethodCommitsTransaction() {
		assertCommitAndRollback(0, 0, 0);
		transactionalService.someOtherMethod();
		assertCommitAndRollback(0, 0, 0);
	}

}
