package sqlbuilder;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UpdateBuilder extends AbstractSqlBuilder {

    private String table;

    private List<String> sets = new ArrayList<String>();

    private List<String> wheres = new ArrayList<String>();

    public UpdateBuilder(String table) {
        this.table = table;
    }

    public UpdateBuilder set(String expr) {
        this.sets.add(expr);
        return this;
    }

    public UpdateBuilder where(String condition) {
        wheres.add(condition);
        return this;
    }

    public String build() {
        StringBuilder sql = new StringBuilder("UPDATE ")
                .append(table);
        appendList(sql, sets, " SET ", ", ");
        appendList(sql, wheres, " WHERE ", " AND ");
        if (0 == wheres.size()) {
            log.warn("UPDATE without WHERE");
        }
        return sql.toString();
    }

    @Override
    public String toString() {
        return this.build();
    }
}
