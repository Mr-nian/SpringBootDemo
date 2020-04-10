package com.wego.common.exception;

/**
 * 自定义业务异常
 *
 * @author caoyn
 * @date 2020/4/10
 */

public class BusinessException extends  RuntimeException {
    public BusinessException(String msg){
        super(msg);
    }
}