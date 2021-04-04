package com.management.employee.modal;

public class ApiResponseError {
    private int code;
    private String message;

    public ApiResponseError(int code, String message) {
        this.code = code;
        this.message = message;
    }



	public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class ApiResponseErrorBuilder {
        private int code;
        private String message;

        public ApiResponseErrorBuilder setCode(int code) {
            this.code = code;
            return this;
        }

        public ApiResponseErrorBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public ApiResponseError createApiResponseError() {
            return new ApiResponseError(code, message);
        }
    }
}