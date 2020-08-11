package co.kesti.smartcity.error;

/**
 * 사용자 예외처리
 */
public class UserOkException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ResponseCode responseCode;

    public UserOkException(String msg) {
        super(msg);
        this.responseCode = ResponseCode.INTERNAL_SERVER_ERROR;
    }

    public UserOkException(String msg, ResponseCode code) {
        super(msg);
        this.responseCode = code;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

}
