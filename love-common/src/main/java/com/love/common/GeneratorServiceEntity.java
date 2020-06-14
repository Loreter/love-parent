package com.love.common;


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
 * @date 2020-06-08
 */
public class GeneratorServiceEntity {
	//"jft_pay_order","jft_pay_order_ext","jft_pay_order_his","jft_pay_items","jft_pay_items_doubt","jft_pay_items_his","jft_pay_refund","jft_pay_refund_his"
//    @Test
    public void generateCode() {
        String packageName = "com.icbc.ndf.jft.pay";
        //user -> UserService, 设置成true: user -> IUserService
        boolean serviceNameStartWithI = false;
        generateByTables(serviceNameStartWithI, packageName,"jft_pay_order","jft_pay_order_his","jft_pay_withdraw_order","jft_pay_withdraw_items","jft_pay_withdraw_record");
    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://122.20.221.59:3306/paydb1902?useUnicode=true&characterEncoding=utf-8";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("payuser_w1902")
                .setPassword("write1902")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(false)
                .setEntityLombokModel(false)
                .setDbColumnUnderline(false)
               // .setSuperEntityClass(Model)
                .setEntityBuilderModel(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setSuperEntityClass("SuperEntity<?>")
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setAuthor("kfzx-biyl")
                .setOutputDir("d:\\entity")
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("entity")
                ).execute();
    }

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }
}