package org.goj.practice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 打印服务
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Printer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "printer_id", type = IdType.ASSIGN_ID)
    private Long printerId;

    private Long userId;

    private Date inDate;

    private Integer status;

    private Date worktime;

    private String printer;

    private String content;


}
