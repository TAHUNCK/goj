package org.goj.common.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private Long userId;

    /**
     * 用户E-mail
     */
    private String email;

    /**
     * 用户提交次数
     */
    private Integer submit;

    /**
     * 成功次数
     */
    private Integer solved;

    /**
     * 是否屏蔽
     */
    private String defunct;

    /**
     * 用户注册ip
     */
    private String ip;

    /**
     * 用户注册时间
     */
    private Date accessTime;

    /**
     * 页码（表示用户上次看到第几页）
     */
    private Integer volume;

    /**
     * 语言
     */
    private Integer language;

    /**
     * 密码（加密）
     */
    private String password;

    /**
     * 用户注册时间
     */
    private Date regTime;

    /**
     * 昵称
     */
    private String nick;

    /**
     * 用户所在学校
     */
    private String school;

    /**
     * 用户头像
     */
    private String headPortrait;

    @TableField(exist = false)
    private String username;

    @TableField(exist = false)
    List<Role> roles;


}
