package transactional;

import org.junit.Test;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test is annotated with @Transactional So each test does a rollback. No need
 * to clean up the persistent state!
 */
@Transactional
public class TransactionalTest extends AbstractTransactionTest {

	@BeforeTransaction
	public void setUp() {
		platformTransactionManager.reset();
	}

	@Test
	public void testRollsbackTransaction() {
		assertCommitAndRollback(0, 0, 0);
		transactionalService.transactionalMethod();
		assertCommitAndRollback(0, 0, 0);
	}

	@AfterTransaction
	public void assertRollback() {
		assertCommitAndRollback(0, 1, 1);
	}
}
