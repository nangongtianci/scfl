package com.scfl.dispatching.center.config.mybatis;

import com.scfl.dispatching.center.config.druid.DruidProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;

/**
 * MybatisPlus配置
 * @author ylw
 * @date 18-3-14 下午3:54
 * @param
 * @return
 */
@Configuration
@MapperScan(basePackages={"com.scfl.dispatching.center.mapper*"})
public class MybatisPlusConfig {

    @Autowired
    DruidProperties druidProperties;

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
    	 PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
         paginationInterceptor.setDialectType(DBType.MYSQL.getDb());
         return paginationInterceptor;
    }

    /**
     * druid数据库连接池
     */
    @Bean(initMethod = "init", destroyMethod="close")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }
}
