package com.management.employee.modal;

public  class BaseException extends Exception {
    private Integer code;
    private String message;
    private String appMessage;

    public BaseException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseException(Integer code, String message, String appMessage) {
        this.code = code;
        this.message = message;
        this.appMessage = appMessage;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getAppMessage() {
        return this.appMessage;
    }
}

