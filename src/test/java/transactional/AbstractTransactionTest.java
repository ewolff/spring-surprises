package transactional;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

/**
 * Base class to derive tests from. Provides common Spring configuration
 * and some other helper methods.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/transactional.xml")
@Transactional
public abstract class AbstractTransactionTest {

	@Autowired
	private StubPlatformTransactionManager platformTransactionManager;
	
	@Autowired
	protected TransactionalService transactionalService;
	
	@BeforeTransaction
	public void setUp() {
		platformTransactionManager.reset();
	}

	protected void assertCommitAndRollback(int commit, int rollback, int total) {
		assertEquals("Commit", commit, platformTransactionManager.getCommit());
		assertEquals("Rollback",rollback, platformTransactionManager.getRollback());
		assertEquals("Total",total, platformTransactionManager.getTotal());
	}

}
