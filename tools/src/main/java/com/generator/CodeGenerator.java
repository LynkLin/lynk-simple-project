package com.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lynk
 * @since 2019/04/11
 */
public class CodeGenerator {

    private static final String PROJECT_PATH = System.getProperty("user.dir");

    public void generatorCode(String moduleName, String tablePrefix, String... includeTable) {
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(initGlobalConfig());
        mpg.setDataSource(initDataSourceConfig());

        PackageConfig packageConfig = initPackageConfig(moduleName);
        mpg.setPackageInfo(packageConfig);

        mpg.setCfg(initInjectionConfig(packageConfig));

        mpg.setTemplate(initTemplateConfig());

        mpg.setStrategy(initStrategyConfig(packageConfig, tablePrefix, includeTable));
        mpg.execute();
    }

    /**
     * 全局配置
     * @return
     */
    private GlobalConfig initGlobalConfig() {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(PROJECT_PATH + "/tools/src/main/java");
        gc.setAuthor("Lynk");
        gc.setOpen(false);
        gc.setSwagger2(true);
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);
        gc.setDateType(DateType.TIME_PACK);
        gc.setMapperName("%sDao");
        gc.setXmlName("%sDao");
        return gc;
    }

    /**
     * 数据源配置
     * @return
     */
    private DataSourceConfig initDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://192.168.79.128:4000/lynk_sys?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("");
        return dsc;
    }

    /**
     * 包配置
     * @return
     */
    private PackageConfig initPackageConfig(String moduleName) {
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent("com.lynk");
        pc.setMapper("dao");
        pc.setController("controller");
        return pc;
    }

    /**
     * 自定义配置
     * @param packageConfig
     * @return
     */
    private InjectionConfig initInjectionConfig(PackageConfig packageConfig) {
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return PROJECT_PATH + "/tools/src/main/resources/daoMapper/" + packageConfig.getModuleName().replace(".", "/")
                        + "/" + tableInfo.getEntityName() + "Dao" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    /**
     * 配置模板
     * @return
     */
    private TemplateConfig initTemplateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        return templateConfig;
    }

    /**
     * 策略配置
     * @param packageConfig
     * @return
     */
    private StrategyConfig initStrategyConfig(PackageConfig packageConfig, String tablePrefix, String... includeTable) {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.lynk.system.entity.base.SystemBaseEntity");
        strategy.setEntityColumnConstant(true);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
//        strategy.setSuperControllerClass("com.lynk.system.controller.base.SystemBaseController");
        strategy.setInclude(includeTable);
        strategy.setSuperEntityColumns("ID", "GMT_CREATE", "GMT_MODIFIED");
//        strategy.setTableFillList(tableFillList);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        strategy.setTablePrefix(tablePrefix + "_");
        return strategy;
    }
}
