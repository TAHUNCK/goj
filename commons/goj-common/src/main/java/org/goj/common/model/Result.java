package org.goj.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.goj.common.constant.ResultCode;

import java.io.Serializable;

/**
 * @author CK
 * @date 2020/10/11 10:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private String code;

    private String message;

    private T data;

    /**
     * @author CK
     * @date 2020/10/10 10:42
     */
    public static <T> Result<T> succeed(String message) {
        return succeed(ResultCode.SUCCESS.getCode(), message,null);
    }

    /**
     * @author CK
     * @date 2020/10/10 10:42
     */
    public static <T> Result<T> succeed(String message,T data) {
        return succeed(ResultCode.SUCCESS.getCode(), message,data);
    }

    /**
     * @author CK
     * @date 2020/10/10 10:42
     */
    public static <T> Result<T> succeed(T data) {
        return succeed(ResultCode.SUCCESS.getCode(), "success",data);
    }

    /**
     * @author CK
     * @date 2020/10/10 10:42
     */
    public static <T> Result<T> succeed(String code, String message,T data) {
        return new Result<>(code, message,data);
    }

    /**
     * @author CK
     * @date 2020/12/15 20:33
     */
    public static <T> Result<T> succeed(String code, String message) {
        return new Result<>(code, message,null);
    }

    /**
     * @author CK
     * @date 2020/10/10 10:42
     */
    public static <T> Result<T> failed(String message) {
        return failed(ResultCode.UNKNOWN_ERROR.getCode(), message,null);
    }

    public static <T> Result<T> failed(String code, String message) {
        return new Result<>(code, message,null);
    }

    /**
     * @author CK
     * @date 2020/10/10 10:42
     */
    public static <T> Result<T> failed(String message,T data) {
        return failed(ResultCode.UNKNOWN_ERROR.getCode(), message,data);
    }

    /**
     * @author CK
     * @date 2020/10/10 10:42
     */
    public static <T> Result<T> failed(T data) {
        return succeed(ResultCode.UNKNOWN_ERROR.getCode(), "",data);
    }


    /**
     * @author CK
     * @date 2020/10/10 10:42
     */
    public static <T> Result<T> failed(String code, String message,T data) {
        return new Result<>(code, message,data);
    }
}
