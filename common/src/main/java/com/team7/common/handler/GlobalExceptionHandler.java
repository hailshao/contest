package com.team7.common.handler;

import com.team7.common.BusinessRuntimeException;
import com.team7.common.http.BusinessResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhangsan
 * @description 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessRuntimeException.class)
    public <T> BusinessResponseEntity<T> handleRuntimeException(BusinessRuntimeException e) {
        log.error(e.getMessage(), e);
        return BusinessResponseEntity.error(e);
    }

    @ExceptionHandler(Exception.class)
    public <T> BusinessResponseEntity<T> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return BusinessResponseEntity.error(e);
    }

}
