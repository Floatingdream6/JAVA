import MySQLCon.MySQLConnection;
import Util.ShopInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        Statement st = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "update shopinfo set Number=Number-? where Name =?";
            con = MySQLConnection.getConn();
            ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setString(2, "x1");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MySQLConnection.closeAll(con, st, rs);
        }
    }
}