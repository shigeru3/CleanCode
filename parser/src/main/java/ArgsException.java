public class ArgsException extends Exception {

	public enum ErrorCode {
		OK, UNEXPECTED_ARGUMENT
	}

	public ArgsException() {

	}

	public ArgsException(String message) {
		super(message);
	}

	public ErrorCode getErrorCode() {
		return ErrorCode.UNEXPECTED_ARGUMENT;
	}

	public String getErrorArgumentId() {
		return "x";
	}
}
