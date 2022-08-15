import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
}
