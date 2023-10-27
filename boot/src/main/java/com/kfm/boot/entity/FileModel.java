package com.kfm.boot.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件类
 */
@Data
public class FileModel implements Serializable {

    /**
     * 文件编号
     */
    private Integer id;

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件路径
     */
    private String path;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 文件类型
     */
    private String type;

    /**
     * 文件创建时间
     */
    private Date createTime;

    /**
     * 文件创建人
     */
    private Integer createUser;
}

