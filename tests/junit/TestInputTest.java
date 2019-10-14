package junit;

import junit.framework.TestCase;
import pass.TestInput;

/**
 * 
 */

/**
 * @author Jimmy
 *
 */
public class TestInputTest extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testDoUntil() {
		//extra
		this.assertEquals(TestInput.doUntil(3), 3);
	}
	
	public void testDoWhile() {
		//5.6
		this.assertEquals(TestInput.doWhile(3), 3);
		this.assertEquals(TestInput.doWhile(1), 1);
	}
	
	public void testForLoop() {
		//5.7
		this.assertEquals(TestInput.forLoop(3), 3);
		this.assertEquals(TestInput.forLoop(1), 1);
	}
	
	public void testConditional() {
		//5.11
		this.assertEquals(TestInput.conditional(true), true);
		this.assertEquals(TestInput.conditional(false), false);
	}
	
	public void testConditionalOr() {
		//5.12
		this.assertEquals(TestInput.conditionalOr(true, true), true);
		this.assertEquals(TestInput.conditionalOr(true, false), true);
		this.assertEquals(TestInput.conditionalOr(false, true), true);
		this.assertEquals(TestInput.conditionalOr(false, false), false);
	}
	
	public void testLongLiteral() {
		//5.21 bonus
		
	}

}
