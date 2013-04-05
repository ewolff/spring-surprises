package transactional;

import org.junit.Before;
import org.junit.Test;

/**
 * "Normal" test: Method annotated with @Transactional So a commit is issued
 */
public class NormalTest extends AbstractTransactionTest {

	@Before
	public void setUp() {
		platformTransactionManager.reset();
	}

	
	@Test
	public void transactionalMethodCommitsTransaction() {
		assertCommitAndRollback(0, 0, 0);
		transactionalService.transactionalMethod();
		assertCommitAndRollback(1, 0, 1);
	}

}
