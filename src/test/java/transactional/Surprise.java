package transactional;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * Like TransactionalTest But this time transactionalMethod() is not called
 * directly. Can you figure out why no tx handling takes place?
 */
@Transactional
public class Surprise extends AbstractTransactionTest {

	@Test
	public void transactionalMethodCommitsTransaction() {
		assertCommitAndRollback(0, 0, 0);
		transactionalService.someOtherMethod();
		assertCommitAndRollback(0, 0, 0);
	}

}
