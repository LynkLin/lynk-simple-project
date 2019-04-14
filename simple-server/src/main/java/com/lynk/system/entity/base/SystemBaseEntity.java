package com.lynk.system.entity.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Lynk
 * @since: 2019/4/13
 */
@Data
@Accessors(chain = true)
public class SystemBaseEntity implements Serializable {

    @ApiModelProperty("id")
    @TableId(value = "ID", type = IdType.ID_WORKER_STR)
    protected String id;

    @ApiModelProperty(hidden = true)
    @TableField(value = "GMT_CREATE", fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @ApiModelProperty(hidden = true)
    @TableField(value = "GMT_MODIFIED", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;


    public static final String ID = "id";

    public static final String GMT_CREATE = "gmt_create";

    public static final String GMT_MODIFIED = "gmt_modified";
}
