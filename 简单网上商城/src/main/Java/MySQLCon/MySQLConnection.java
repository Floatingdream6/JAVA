package MySQLCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnection {
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/shopdemo?useUnicode=true&characterEncoding=utf-8";
    private static final String uid="root";
    private static final String pwd="hjz19980822@";

    public static Connection getConn(){
        Connection conn=null;
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,uid,pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeAll(java.sql.Connection conn, Statement stmt, ResultSet rs){
        try {
            if(rs!=null){
                rs.close();
                rs=null;
            }
            if(stmt!=null){
                stmt.close();
                stmt=null;
            }
            if(conn!=null){
                conn.close();
                conn=null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
