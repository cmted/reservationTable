package com.example.reservation.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //duplication key exception
    //捕获唯一值出现重复异常，return前端异常信息
    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public Object exceptionHandlerDuplicate(){
        return "This table has been reserved.";
    }

    //捕获自定义异常，return前端异常信息，使用方式在CustomerService的saveCustomer方法中
    @ExceptionHandler(value = MyException.class)
    public Object MyExceptionHandler(MyException e){
            logger.error(e.getErrorMsg());
            return "The reservation is full.";
    }

}
