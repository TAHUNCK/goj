package org.goj.common.entity.management;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 用户在线数据统计
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Online implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "hash", type = IdType.ASSIGN_ID)
    private String hash;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 浏览器发出的浏览器相关的标识字符串
     */
    private String ua;

    /**
     * 浏览器发出的一个表示访问的上个页面的网址
     */
    private String refer;

    /**
     * 最后一次修改时间
     */
    private Integer lastmove;

    /**
     * 第一次访问时间
     */
    private Integer firsttime;

    /**
     * （统一资源指示器），包括URL（统一资源定位符）和URN（统一资源名称）两种
     */
    private String uri;


}
