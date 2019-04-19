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
@TableName("CCDI_RESP_CERTIFICATE")
@ApiModel(value="RespCertificate对象", description="")
public class RespCertificate extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("REQ_MAIN_ID")
    private String reqMainId;

    @TableField("CXZH")
    private String cxzh;

    @TableField("CXZL")
    private String cxzl;

    @TableField("JYLSH")
    private String jylsh;

    @TableField("PZTXLX")
    private String pztxlx;

    @TableField("PZTXXH")
    private String pztxxh;

    @TableField("FILE_PATH")
    private String filePath;

    @TableField("PZTXMC")
    private String pztxmc;

    @TableField("BEIZ")
    private String beiz;


    public static final String REQ_MAIN_ID = "REQ_MAIN_ID";

    public static final String CXZH = "CXZH";

    public static final String CXZL = "CXZL";

    public static final String JYLSH = "JYLSH";

    public static final String PZTXLX = "PZTXLX";

    public static final String PZTXXH = "PZTXXH";

    public static final String FILE_PATH = "FILE_PATH";

    public static final String PZTXMC = "PZTXMC";

    public static final String BEIZ = "BEIZ";

}
