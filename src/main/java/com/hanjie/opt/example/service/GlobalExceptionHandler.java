package com.hanjie.opt.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author han
 * @date 2019/12/21
 */
@Order(1000)
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @Value("${spring.application.name}")
    private String appName;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Response exceptionHandler(Exception e) {
        LOG.error(e.getMessage(), e);
        return Response.error(appName, "system error");
    }

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Response bizExceptionHandler(BizException e) {
        LOG.info(e.getMessage());
        return Response.commonBizError(e.getMessage());
    }
}
