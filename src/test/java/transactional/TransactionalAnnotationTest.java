package transactional;

import org.junit.Test;
import org.springframework.test.context.transaction.AfterTransaction;

/**
 * "Normal" test: Method annotated with @Transactional So a commit is issued
 */
public class TransactionalAnnotationTest extends AbstractTransactionTest {

	@Test
	public void transactionalMethodCommitsTransaction() {
		assertCommitAndRollback(0, 0, 0);
		transactionalService.transactionalMethod();
		assertCommitAndRollback(0, 0, 0);
	}

	@AfterTransaction
	public void assertRollback() {
		assertCommitAndRollback(0, 1, 1);
	}

}
