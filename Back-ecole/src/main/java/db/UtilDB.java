package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilDB {
    private String port = "5432";
    private String db;
    private String user;
    private String pwd;

    public String getPort() { return port; }
    public void setPort(String port) { this.port = port; }
    public String getDb() { return db; }
    public void setDb(String db) { this.db = db; }
    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }
    public String getPwd() { return pwd; }
    public void setPwd(String pwd) { this.pwd = pwd; }

    public Connection getCon() throws SQLException {
        String jdbcUrl = "jdbc:postgresql://localhost:" + port + "/" + db;
        return DriverManager.getConnection(jdbcUrl, user, pwd);
    }
}
