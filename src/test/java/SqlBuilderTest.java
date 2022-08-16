import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sqlbuilder.InsertBuilder;
import sqlbuilder.SelectBuilder;

public class SqlBuilderTest {

    @Test
    public void testSelectSqlBuilder() {
        SelectBuilder selectBuilder = new SelectBuilder("user")
                .column("username")
                .column("email")
                .where("gender = male")
                .and("age >= 18");

        Assertions.assertEquals("SELECT username, email FROM user WHERE gender = male AND age >= 18", selectBuilder.build());
    }

    @Test
    public void testInsertSqlBuilder() {
        InsertBuilder insertBuilder = new InsertBuilder("user")
                .insert("username", "uncle-lv")
                .insert("email", "uncle.lv@outlook.com");

        Assertions.assertEquals("INSERT INTO user (username, email) VALUES (uncle-lv, uncle.lv@outlook.com)", insertBuilder.build());
    }
}
