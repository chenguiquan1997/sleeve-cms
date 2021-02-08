package io.github.talelin.latticy.common.exception;

import io.github.talelin.autoconfigure.bean.Code;


import io.github.talelin.autoconfigure.exception.HttpException;
import org.springframework.http.HttpStatus;

/**
 * 用于更新数据发生异常时，统一抛出
 */
public class UpdateException extends HttpException {

    private static final long serialVersionUID = 3708831052935371529L;
    private int code;
    private int httpCode;

    public UpdateException(Integer code) {
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
