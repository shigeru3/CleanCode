import junit.framework.TestCase;

public class TestArgsException extends TestCase {
	public void testUnexpectedMessage() throws Exception {
		ArgsException e = new ArgsException(ArgsException.ErrorCode.UNEXPECTED_ARGUMENT, 'x', null);
		assertEquals("Unexpected argument -x.", e.errorMessage());
	}

	public void testMissingStringMessage() throws Exception {
		ArgsException e = new ArgsException(ArgsException.ErrorCode.MISSING_STRING, 'x', null);
		assertEquals("Not found string parameter -x.", e.errorMessage());
	}

	public void testInvalidIntegerMessage() throws Exception {
		ArgsException e = new ArgsException(ArgsException.ErrorCode.INVALID_INTEGER, 'x', "Forty two");
		assertEquals("Argument -x needs integer. But Forty two", e.errorMessage());
	}

	public void testMissingIntegerMessage() throws Exception {
		ArgsException e = new ArgsException(ArgsException.ErrorCode.MISSING_INTEGER, 'x', null);
		assertEquals("Not found integer parameter -x.", e.errorMessage());
	}

	public void testInvalidDoubleMessage() throws Exception {
		ArgsException e = new ArgsException(ArgsException.ErrorCode.INVALID_DOUBLE, 'x', "Forty two");
		assertEquals("Argument -x needs double. But Forty two.", e.errorMessage());
	}

	public void testMissingDoubleMessage() throws Exception {
		ArgsException e = new ArgsException(ArgsException.ErrorCode.MISSING_DOUBLE, 'x', null);
		assertEquals("Not found double parameter -x.", e.errorMessage());
	}
}
