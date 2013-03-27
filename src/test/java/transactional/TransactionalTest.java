package transactional;

import org.junit.After;
import org.junit.Test;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test is annotated with @Transactional So each test does a rollback. No need
 * to clean up the persistent state!
 */
@Transactional
public class TransactionalTest extends AbstractTransactionTest {

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
