public class ArgsException extends Exception {
	private char errorArgumentId = '\0';
	private String errorParameter = "TILT";
	private ErrorCode errorCode = ErrorCode.OK;

	public ArgsException() {}

	public ArgsException(String message) {
		super(message);
	}

	public ArgsException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public ArgsException(ErrorCode errorCode, String errorParameter) {
		this.errorCode = errorCode;
		this.errorParameter = errorParameter;
	}

	public ArgsException(ErrorCode errorCode, char errorArgument, String errorParameter) {
		this.errorCode = errorCode;
		this.errorParameter = errorParameter;
		this.errorArgumentId = errorArgument;
	}

	public char getErrorArgumentId() {
		return errorArgumentId;
	}

	public void setErrorArgumentId(char errorArgumentId) {
		this.errorArgumentId = errorArgumentId;
	}

	public String getErrorParameter() {
		return errorParameter;
	}

	public void setErrorParameter(String errorParameter) {
		this.errorParameter = errorParameter;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public String errorMessage() throws Exception {
		switch (errorCode) {
			case OK:
				throw new Exception("TILT: Here must not execute.");
			case UNEXPECTED_ARGUMENT:
				return String.format("Unexpected argument -%c.", errorArgumentId);
			case MISSING_STRING:
				return String.format("Not found string parameter -%c.", errorArgumentId);
			case INVALID_INTEGER:
				return String.format("Argument -%c needs integer. But %s", errorArgumentId, errorParameter);
			case MISSING_INTEGER:
				return String.format("Not found integer parameter -%c.", errorArgumentId);
			case INVALID_DOUBLE:
				return String.format("Argument -%c needs double. But %s.", errorArgumentId, errorParameter);
			case MISSING_DOUBLE:
				return String.format("Not found double parameter -%c.", errorArgumentId);
		}
		return "";
	}

	enum ErrorCode{
		OK, MISSING_INTEGER, MISSING_STRING, INVALID_INTEGER, UNEXPECTED_ARGUMENT, MISSING_DOUBLE, INVALID_DOUBLE,
		INVALID_FORMAT, INVALID_ARGUMENT_NAME
	}
}
