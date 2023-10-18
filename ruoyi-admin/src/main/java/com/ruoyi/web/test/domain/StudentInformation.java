package com.ruoyi.web.test.domain;


import lombok.Data;


import java.io.Serializable;

@Data
public class StudentInformation implements Serializable,Cloneable {
    /** 页码 */
    private Integer off;
    /** 页数 */
    private Integer num;
    /**
     * 学生id
     */
    private Long id;
    /**
     * 名字
     */
    private String name;
    /**
     * 性别
     */
    private String gender;
    /**
     * 年龄
     */
    private Integer year;
    /**
     * 电话
     */
    private String phone;
    /**
     * 逻辑删除
     */
    private Integer whereDelete;
}
