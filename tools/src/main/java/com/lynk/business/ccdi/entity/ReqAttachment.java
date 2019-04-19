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
@TableName("CCDI_REQ_ATTACHMENT")
@ApiModel(value="ReqAttachment对象", description="")
public class ReqAttachment extends SystemBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("REQ_ZIP_ID")
    private String reqZipId;

    @TableField("ATTACHMENT_TYPE")
    private String attachmentType;

    @TableField("FILE_PATH")
    private String filePath;

    @TableField("FILE_NAME")
    private String fileName;


    public static final String REQ_ZIP_ID = "REQ_ZIP_ID";

    public static final String ATTACHMENT_TYPE = "ATTACHMENT_TYPE";

    public static final String FILE_PATH = "FILE_PATH";

    public static final String FILE_NAME = "FILE_NAME";

}
