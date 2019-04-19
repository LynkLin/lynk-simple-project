package com.lynk.business.ccdi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lynk.system.entity.base.SystemBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lynk
 * @since 2019-04-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("CCDI_REQ_ZIP")
@ApiModel(value="ReqZip对象", description="")
public class ReqZip extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("SQJGDM")
    private String sqjgdm;

    @TableField("MBJGDM")
    private String mbjgdm;

    @TableField("QQDBS")
    private String qqdbs;

    @TableField("REQ_ZIP_PATH")
    private String reqZipPath;

    @TableField("REQ_ZIP_NAME")
    private String reqZipName;

    @TableField("NESTED_STATUS")
    private String nestedStatus;

    @TableField("PARENT_REQ_ZIP_ID")
    private String parentReqZipId;

    @TableField("STATUS")
    private String status;

    @TableField("HZDM")
    private String hzdm;

    @TableField("HZSM")
    private String hzsm;

    @TableField("HZ_ZIP_PATH")
    private String hzZipPath;

    @TableField("HZ_ZIP_NAME")
    private String hzZipName;


    public static final String SQJGDM = "SQJGDM";

    public static final String MBJGDM = "MBJGDM";

    public static final String QQDBS = "QQDBS";

    public static final String REQ_ZIP_PATH = "REQ_ZIP_PATH";

    public static final String REQ_ZIP_NAME = "REQ_ZIP_NAME";

    public static final String NESTED_STATUS = "NESTED_STATUS";

    public static final String PARENT_REQ_ZIP_ID = "PARENT_REQ_ZIP_ID";

    public static final String STATUS = "STATUS";

    public static final String HZDM = "HZDM";

    public static final String HZSM = "HZSM";

    public static final String HZ_ZIP_PATH = "HZ_ZIP_PATH";

    public static final String HZ_ZIP_NAME = "HZ_ZIP_NAME";

}
