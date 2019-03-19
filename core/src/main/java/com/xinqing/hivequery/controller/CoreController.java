package com.xinqing.hivequery.controller;

import com.xinqing.hivequery.domain.Api;
import com.xinqing.hivequery.domain.SqlExec;
import com.xinqing.hivequery.repository.CoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 核心Controller
 *
 * @author 奔波儿灞
 * @since 1.0
 */
@RestController
@RequestMapping("/api/core")
@Validated
public class CoreController {

    private final CoreRepository coreRepository;

    @Autowired
    public CoreController(CoreRepository coreRepository) {
        this.coreRepository = coreRepository;
    }

    /**
     * 获取数据库
     *
     * @return 数据库信息
     */
    @GetMapping("/showDatabases")
    public Api<?> showDatabases() {
        return Api.ok(coreRepository.showDatabases());
    }

    /**
     * 获取数据库表
     *
     * @param database 数据库
     * @return 数据库表
     */
    @GetMapping("/showTables")
    public Api<?> showTables(@RequestParam String database) {
        return Api.ok(coreRepository.showTables(database));
    }

    /**
     * 获取数据库表结构
     *
     * @param database  数据库
     * @param tableName 表名
     * @return 表结构
     */
    @GetMapping("/descTable")
    public Api<?> descTable(@RequestParam String database, @RequestParam String tableName) {
        return Api.ok(coreRepository.descTable(database, tableName));
    }

    /**
     * 执行SQL
     *
     * @param sqlExec SqlExec
     * @return 执行结果
     */
    @PostMapping("/sqlExec")
    public Api<?> sqlExec(@Validated @RequestBody SqlExec sqlExec) {
        String sql = sqlExec.getSql();
        List<Map<String, Object>> result;
        switch (sqlExec.getType()) {
            case "query":
                result = coreRepository.query(sql);
                break;
            case "update":
                result = coreRepository.update(sql);
                break;
            case "exec":
                result = coreRepository.exec(sql);
                break;
            default:
                result = Collections.emptyList();

        }
        return Api.ok(result);
    }

}
