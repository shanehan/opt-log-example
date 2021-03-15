package com.hanjie.opt.example.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author han
 * @date 2021/3/11
 */
@Data
public class Result<D> {

    private boolean success;
    private String message;
    private D data;

    public Result() {
    }

    public Result(boolean success, String message, D data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public static <D> Result<D> ofSuccess() {
        return new Result<>(true, null, null);
    }

    public static <D> Result<D> ofSuccess(D data) {
        return new Result<>(true, null, data);
    }

    public static <D> Result<D> ofFail(String message) {
        return new Result<>(false, message, null);
    }
}
