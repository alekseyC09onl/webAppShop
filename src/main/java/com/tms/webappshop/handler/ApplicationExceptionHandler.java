package com.tms.webappshop.handler;

import com.tms.webappshop.common.ApiError;
import com.tms.webappshop.exceptions.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {


    private ResponseEntity<Object> buildResponse(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }

//    @ExceptionHandler(RoleException.class)
//    public ResponseEntity<Object> handleRoleException(RoleException roleException) {
//        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
//        apiError.setMessage(roleException.getMessage());
//        return buildResponse(apiError);
//    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<Object> handleRoleException(UserException userException) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(userException.getMessage());
        return buildResponse(apiError);
    }

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<Object> handleRoleException(ProductException productException) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(productException.getMessage());
        return buildResponse(apiError);
    }

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<Object> handleRoleException(OrderException orderException) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(orderException.getMessage());
        return buildResponse(apiError);
    }

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<Object> handleRoleException(CustomerException customerException) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(customerException.getMessage());
        return buildResponse(apiError);
    }

    @ExceptionHandler(AddressException.class)
    public ResponseEntity<Object> handleRoleException(AddressException addressException) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(addressException.getMessage());
        return buildResponse(apiError);
    }


}
