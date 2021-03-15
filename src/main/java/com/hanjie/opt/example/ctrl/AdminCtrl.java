package com.hanjie.opt.example.ctrl;

import com.hanjie.opt.example.service.IOrderService;
import com.hanjie.opt.example.service.OrderDO;
import com.hanjie.opt.example.service.Response;
import com.hanjie.opt.example.service.UserDO;
import com.hanjie.opt.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author han
 * @date 2021/3/11
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminCtrl {


    @Autowired
    private UserService userService;
    @Autowired
    private IOrderService orderService;

    @PostMapping("/setPassword")
    public Response setPassword(@RequestBody UserDO user) {
        userService.updatePasswordSuccess(user.getId(), user.getPassword());
//        userService.updatePasswordSuccess(user);
//        userService.updatePasswordFail(user);
//        userService.updatePasswordFail(300L, user);
//        userService.updatePasswordBizException(null, null);
//        userService.updatePasswordException(null, null);
        return Response.success();
    }

    @PostMapping("/setOrder")
    public Response setOrder(@RequestBody OrderDO orderDO) {
        orderService.updateOrderDetail(orderDO.getOrderId(), orderDO.getDetail());
        return Response.success();
    }
}
