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
@TableName("CCDI_REQ_BASIC")
@ApiModel(value="ReqBasic对象", description="")
public class ReqBasic extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("REQ_ZIP_ID")
    private String reqZipId;

    @TableField("ATTACHMENT_ID")
    private String attachmentId;

    @TableField("QQDBS")
    private String qqdbs;

    @TableField("QQCSLX")
    private String qqcslx;

    @TableField("SQJGDM")
    private String sqjgdm;

    @TableField("SQJGMC")
    private String sqjgmc;

    @TableField("MBJGDM")
    private String mbjgdm;

    @TableField("ZTLB")
    private String ztlb;

    @TableField("AJLX")
    private String ajlx;

    @TableField("JJCD")
    private String jjcd;

    @TableField("BEIZ")
    private String beiz;

    @TableField("FSSJ")
    private String fssj;

    @TableField("FLWSH")
    private String flwsh;


    public static final String REQ_ZIP_ID = "REQ_ZIP_ID";

    public static final String ATTACHMENT_ID = "ATTACHMENT_ID";

    public static final String QQDBS = "QQDBS";

    public static final String QQCSLX = "QQCSLX";

    public static final String SQJGDM = "SQJGDM";

    public static final String SQJGMC = "SQJGMC";

    public static final String MBJGDM = "MBJGDM";

    public static final String ZTLB = "ZTLB";

    public static final String AJLX = "AJLX";

    public static final String JJCD = "JJCD";

    public static final String BEIZ = "BEIZ";

    public static final String FSSJ = "FSSJ";

    public static final String FLWSH = "FLWSH";

}
