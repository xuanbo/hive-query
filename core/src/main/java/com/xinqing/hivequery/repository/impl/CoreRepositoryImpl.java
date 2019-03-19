package com.xinqing.hivequery.repository.impl;

import com.xinqing.hivequery.repository.CoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 核心Repository实现
 *
 * @author 奔波儿灞
 * @since 1.0
 */
@Repository
public class CoreRepositoryImpl implements CoreRepository {

    private static final String SQL_SHOW_DATABASES = "show databases";

    private static final String SQL_USE_DATABASES_FMT = "use %s";

    private static final String SQL_SHOW_TABLES = "show tables";

    private static final String SQL_DESC_TABLE_FMT = "desc %s";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CoreRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> showDatabases() {
        return jdbcTemplate.queryForList(SQL_SHOW_DATABASES);
    }

    @Override
    public List<Map<String, Object>> showTables(String database) {
        jdbcTemplate.execute(String.format(SQL_USE_DATABASES_FMT, database));
        return jdbcTemplate.queryForList(SQL_SHOW_TABLES);
    }

    @Override
    public List<Map<String, Object>> descTable(String database, String tableName) {
        jdbcTemplate.execute(String.format(SQL_USE_DATABASES_FMT, database));
        return jdbcTemplate.queryForList(String.format(SQL_DESC_TABLE_FMT, tableName));
    }

    @Override
    public List<Map<String, Object>> query(String sql) {
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<Map<String, Object>> update(String sql) {
        int record = jdbcTemplate.update(sql);
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> map = new HashMap<>(1);
        map.put("record", record);
        result.add(map);
        return result;
    }

    @Override
    public List<Map<String, Object>> exec(String sql) {
        jdbcTemplate.execute(sql);
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> map = new HashMap<>(1);
        map.put("result", "ok");
        result.add(map);
        return result;
    }

}
