package com.hanjie.opt.example.service;


import kim.hanjie.common.opt.OptLog;

/**
 * @author han
 * @date 2021/3/15
 */
public interface IOrderService {

    @OptLog(success = "'设置' + #orderId + ' 内容为' + #detail",
            fail = "'设置：' + #orderId + '失败'",
            bizId = "#orderId")
    boolean updateOrderDetail(Long orderId, String detail);
}
