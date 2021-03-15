package com.hanjie.opt.example.opt;

import com.hanjie.opt.example.service.BizException;
import com.hanjie.opt.example.service.Result;
import kim.hanjie.easy.opt.OptStatus;
import kim.hanjie.easy.opt.OptStatusPolicy;

import java.lang.reflect.Method;

/**
 * @author han
 * @date 2021/3/14
 */
public class CommonOptStatusPolicy extends OptStatusPolicy {


    @Override
    public OptStatus exceptionStatus(Throwable throwable) {
        if (throwable instanceof BizException) {
            return OptStatus.FAIL;
        }
        return super.exceptionStatus(throwable);
    }

    @Override
    protected OptStatus notNullReturnStatus(Method method, Object retObj) {
        if (retObj instanceof Result) {
            return ((Result) retObj).isSuccess() ? OptStatus.SUCCESS : OptStatus.FAIL;
        }
        return super.notNullReturnStatus(method, retObj);
    }
}
