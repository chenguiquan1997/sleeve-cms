package io.github.talelin.latticy.common.exception;

import io.github.talelin.autoconfigure.bean.Code;
import io.github.talelin.autoconfigure.exception.HttpException;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 添加数据异常，统一处理
 */
public class AddException  extends HttpException {

    private static final long serialVersionUID = -2012558906320161325L;
    private int code;
    private int httpCode;

    public AddException(Integer code) {
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
