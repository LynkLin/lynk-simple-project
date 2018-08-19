package com.lynk.system.entity.base;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Lynk
 * @since: 2017/8/5
 */
public class SystemBaseEntity<T extends Model> extends Model<T> {

    @ApiModelProperty("id")
    @TableId(value = "ID", type = IdType.ID_WORKER_STR)
    protected String id;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @TableField(value = "GMT_CREATE", fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @TableField(value = "GMT_MODIFIED", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public static final String ID = "id";

    public static final String GMT_CREATE = "gmt_create";

    public static final String GMT_MODIFIED = "gmt_modified";
}
