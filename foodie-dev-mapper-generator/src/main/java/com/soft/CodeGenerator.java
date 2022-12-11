package com.soft;


/**
 * @Author: Mengyuan Guo
 * @Description: mybatis-plus代码生成
 * @Date: 2021/10/19 18:06
 */
public class CodeGenerator {
    public static void main(String[] args) {
        /*数据库配置*/
        /*DataSourceConfig dataSourceConfig = new DataSourceConfig.
                Builder("jdbc:mysql://127.0.0.1:3306/foodie_shop_dev", "root", "root").build();
        AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfig);

        *//*全局配置*//*
        //工程根目录
        String projectPath = System.getProperty("user.dir");
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .fileOverride()
                .outputDir(projectPath + "\\foodie-dev-mapper-generator\\src\\main\\java")
                .author("Mengyuan Guo")
                .enableSwagger()
                .dateType(DateType.TIME_PACK)
                .commentDate("yyyy-MM-dd")
                .build();
        autoGenerator.global(globalConfig);

        //包配置
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent("com.soft")
                .entity("pojo")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("mapper")
                .controller("controller")
                .build();
        autoGenerator.packageInfo(packageConfig);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .addInclude(new String[]{"carousel", "category", "items", "items_comments", "items_img", "items_param", "items_spec", "order_items", "order_status", "orders", "stu", "user_address", "users"})
                .addTablePrefix("t_", "c_")
                .addFieldSuffix("_dev")
                .build()
                .entityBuilder()
                .enableLombok()
                .columnNaming(NamingStrategy.underline_to_camel)
                .naming(NamingStrategy.underline_to_camel)
                .build()
                .controllerBuilder()
                .enableRestStyle()
                .build()
                .mapperBuilder()
                .enableMapperAnnotation()
                .build();
        autoGenerator.strategy(strategyConfig);

        autoGenerator.execute();*/
    }
}
