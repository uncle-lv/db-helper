package sqlbuilder;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DeleteBuilder extends AbstractSqlBuilder {

    private String table;

    private List<String> wheres = new ArrayList<>();

    public DeleteBuilder(String table) {
        this.table = table;
    }

    public DeleteBuilder where(String condition) {
        wheres.add(condition);
        return this;
    }

    public String build() {
        StringBuilder sql = new StringBuilder("DELETE FROM ")
                .append(table);

        appendList(sql, wheres, " WHERE ", " AND ");
        if (0 == wheres.size()) {
            log.warn("DELETE without WHERE");
        }
        return sql.toString();
    }

    @Override
    public String toString() {
        return this.build();
    }
}
