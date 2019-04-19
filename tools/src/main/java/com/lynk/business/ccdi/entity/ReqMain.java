package com.lynk.business.ccdi.entity;

import java.math.BigDecimal;
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
@TableName("CCDI_REQ_MAIN")
@ApiModel(value="ReqMain对象", description="")
public class ReqMain extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("REQ_BASIC_ID")
    private String reqBasicId;

    @TableField("FLDM")
    private String fldm;

    @TableField("SEQ_NO")
    private String seqNo;

    @TableField("PROCESS_APPROVAL")
    private String processApproval;

    @TableField("RESP_APPROVAL")
    private String respApproval;

    @TableField("STATUS")
    private String status;

    @TableField("DYNAMICAL_STATUS")
    private String dynamicalStatus;

    @TableField("RWLSH")
    private String rwlsh;

    @TableField("ZH")
    private String zh;

    @TableField("ZZLXDM")
    private String zzlxdm;

    @TableField("ZZHM")
    private String zzhm;

    @TableField("ZTMC")
    private String ztmc;

    @TableField("SJHM")
    private String sjhm;

    @TableField("CXNR")
    private String cxnr;

    @TableField("MXSDLX")
    private String mxsdlx;

    @TableField("KSSJ")
    private String kssj;

    @TableField("JSSJ")
    private String jssj;

    @TableField("YRWLSH")
    private String yrwlsh;

    @TableField("ZXSJQJ")
    private String zxsjqj;

    @TableField("ZHXH")
    private String zhxh;

    @TableField("DJFS")
    private String djfs;

    @TableField("JE")
    private BigDecimal je;

    @TableField("BZ")
    private String bz;

    @TableField("CXZL")
    private String cxzl;

    @TableField("JYLSH")
    private String jylsh;

    @TableField("CXFKJG")
    private String cxfkjg;

    @TableField("CXFKJGYY")
    private String cxfkjgyy;

    @TableField("FKSJHM")
    private String fksjhm;


    public static final String REQ_BASIC_ID = "REQ_BASIC_ID";

    public static final String FLDM = "FLDM";

    public static final String SEQ_NO = "SEQ_NO";

    public static final String PROCESS_APPROVAL = "PROCESS_APPROVAL";

    public static final String RESP_APPROVAL = "RESP_APPROVAL";

    public static final String STATUS = "STATUS";

    public static final String DYNAMICAL_STATUS = "DYNAMICAL_STATUS";

    public static final String RWLSH = "RWLSH";

    public static final String ZH = "ZH";

    public static final String ZZLXDM = "ZZLXDM";

    public static final String ZZHM = "ZZHM";

    public static final String ZTMC = "ZTMC";

    public static final String SJHM = "SJHM";

    public static final String CXNR = "CXNR";

    public static final String MXSDLX = "MXSDLX";

    public static final String KSSJ = "KSSJ";

    public static final String JSSJ = "JSSJ";

    public static final String YRWLSH = "YRWLSH";

    public static final String ZXSJQJ = "ZXSJQJ";

    public static final String ZHXH = "ZHXH";

    public static final String DJFS = "DJFS";

    public static final String JE = "JE";

    public static final String BZ = "BZ";

    public static final String CXZL = "CXZL";

    public static final String JYLSH = "JYLSH";

    public static final String CXFKJG = "CXFKJG";

    public static final String CXFKJGYY = "CXFKJGYY";

    public static final String FKSJHM = "FKSJHM";

}
