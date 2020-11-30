package io.github.talelin.latticy.common.exception;

import io.github.talelin.autoconfigure.bean.Code;
import io.github.talelin.autoconfigure.exception.HttpException;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 用于删除数据发生异常时，统一抛出
 */
public class DeleteException extends HttpException {
    private static final long serialVersionUID = -8731176389710218522L;

    private int code;
    private int httpCode;

    public DeleteException(Integer code) {
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
