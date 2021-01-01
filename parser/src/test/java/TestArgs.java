import junit.framework.*;

public class TestArgs extends TestCase {
	public void testCreateWithNoSchemaOrArguments() throws Exception {
		Args args = new Args("", new String[0]);
		assertEquals(0, args.cardinality());
	}

	public void testWithNoSchemaButWithOneArgument() throws Exception {
		Args args = new Args("", new String[]{"-x"});
		assertEquals(false, args.isValid());
	}

	public void testWithNoSchemaButWithMultipleArguments() throws Exception {
		Args args = new Args("", new String[]{"-x", "-y"});
		assertEquals(false, args.isValid());
	}

	public void testNonLetterSchema() throws Exception {
		Args args = new Args("*", new String[]{});
		assertEquals(false, args.isValid());
	}
}
