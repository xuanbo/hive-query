package com.xinqing.hivequery.repository;

import java.util.List;
import java.util.Map;

/**
 * 核心Repository
 *
 * @author 奔波儿灞
 * @since 1.0
 */
public interface CoreRepository {

    /**
     * 获取数据库
     *
     * @return 数据库
     */
    List<Map<String, Object>> showDatabases();

    /**
     * 获取数据库表
     *
     * @param database 数据库
     * @return 数据库表
     */
    List<Map<String, Object>> showTables(String database);

    /**
     * 获取数据库表结构
     *
     * @param database  数据库
     * @param tableName 表名
     * @return 表结构
     */
    List<Map<String, Object>> descTable(String database, String tableName);

    /**
     * 查询
     *
     * @param sql SQL
     * @return 查询结果
     */
    List<Map<String, Object>> query(String sql);

    /**
     * 更新（update、delete、insert）
     *
     * @param sql SQL
     * @return 查询结果
     */
    List<Map<String, Object>> update(String sql);

    /**
     * DML
     *
     * @param sql SQL
     * @return 查询结果
     */
    List<Map<String, Object>> exec(String sql);

}
