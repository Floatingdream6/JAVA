import MySQLCon.MySQLConnection;
import Servlet.AddUserServlet;
import Util.Address;
import Util.ShopInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        /*Statement st=null;
        Connection con=null;
        ResultSet rs=null;
        Address address=null;
        ArrayList<Address> list = new ArrayList<>();
        try {
            String sql="select * from address";
            con= MySQLConnection.getConn();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                address = new Address();
                address.setName(rs.getString("Name"));
                address.setTelephone(rs.getInt("Telephone"));
                address.setAddress(rs.getString("Address"));
                address.setZiocode(rs.getInt("ZioCode"));
                address.setAcquiesce(rs.getString("Acquiesce"));
                address.setOwner(rs.getString("Owner"));
                list.add(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            MySQLConnection.closeAll(con, st, rs);
            for(Address ads :list){
                System.out.println(ads.getName()+ads.getAcquiesce());
            }
        }*/
        int[] a = {32,13,49,24,38,21,4,12};
        for(int i=0;i<a.length;i++){
            System.out.print(3*a[i]%11+"\t");
        }

    }
}