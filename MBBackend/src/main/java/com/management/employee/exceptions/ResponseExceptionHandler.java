package com.management.employee.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.employee.modal.APIResponse;
import com.management.employee.modal.ApiResponseError;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ObjectMapper objectMapper;
    private static String serviceName = "ESPORTS_SERVICE";

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        APIResponse responseObj = new APIResponse.APIResponseBuilder<>().setSuccess(false).setError(new ApiResponseError.ApiResponseErrorBuilder()
                .setCode(00).setMessage(errors.get(0)).createApiResponseError()).createAPIResponse();
        return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers, HttpStatus status, WebRequest request) {
        APIResponse responseObj = new APIResponse.APIResponseBuilder<>().setSuccess(false)
                .setError(new ApiResponseError.ApiResponseErrorBuilder().setCode(00)
                        .setMessage(ex.getParameterName() + " is mandatory!").createApiResponseError())
                .createAPIResponse();
        return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        APIResponse responseObj = new APIResponse.APIResponseBuilder<>().setSuccess(false)
                .setError(new ApiResponseError.ApiResponseErrorBuilder().setCode(00)
                        .setMessage("").createApiResponseError())
                .createAPIResponse();
        return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
                                                                   HttpStatus status, WebRequest request) {
        APIResponse responseObj = new APIResponse.APIResponseBuilder<>().setSuccess(false)
                .setError(new ApiResponseError.ApiResponseErrorBuilder().setCode(00)
                        .setMessage("").createApiResponseError())
                .createAPIResponse();
        return ResponseEntity.status(status).headers(headers).body(responseObj);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleSuperException(RuntimeException ex, WebRequest request,
                                                          HandlerMethod handlerMethod) {
        Object requestBody = request.getAttribute("requestBody", RequestAttributes.SCOPE_REQUEST);
        String apiName = ((ServletWebRequest) request).getRequest().getRequestURI();

        //TODO log exception here
        APIResponse responseObj = new APIResponse.APIResponseBuilder<>().setSuccess(false)
                .setError(new ApiResponseError.ApiResponseErrorBuilder().setCode(00)
                        .setMessage(ex.getMessage()).createApiResponseError())
                .createAPIResponse();
        return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }

    @ExceptionHandler(value = {ApiResponseException.class})
    protected ResponseEntity<Object> handleApiResponseException(ApiResponseException ex, WebRequest request, HandlerMethod handlerMethod) {
        Object requestBody = request.getAttribute("requestBody", RequestAttributes.SCOPE_REQUEST);
        String apiName = ((ServletWebRequest) request).getRequest().getRequestURI();

        //TODO log exception here
        APIResponse responseObj = new APIResponse.APIResponseBuilder<>().setSuccess(false)
                .setError(new ApiResponseError.ApiResponseErrorBuilder()
                        .setCode(ex.getCode() != null ? ex.getCode() : 500)
                        .setMessage(ex.getMessage() != null ? ex.getMessage() : "").createApiResponseError())
                .createAPIResponse();
        return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
}
