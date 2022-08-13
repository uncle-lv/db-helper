import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class DataSourceTest {

    @Test
    public void testBuilder() throws SQLException {
        DataSource dataSource = new DataSource.Builder("", "", "")
                .build();

        Assertions.assertNotNull(dataSource.getConnection());
        Assertions.assertEquals("oracle", dataSource.getDbName());
    }
}
