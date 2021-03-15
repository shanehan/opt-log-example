package com.hanjie.opt.example.service;

import lombok.Data;

/**
 * @author han
 * @date 2021/3/11
 */
@Data
public class UserDO {

    private Long id;
    private String name;
    private String password;

    public UserDO() {
    }

    public UserDO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
