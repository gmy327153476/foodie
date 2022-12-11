package com.soft.enums;

/**
 * @Author: Mengyuan Guo
 * @Description:
 * @Date: 2021/10/28 15:01
 */
public enum Sex {
    woman(0, "女"),
    man(1, "男"),
    secret(2, "保密");

    public Integer type;
    public String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
