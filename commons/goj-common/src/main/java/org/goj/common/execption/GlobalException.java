package org.goj.common.execption;

import org.goj.common.model.Result;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author CK
 * @date 2020/10/11 11:17
 */
@ControllerAdvice
public class GlobalException {

    /**
     * 全局异常处理
     *
     * @param e 1
     * @return cn.intelhotel.commonutils.Result
     * @author CK
     * @date 2020/9/30 10:22
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<String> error(Exception e) {
        e.printStackTrace();
        return Result.failed(e.getMessage());
    }
}
