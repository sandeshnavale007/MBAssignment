package com.management.employee.exceptions;

public class ApiResponseException extends RuntimeException {

    private Integer code;
    private String message;

    public ApiResponseException(String message, Integer code) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class ApiResponseExceptionBuilder {
        private String message;
        private Integer code;

        public ApiResponseExceptionBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public ApiResponseExceptionBuilder setCode(Integer code) {
            this.code = code;
            return this;
        }

        public ApiResponseException createApiResponseException() {
            return new ApiResponseException(message, code);
        }
    }
}
