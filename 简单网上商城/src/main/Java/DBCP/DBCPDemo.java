package DBCP;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPDemo {

    private static DataSource dataSource;

    static {
        try {
            InputStream in = DBCPDemo.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            Properties props = new Properties();
            props.load(in);
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    protected static void shutdownDataSource() throws SQLException {
        BasicDataSource bds = (BasicDataSource) dataSource;
        bds.close();
    }
}
