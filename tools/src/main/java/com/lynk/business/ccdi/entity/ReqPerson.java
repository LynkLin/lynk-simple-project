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
@TableName("CCDI_REQ_PERSON")
@ApiModel(value="ReqPerson对象", description="")
public class ReqPerson extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("REQ_BASIC_ID")
    private String reqBasicId;

    @TableField("QQRXM")
    private String qqrxm;

    @TableField("QQRZJLX")
    private String qqrzjlx;

    @TableField("QQRZJHM")
    private String qqrzjhm;

    @TableField("QQRDWMC")
    private String qqrdwmc;

    @TableField("QQRSJH")
    private String qqrsjh;

    @TableField("XCRXM")
    private String xcrxm;

    @TableField("XCRZJLX")
    private String xcrzjlx;

    @TableField("XCRZJHM")
    private String xcrzjhm;


    public static final String REQ_BASIC_ID = "REQ_BASIC_ID";

    public static final String QQRXM = "QQRXM";

    public static final String QQRZJLX = "QQRZJLX";

    public static final String QQRZJHM = "QQRZJHM";

    public static final String QQRDWMC = "QQRDWMC";

    public static final String QQRSJH = "QQRSJH";

    public static final String XCRXM = "XCRXM";

    public static final String XCRZJLX = "XCRZJLX";

    public static final String XCRZJHM = "XCRZJHM";

}
