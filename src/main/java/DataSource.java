import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
    private final HikariDataSource dataSource;
    private final String dbName;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getDriverClassName() {
        return dataSource.getDriverClassName();
    }

    public String getJdbcUrl() {
        return dataSource.getJdbcUrl();
    }

    public String getUsername() {
        return dataSource.getUsername();
    }

    public String getPassword() {
        return dataSource.getPassword();
    }

    private DataSource(Builder builder) {
        this.dataSource = new HikariDataSource();
        this.dataSource.setJdbcUrl(builder.jdbcUrl);
        this.dataSource.setUsername(builder.username);
        this.dataSource.setPassword(builder.password);

        if (!builder.autoCommit) {
            this.dataSource.setAutoCommit(false);
        }

        if (builder.connectionTimeout > 0L) {
            this.dataSource.setConnectionTimeout(builder.connectionTimeout);
        }

        String[] arr = builder.jdbcUrl.split(":", 3);
        this.dbName = arr[1];
    }

    public static class Builder {
        private final String jdbcUrl;
        private final String username;
        private final String password;
        private boolean autoCommit;
        private long connectionTimeout;

        public Builder(String jdbcUrl, String username, String password) {
            this.jdbcUrl = jdbcUrl;
            this.username = username;
            this.password = password;
        }

        public Builder autoCommit(boolean autoCommit) {
            this.autoCommit = autoCommit;
            return this;
        }

        public Builder connectionTimeout(long connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
            return this;
        }

        public DataSource build() {
            return new DataSource(this);
        }
    }
}
