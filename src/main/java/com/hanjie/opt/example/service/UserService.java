package com.hanjie.opt.example.service;

import kim.hanjie.common.opt.OptLog;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author han
 * @date 2021/3/11
 */
@Service
public class UserService {


    @OptLog(success = "'设置' + #id + '的密码为' + #password + '  updatePasswordSuccess(Long id, String password)'",
            fail = "'设置失败：' + #_retObj.message",
            bizId = "#id")
    public Result<Boolean> updatePasswordSuccess(Long id, String password) {
        return Result.ofSuccess();
    }

    @OptLog(success = "'设置' + #user.id + '密码为' + #user.password + ' updatePasswordSuccess(UserDO user)'",
            fail = "'设置失败：' + #_retObj.message",
            bizId = "#user.id")
    public Result<Boolean> updatePasswordSuccess(UserDO user) {
        return Result.ofSuccess();
    }

    @OptLog(success = "'设置' + #user.id + '密码为' + #user.password + ' updatePasswordFail(UserDO user)' + #_context.get('reqId')",
            fail = "'设置失败：' + #_retObj + #_retObj.message +  #_retObj.getMessage()",
            operator = "#_context.get('reqId')",
            module = "#_retObj.message",
            bizId = "#user.id")
    public Result<Boolean> updatePasswordFail(UserDO user) {
        return Result.ofFail("错啦");
    }

    @OptLog(success = "'设置' + #user.id + '密码为' + #user.password + ' updatePasswordFail(UserDO user)'",
            operator = "#adminUserId",
            fail = "'设置失败：' + #_retObj.message",
            bizId = "#user.id")
    public Result<Boolean> updatePasswordFail(Long adminUserId, UserDO user) {
        return Result.ofFail("错啦");
    }

    @OptLog(success = "'设置' + #user.id + '密码为' + #user.password",
            operator = "#adminId")
    public Result<Boolean> updatePasswordFail2(Long adminId, UserDO user) {
        return Result.ofFail("错啦");
    }

    @OptLog(success = "'设置' + #user.id + '密码为' + #user.password + ' updatePasswordException(Long adminUserId, UserDO user)'",
            operator = "#adminUserId",
            fail = "'设置失败：' + #_retObj.message + #_errorMsg",
            exception = "'设置出异常了：' + #_errorMsg",
            bizId = "#user.id")
    public Result<Boolean> updatePasswordException(Long adminUserId, UserDO user) {
        if (user == null) {
            throw new NullPointerException("user 对象为空");
        }
        return Result.ofFail("错啦");
    }

    @OptLog(success = "'设置' + #user.id + '密码为' + #user.password + ' updatePasswordBizException(Long adminUserId, UserDO user)'",
            operator = "#adminUserId",
            fail = "'设置失败：' + #_errorMsg",
            exception = "'设置出异常了：' + #_errorMsg",
            bizId = "#{user.id}")
    public Result<Boolean> updatePasswordBizException(Long adminUserId, UserDO user) {
        if (user == null) {
            throw new BizException("user 对象为空");
        }
        return Result.ofSuccess();
    }

    public Result<Long> editUserSuccess(UserDO user) {
        return Result.ofSuccess(1L);
    }

    @OptLog(success = "#user.id == null ? '新增' : '编辑'",
            fail = "'设置失败：' + #_errorMsg",
            bizId = "#user.id == null ? #_retObj.data : #user.id",
            level = 5)
    public Result<Long> editUserLevel5(UserDO user) {
        return Result.ofSuccess(1L);
    }

    @OptLog(success = "'编辑' + #user.id",
            fail = "'设置失败：' + #_errorMsg",
            bizId = "#{user.id}",
            level = 10)
    public Result<Long> editUserLevel10(UserDO user) {
        return Result.ofSuccess(1L);
    }


    @OptLog(success = "'编辑用户: ' + #users.![id]", bizId = "#users.![id]")
    public Result editUsers(List<UserDO> users) {
        return Result.ofSuccess();
    }
}
