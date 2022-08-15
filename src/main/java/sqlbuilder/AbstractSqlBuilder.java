package sqlbuilder;

import java.util.List;

public abstract class AbstractSqlBuilder {

    protected void appendList(StringBuilder sql, List<?> list, String init, String seq) {
        boolean first = true;

        for (Object obj : list) {
            if (first) {
                sql.append(init);
            } else {
                sql.append(seq);
            }

            sql.append(obj);
            first = false;
        }
    }
}
