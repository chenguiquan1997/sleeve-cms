package io.github.talelin.latticy.common.exception;

import io.github.talelin.autoconfigure.bean.Code;
import io.github.talelin.autoconfigure.exception.HttpException;
import org.springframework.http.HttpStatus;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/24 14:32
 * @Version 1.0
 */
public class NotFoundException extends  HttpException{

    private static final long serialVersionUID = 8455978862743426839L;

    private int code;
    private int httpCode;

    public NotFoundException(Integer code) {
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
