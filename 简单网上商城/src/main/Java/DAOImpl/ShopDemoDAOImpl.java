package DAOImpl;

import DAO.ShopDemoDAO;
import MySQLCon.MySQLConnection;
import Util.User;
import com.sun.xml.internal.bind.v2.model.core.ClassInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShopDemoDAOImpl implements ShopDemoDAO {

    @Override
    public User SearchByName(String username) {

        Statement st=null;
        Connection con=null;
        ResultSet rs=null;
        User user=null;
        try {
            String sql="select * from personinfo where Name='"+username+"'";
            con= MySQLConnection.getConn();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next()){
                user=new User();
                user.setUsername(username);
                user.setPassword(rs.getString("PassWord"));
        }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            MySQLConnection.closeAll(con, st, rs);
        }
        return user;
    }
}
