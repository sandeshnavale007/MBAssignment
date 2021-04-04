package com.management.employee.modal;

public final class CustomException extends BaseException {

    private static final int code = 200;
    private static final String appMessage = "Not Found";
    private static final String message = "Not found";

    public CustomException(Integer code, String message, String appMessage) {
        super(code, message, appMessage);
    }

    public CustomException() {
        super(code, message, appMessage);
    }

    public CustomException(String message) {
        super(code, message, appMessage);
    }

    public CustomException(String message, String appMessage) {
        super(code, message, appMessage);
    }

    public CustomException(String message, String appMessage, int code) {
        super(code, message, appMessage);

    }
}

