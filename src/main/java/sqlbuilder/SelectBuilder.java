package sqlbuilder;

import java.util.ArrayList;
import java.util.List;

public class SelectBuilder extends AbstractSqlBuilder {

    private boolean distinct;

    private List<Object> columns = new ArrayList<Object>();

    private List<String> tables = new ArrayList<String>();

    private List<String> wheres = new ArrayList<String>();

    public SelectBuilder(String table) {
        this.tables.add(table);
    }

    public SelectBuilder where(String condition) {
        this.wheres.add(condition);
        return this;
    }

    public SelectBuilder and(String condition) {
        return this.where(condition);
    }

    public SelectBuilder column(String name) {
        this.columns.add(name);
        return this;
    }

    public SelectBuilder distinct() {
        this.distinct = true;
        return this;
    }

    public String build() {
        StringBuilder sql = new StringBuilder("SELECT ");

        if (distinct) {
            sql.append("DISTINCT ");
        }

        if (0 == columns.size()) {
            sql.append("*");
        } else {
            appendList(sql, columns, "", ", ");
        }

        appendList(sql, tables, " FROM ", ", ");
        appendList(sql, wheres, " WHERE ", " AND ");
        return sql.toString();
    }

    @Override
    public String toString() {
        return this.build();
    }
}
