package com.love.base;

import org.junit.Test;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * <p>
 * 测试生成代码
 * </p>
 *
 * @author K神
 * @date 2017/12/18
 */
public class GeneratorServiceEntity {

    @Test
    public void generateCode() {
        String packageName = "com.love.base";
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
        generateByTables(serviceNameStartWithI, packageName);
    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName) {
        // 全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false)
                .setAuthor("dccb-sunzy")
                .setOutputDir("d:\\codeGen")
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }

        // 数据库配置
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/vendordb?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        String[] arrays = new String[]{"jft_cloud_auth_info"};
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("123456")
                .setDriverName("com.mysql.cj.jdbc.Driver");

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(false)
                .setEntityLombokModel(false)
                .setDbColumnUnderline(false)
                .setEntityBuilderModel(true)
//                .setTablePrefix("JFT_")
                /*.setSuperServiceClass("com.icbc.ndf.common.service.SuperService")
                .setSuperServiceImplClass("com.icbc.ndf.common.service.impl.SuperServiceImpl")
                .setSuperEntityClass("com.icbc.ndf.common.entity.SuperEntity")
                .setSuperMapperClass("com.icbc.ndf.common.mapper.SuperMapper")
                .setSuperControllerClass("com.icbc.ndf.jft.vendor.controller.JftBaseController")*/
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(arrays);//修改替换成你需要的表名，多个表名传数组

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(packageName)
                .setService("service")
                .setServiceImpl("serviceImpl")
//                                .setController("controller")
                .setEntity("entity");


        // 代码生成器
        AutoGenerator generator = new AutoGenerator();
        generator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .execute();
    }

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName);
    }
}