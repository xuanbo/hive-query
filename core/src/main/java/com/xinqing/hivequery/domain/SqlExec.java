package com.xinqing.hivequery.domain;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * SQL exec
 *
 * @author 奔波儿灞
 * @since 1.0
 */
public class SqlExec implements Serializable {

    /**
     * 类型，query、update、exec
     */
    @NotBlank
    private String type;

    /**
     * SQL
     */
    @NotBlank
    private String sql;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
