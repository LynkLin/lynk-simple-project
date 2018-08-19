package com.lynk.system.mybatis;

import com.baomidou.mybatisplus.entity.TableFieldInfo;
import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.SqlMethod;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.baomidou.mybatisplus.toolkit.TableInfoHelper;
import com.lynk.system.common.DateUtil;
import org.apache.ibatis.executor.keygen.Jdbc3KeyGenerator;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.SqlSource;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Lynk
 * @since 2017/11/21
 */
@Deprecated
public class SystemLogicSqlInjector extends LogicSqlInjector {
    @Override
    protected void injectInsertOneSql(boolean selective, Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
        if (table.isLogicDelete()) {
            //自动设置逻辑删除字段
            /*
             * INSERT INTO table <trim prefix="(" suffix=")" suffixOverrides=",">
             * <if test="xx != null">xx,</if> </trim> <trim prefix="values ("
             * suffix=")" suffixOverrides=","> <if test="xx != null">#{xx},</if>
             * </trim>
             */
            KeyGenerator keyGenerator = new NoKeyGenerator();
            StringBuilder fieldBuilder = new StringBuilder();
            StringBuilder placeholderBuilder = new StringBuilder();
            SqlMethod sqlMethod = selective ? SqlMethod.INSERT_ONE : SqlMethod.INSERT_ONE_ALL_COLUMN;

            fieldBuilder.append("\n<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n");
            placeholderBuilder.append("\n<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n");
            String keyProperty = null;
            String keyColumn = null;

            // 表包含主键处理逻辑,如果不包含主键当普通字段处理
            if (StringUtils.isNotEmpty(table.getKeyProperty())) {
                if (table.getIdType() == IdType.AUTO) {
                /* 自增主键 */
                    keyGenerator = new Jdbc3KeyGenerator();
                    keyProperty = table.getKeyProperty();
                    keyColumn = table.getKeyColumn();
                } else {
                    if (null != table.getKeySequence()) {
                        keyGenerator = TableInfoHelper.genKeyGenerator(table, builderAssistant, sqlMethod.getMethod(), languageDriver);
                        keyProperty = table.getKeyProperty();
                        keyColumn = table.getKeyColumn();
                        fieldBuilder.append(table.getKeyColumn()).append(",");
                        placeholderBuilder.append("#{").append(table.getKeyProperty()).append("},");
                    } else {
                    /* 用户输入自定义ID */
                        fieldBuilder.append(table.getKeyColumn()).append(",");
                        // 正常自定义主键策略
                        placeholderBuilder.append("#{").append(table.getKeyProperty()).append("},");
                    }
                }
            }

            // 是否 IF 标签判断
            boolean ifTag;
            List<TableFieldInfo> fieldList = table.getFieldList();
            for (TableFieldInfo fieldInfo : fieldList) {
                // 在FieldIgnore,INSERT_UPDATE,INSERT 时设置为false
                ifTag = !(FieldFill.INSERT == fieldInfo.getFieldFill()
                        || FieldFill.INSERT_UPDATE == fieldInfo.getFieldFill()
                        || fieldInfo.isLogicDelete());
                if (selective && ifTag) {
                    fieldBuilder.append(convertIfTagIgnored(fieldInfo, false));
                    fieldBuilder.append(fieldInfo.getColumn()).append(",");
                    fieldBuilder.append(convertIfTagIgnored(fieldInfo, true));
                    placeholderBuilder.append(convertIfTagIgnored(fieldInfo, false));
                    placeholderBuilder.append("#{").append(fieldInfo.getEl()).append("},");
                    placeholderBuilder.append(convertIfTagIgnored(fieldInfo, true));
                } else {
                    fieldBuilder.append(fieldInfo.getColumn()).append(",");
                    if (fieldInfo.isLogicDelete()) {
                        if (StringUtils.isCharSequence(fieldInfo.getPropertyType())) {
                            placeholderBuilder.append("'").append(fieldInfo.getLogicNotDeleteValue()).append("',");
                        } else {
                            placeholderBuilder.append(fieldInfo.getLogicNotDeleteValue()).append(",");
                        }
                    } else {
                        placeholderBuilder.append("#{").append(fieldInfo.getEl()).append("},");
                    }
                }
            }
            fieldBuilder.append("\n</trim>");
            placeholderBuilder.append("\n</trim>");
            String sql = String.format(sqlMethod.getSql(), table.getTableName(), fieldBuilder.toString(),
                    placeholderBuilder.toString());
            SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
            this.addInsertMappedStatement(mapperClass, modelClass, sqlMethod.getMethod(), sqlSource, keyGenerator, keyProperty,
                    keyColumn);
        } else {
            //正常插入
            super.injectInsertOneSql(selective, mapperClass, modelClass, table);
        }
    }

    @Override
    protected String sqlLogicSet(TableInfo table) {
        List<TableFieldInfo> fieldList = table.getFieldList();
        StringBuilder set = new StringBuilder("SET ");
        int i = 0;
        for (TableFieldInfo fieldInfo : fieldList) {
            if (fieldInfo.isLogicDelete()) {
                if (++i > 1) {
                    set.append(",");
                }
                set.append(fieldInfo.getColumn()).append("=");
                if (StringUtils.isCharSequence(fieldInfo.getPropertyType())) {
                    set.append("'").append(fieldInfo.getLogicDeleteValue()).append("'");
                } else {
                    set.append(fieldInfo.getLogicDeleteValue());
                }
            }
            //逻辑删除时应增加自动填充字段更新, 暂时只能处理日期。其他待命
            if (FieldFill.UPDATE == fieldInfo.getFieldFill() || FieldFill.INSERT_UPDATE == fieldInfo.getFieldFill()) {
                if (!LocalDateTime.class.isAssignableFrom(fieldInfo.getPropertyType())) {
                    continue;
                }
                if (++i > 1) {
                    set.append(",");
                }
                String dateTime = DateUtil.getCurrentDateTime19();
                set.append(fieldInfo.getColumn()).append("='").append(dateTime).append("'");
            }
        }
        return set.toString();
    }
}
