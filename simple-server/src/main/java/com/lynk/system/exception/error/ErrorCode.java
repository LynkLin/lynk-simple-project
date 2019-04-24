package com.lynk.system.exception.error;

import com.lynk.system.exception.annotation.ErrorCodeDefinition;
import com.lynk.system.exception.annotation.ErrorDefinition;
import org.springframework.stereotype.Component;

/**
 * @author Lynk on 2016/12/30.
 */
@ErrorDefinition
@Component
public class ErrorCode {
    /**
     * 连接FTP失败
     */
    @ErrorCodeDefinition(description = "连接FTP失败")
    public static final String FTP001 = "FTP001";
    /**
     * 登录FTP失败
     */
    @ErrorCodeDefinition(description = "登录FTP失败")
    public static final String FTP002 = "FTP002";
    /**
     * FTP设置二进制传输模式失败
     */
    @ErrorCodeDefinition(description = "FTP设置二进制传输模式失败")
    public static final String FTP003 = "FTP003";
    /**
     * FTP上传文件失败: {0}
     */
    @ErrorCodeDefinition(description = "FTP上传文件失败: {0}")
    public static final String FTP004 = "FTP004";
    /**
     * FTP下载文件失败: {0}
     */
    @ErrorCodeDefinition(description = "FTP下载文件失败: {0}")
    public static final String FTP005 = "FTP005";
    /**
     * FTP获取文件列表失败: {0}
     */
    @ErrorCodeDefinition(description = "FTP获取文件列表失败: {0}")
    public static final String FTP006 = "FTP006";
    /**
     * FTP删除文件失败: {0}
     */
    @ErrorCodeDefinition(description = "FTP删除文件失败: {0}")
    public static final String FTP007 = "FTP007";
    /**
     * FTP创建目录失败: {0}
     */
    @ErrorCodeDefinition(description = "FTP创建目录失败: {0}")
    public static final String FTP008 = "FTP008";
    /**
     * FTP移动文件失败: {0} > {1}
     */
    @ErrorCodeDefinition(description = "FTP移动文件失败: {0} > {1}")
    public static final String FTP009 = "FTP009";
    /**
     * FTP进入目录失败: {0}
     */
    @ErrorCodeDefinition(description = "FTP进入目录失败: {0}")
    public static final String FTP010 = "FTP010";
    /**
     * FTP断开连接失败
     */
    @ErrorCodeDefinition(description = "FTP断开连接失败")
    public static final String FTP011 = "FTP011";
    /**
     * FTP本地文件不存在
     */
    @ErrorCodeDefinition(description = "FTP本地文件不存在")
    public static final String FTP012 = "FTP012";
    /**
     * 创建短信文件失败
     */
    @ErrorCodeDefinition(description = "创建短信文件失败")
    public static final String MSG001 = "MSG001";
    /**
     * 未授权, 禁止访问
     */
    @ErrorCodeDefinition(description = "禁止访问")
    public static final String SYS000 = "SYS000";
    /**
     * 用户名或者密码错误
     */
    @ErrorCodeDefinition(description = "用户名或者密码错误")
    public static final String SYS001 = "SYS001";
    /**
     * 用户未登陆
     */
    @ErrorCodeDefinition(description = "用户未登陆")
    public static final String SYS002 = "SYS002";
    /**
     * 无法找到相关记录
     */
    @ErrorCodeDefinition(description = "无法找到相关记录")
    public static final String SYS003 = "SYS003";
    /**
     * 新增记录失败
     */
    @ErrorCodeDefinition(description = "新增失败")
    public static final String SYS004 = "SYS004";
    /**
     * 修改记录失败
     */
    @ErrorCodeDefinition(description = "修改失败")
    public static final String SYS005 = "SYS005";
    /**
     * 删除记录失败
     */
    @ErrorCodeDefinition(description = "删除失败")
    public static final String SYS006 = "SYS006";
    /**
     * {0}已存在
     */
    @ErrorCodeDefinition(description = "{0}已存在")
    public static final String SYS007 = "SYS007";
    /**
     * 未知异常
     */
    @ErrorCodeDefinition(description = "未知异常")
    public static final String SYS008 = "SYS008";
    /**
     * 机构不存在或不可用
     */
    @ErrorCodeDefinition(description = "机构不存在或不可用")
    public static final String SYS009 = "SYS009";
    /**
     * 缺少必输字段[{0}]
     */
    @ErrorCodeDefinition(description = "缺少必输字段[{0}]")
    public static final String SYS010 = "SYS010";
    /**
     * 运行任务{0}异常
     */
    @ErrorCodeDefinition(description = "运行任务{0}异常")
    public static final String SYS011 = "SYS011";
    /**
     * 暂停任务{0}异常
     */
    @ErrorCodeDefinition(description = "暂停任务{0}异常")
    public static final String SYS012 = "SYS012";
    /**
     * 继续执行任务{0}异常
     */
    @ErrorCodeDefinition(description = "继续执行任务{0}异常")
    public static final String SYS013 = "SYS013";
    /**
     * 任务{0}运行中
     */
    @ErrorCodeDefinition(description = "任务{0}运行中")
    public static final String SYS014 = "SYS014";
    /**
     * 任务{0}未运行
     */
    @ErrorCodeDefinition(description = "任务{0}未运行")
    public static final String SYS015 = "SYS015";
    /**
     * 任务{0}暂停中
     */
    @ErrorCodeDefinition(description = "任务{0}暂停中")
    public static final String SYS016 = "SYS016";
    /**
     * 任务{0}未暂停
     */
    @ErrorCodeDefinition(description = "任务{0}未暂停")
    public static final String SYS017 = "SYS017";
    /**
     * 删除任务{0}异常
     */
    @ErrorCodeDefinition(description = "删除任务{0}异常")
    public static final String SYS018 = "SYS018";
    /**
     * 添加任务{0}异常
     */
    @ErrorCodeDefinition(description = "添加任务{0}异常")
    public static final String SYS019 = "SYS019";
    /**
     * 停止任务{0}异常
     */
    @ErrorCodeDefinition(description = "停止任务{0}异常")
    public static final String SYS020 = "SYS020";
    /**
     * 任务{0}已禁用
     */
    @ErrorCodeDefinition(description = "任务{0}已禁用")
    public static final String SYS021 = "SYS021";
    /**
     * 任务{0}已启用
     */
    @ErrorCodeDefinition(description = "任务{0}已启用")
    public static final String SYS022 = "SYS022";
    /**
     * 字段{0}的值无法识别
     */
    @ErrorCodeDefinition(description = "字段{0}的值无法识别")
    public static final String SYS023 = "SYS023";
}
