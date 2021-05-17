package io.github.talelin.latticy.common.exception;

import io.github.talelin.autoconfigure.bean.Code;
import io.github.talelin.autoconfigure.exception.HttpException;
import org.springframework.http.HttpStatus;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/11 10:58
 * @Version 1.0
 * 参数异常
 */
public class ParamException extends HttpException {
    private static final long serialVersionUID = -2585361769867559617L;

    private int code;
    private int httpCode;

    public ParamException(Integer code) {
        super(code, Code.INTERNAL_SERVER_ERROR.getDescription());
        this.httpCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.code = code;
        super.ifDefaultMessage = true;
    }

    public int getCode() {
        return this.code;
    }

    public int getHttpCode() {
        return this.httpCode;
    }
}
