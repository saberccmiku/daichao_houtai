package com.daichao.modules;

import com.daichao.common.support.gen.JdbcGenUtils;

/**
 * 代码生成器
 * @author zcl<yczclcn@163.com>
 */
public class Generator {

    public static void main(String[] args) throws Exception {
        String jdbcDriver = "com.mysql.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://rm-bp1q82uzyeeeg8rjs7o.mysql.rds.aliyuncs.com/test_loan_shop?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&useSSL=true";
        String jdbcUsername = "daoliuloan";
        String jdbcPassword = "Vva4QzeMkQMjSTux";

        String tablePrefix = "cust_";

        String javaProject = "dp-admin";
        String javaModule = "generator";
        String webModule = "base";

        JdbcGenUtils.generatorCode(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword, tablePrefix, javaProject, javaModule, webModule);
    }

}
