package sqlbuilder;

import java.util.ArrayList;
import java.util.List;

public class SelectBuilder extends AbstractSqlBuilder {

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

    public String build() {
        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder sql = new StringBuilder("SELECT ");
        if (0 == columns.size()) {
            sql.append("*");
        } else {
            appendList(sql, columns, "", ", ");
        }

        appendList(sql, tables, " FROM ", ", ");
        appendList(sql, wheres, " WHERE ", " AND ");

        return sql.toString();
    }
}
