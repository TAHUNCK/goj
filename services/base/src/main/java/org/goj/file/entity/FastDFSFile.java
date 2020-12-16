package org.goj.file.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author CK
 * @date 2020/10/6 19:46
 */
@Data
public class FastDFSFile implements Serializable {

    /**
     * 文件名
     * @author CK
     * @date 2020/10/6 19:47
     */
    private String name;

    /**
     * 文件内容
     * @author CK
     * @date 2020/10/6 19:49
     */
    private byte[] content;

    /**
     * 文件扩展名
     * @author CK
     * @date 2020/10/6 19:49
     */
    private String ext;

    /**
     * 文件MD5摘要值
     * @author CK
     * @date 2020/10/6 19:49
     */
    private String md5;

    /**
     * 文件创建作者
     * @author CK
     * @date 2020/10/6 19:50
     */
    private String author;

    /**
     * 必须字段
     * @author CK
     * @date 2020/10/6 19:50
     */
    public FastDFSFile(String name, byte[] content, String ext) {
        this.name = name;
        this.content = content;
        this.ext = ext;
    }

}

