package sqlbuilder;

import java.util.ArrayList;
import java.util.List;

public class InsertBuilder extends AbstractSqlBuilder {

    private String table;

    private List<String> columns = new ArrayList<String>();

    private List<String> values = new ArrayList<String>();

    public InsertBuilder(String table) {
        this.table = table;
    }

    public InsertBuilder insert(String column, String value) {
        columns.add(column);
        values.add(value);
        return this;
    }

    public String build() {
        StringBuilder sql = new StringBuilder("INSERT INTO ")
                .append(table)
                .append(" (");

        appendList(sql, columns, "", ", ");
        sql.append(") VALUES (");
        appendList(sql, values, "", ", ");
        sql.append(")");
        return sql.toString();
    }

    @Override
    public String toString() {
        return this.build();
    }
}
