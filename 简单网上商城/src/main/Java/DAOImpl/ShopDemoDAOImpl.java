package DAOImpl;

import DAO.ShopDemoDAO;
import MySQLCon.MySQLConnection;
import Util.Address;
import Util.ShopInfo;
import Util.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class ShopDemoDAOImpl implements ShopDemoDAO {

    @Override
    public ArrayList<ShopInfo> SerchAll() {
        Statement st=null;
        Connection con=null;
        ResultSet rs=null;
        ShopInfo shopinfo=null;
        ArrayList<ShopInfo> list = new ArrayList<>();
        try {
            String sql="select * from shopinfo";
            con= MySQLConnection.getConn();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                shopinfo =new ShopInfo();
                shopinfo.setShopname(rs.getString("Name"));
                shopinfo.setShopprice(rs.getDouble("Price"));
                shopinfo.setShopnumber(rs.getInt("Number"));
                shopinfo.setShoparea(rs.getString("Area"));
                list.add(shopinfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            MySQLConnection.closeAll(con, st, rs);
        }
        return list;
    }

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
                user.setPetname(rs.getString("UserName"));
                user.setIdentity(rs.getInt("Identity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            MySQLConnection.closeAll(con, st, rs);
        }
        return user;
    }

    @Override
    public ShopInfo SerachShop(String shopname) {

        Statement st=null;
        Connection con=null;
        ResultSet rs=null;
        ShopInfo shop = null;
        try {
            String sql="select * from shopinfo where Name='"+shopname+"'";
            con= MySQLConnection.getConn();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next()){
                shop=new ShopInfo();
                shop.setShopname(rs.getString("Name"));
                shop.setShopprice(rs.getDouble("Price"));
                shop.setShopnumber(rs.getInt("Number"));
                shop.setShoparea(rs.getString("Area"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            MySQLConnection.closeAll(con, st, rs);
        }
        return shop;
    }

    @Override
    public void AddAccountsInfo(ShopInfo shopinfo,String owner) {
        Statement st=null;
        Connection con=null;
        ResultSet rs=null;
        try {
            String sql="insert into shophistory values('"+shopinfo.getShopname()+"','"+shopinfo.getShopnumber()+"','"+shopinfo.getShopprice()+"','"+new Timestamp(new Date().getTime()) +"','"+owner+"')";
            con= MySQLConnection.getConn();
            st=con.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            MySQLConnection.closeAll(con, st, rs);
        }
    }

    @Override
    public ArrayList<Address> SerchAddress() {
        Statement st=null;
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
        }
        return list;
    }

    @Override
    public void AddAddress(Address ads) {
        Statement st=null;
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        try {
            String sql="insert into address (name, telephone, address,ziocode,Acquiesce,owner) value (?,?,?,?,?,?)";
            con= MySQLConnection.getConn();
            ps = con.prepareStatement(sql);
            ps.setString(1,ads.getName());
            ps.setInt(2,ads.getTelephone());
            ps.setString(3,ads.getAddress());
            ps.setInt(4,ads.getZiocode());
            ps.setString(5,"否");
            ps.setString(6,ads.getOwner());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            MySQLConnection.closeAll(con, st, rs);
        }
    }

    @Override
    public Address SearchAddress(String name) {
        Statement st=null;
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        Address address = null;
        try {
            String sql="select * from address where Name=?";
            con= MySQLConnection.getConn();
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            if(rs.next()){
                address = new Address();
                address.setName(rs.getString("Name"));
                address.setTelephone(rs.getInt("Telephone"));
                address.setAddress(rs.getString("Address"));
                address.setOwner(rs.getString("Owner"));
                address.setAcquiesce(rs.getString("Acquiesce"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            MySQLConnection.closeAll(con, st, rs);
        }
        return address;
    }

    @Override
    public void AddShopCar(ShopInfo shopinfo,String owner) {
        Statement st=null;
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        try {
            String sql="insert into shopcar value (?,?,?,?)";
            con= MySQLConnection.getConn();
            ps = con.prepareStatement(sql);
            ps.setString(1,shopinfo.getShopname());
            ps.setInt(2,1);
            ps.setDouble(3,shopinfo.getShopprice());
            ps.setString(4,owner);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            MySQLConnection.closeAll(con, st, rs);
        }
    }

    @Override
    public ArrayList<ShopInfo> SerachShopCar(String owner) {
        Statement st=null;
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        ShopInfo shopinfo = null;
        ArrayList<ShopInfo> list =new ArrayList<>();
        try {
            String sql="select * from shopcar where Owner=?";
            con= MySQLConnection.getConn();
            ps = con.prepareStatement(sql);
            ps.setString(1,owner);
            rs = ps.executeQuery();
            while(rs.next()){
                shopinfo = new ShopInfo();
                shopinfo.setShopname(rs.getString("Name"));
                shopinfo.setShopnumber(rs.getInt("Number"));
                shopinfo.setShopprice(rs.getDouble("Price"));
                list.add(shopinfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            MySQLConnection.closeAll(con,st, rs);
        }
        return list;
    }

    @Override
    public int AddUser(User user) {
        Statement st=null;
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        int n=0;
        try {
            String sql="insert into personinfo value (?,?,?,?)";
            con= MySQLConnection.getConn();
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getPetname());
            ps.setString(2,user.getUsername());
            ps.setString(3,user.getPassword());
            ps.setInt(4,user.getIdentity());
            n = ps.executeUpdate();
        } catch (Exception e) {
        }finally{
            MySQLConnection.closeAll(con,st, rs);
        }
        if(n>0)
            return 1;
        else
            return -1;
    }

    @Override
    public ArrayList<ShopInfo> SearchShopinfo(String message) {
        ArrayList<ShopInfo> list = new ArrayList<>();
        Statement st=null;
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        ShopInfo shopinfo = null;
        try {
            String sql = "select * from shopinfo where Name like \"%\"?\"%\"";
            con= MySQLConnection.getConn();
            ps = con.prepareStatement(sql);
            ps.setString(1,message);
            rs = ps.executeQuery();
            while(rs.next()){
                shopinfo = new ShopInfo();
                shopinfo.setShopname(rs.getString("Name"));
                shopinfo.setShopprice(rs.getDouble("Price"));
                shopinfo.setShopnumber(rs.getInt("Number"));
                shopinfo.setShoparea(rs.getString("Area"));
                list.add(shopinfo);
            }
        } catch (Exception e) {
        }finally {
            MySQLConnection.closeAll(con, st, rs);
        }
        return list;
    }

    @Override
    public void CutShopInfoNumber(String shopname,int number) {
        Statement st=null;
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        try {
            String sql = "update shopinfo set Number=Number-? where Name =?";
            con= MySQLConnection.getConn();
            ps = con.prepareStatement(sql);
            ps.setInt(1,number);
            ps.setString(2,shopname);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.closeAll(con, st, rs);
        }
    }

    @Override
    public void DeleteShopCar(String shopname,String owner) {
        Statement st=null;
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        try {
            String sql ="delete from shopcar where Name=? and Owner=?";
            con= MySQLConnection.getConn();
            ps = con.prepareStatement(sql);
            ps.setString(1,shopname);
            ps.setString(2,owner);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.closeAll(con, st, rs);
        }
    }


    @Override
    public int SearchShopcar(String shopname,String owner) {
        Statement st=null;
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        int flag=0;
        try {
            String sql ="select * from shopcar where Name=? and Owner=?";
            con= MySQLConnection.getConn();
            ps = con.prepareStatement(sql);
            ps.setString(1,shopname);
            ps.setString(2,owner);
            rs = ps.executeQuery();
            if(rs.next()){
                flag = 1;
            }else{
                flag = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.closeAll(con, st, rs);
            return flag;
        }
    }

    @Override
    public void UpdateShopCar(String shopname, String owner) {
        Statement st=null;
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        try {
            String sql ="update shopcar set Number=Number+1 where Name=? and Owner=?";
            con= MySQLConnection.getConn();
            ps = con.prepareStatement(sql);
            ps.setString(1,shopname);
            ps.setString(2,owner);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.closeAll(con, st, rs);
        }
    }

    @Override
    public void UpdatePageShopCar(String shopname, String owner) {
        Statement st=null;
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        try {
            String sql ="update shopcar set Number=Number-1 where Name=? and Owner=?";
            con= MySQLConnection.getConn();
            ps = con.prepareStatement(sql);
            ps.setString(1,shopname);
            ps.setString(2,owner);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.closeAll(con, st, rs);
        }
    }

    @Override
    public void ShopCarClear(String shopname, String owner) {
        Statement st=null;
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        try {
            String sql ="delete from shopcar where Name=? and Owner=?";
            con= MySQLConnection.getConn();
            ps = con.prepareStatement(sql);
            ps.setString(1,shopname);
            ps.setString(2,owner);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.closeAll(con, st, rs);
        }
    }

    @Override
    public int DeleteShop(String shopname) {
        Statement st=null;
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        int n = 0;
        try {
            String sql ="delete from shopinfo where Name=?";
            con= MySQLConnection.getConn();
            ps = con.prepareStatement(sql);
            ps.setString(1,shopname);
            n=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.closeAll(con, st, rs);
        }
        if(n>0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int AddShop(ShopInfo shop) {
        Statement st=null;
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        int n = 0;
        try {
            String sql ="insert into shopinfo value (?,?,?,?)";
            con= MySQLConnection.getConn();
            ps = con.prepareStatement(sql);
            ps.setString(1,shop.getShopname());
            ps.setDouble(2,shop.getShopprice());
            ps.setInt(3,shop.getShopnumber());
            ps.setString(4,shop.getShoparea());
            n=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.closeAll(con, st, rs);
        }
        if(n>0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int ModifyShopInfo(ShopInfo shop) {
        Statement st=null;
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        int n = 0;
        try {
            String sql ="update shopinfo set Price=?,Number=?,Area=? where Name=?";
            con= MySQLConnection.getConn();
            ps = con.prepareStatement(sql);
            ps.setDouble(1,shop.getShopprice());
            ps.setInt(2,shop.getShopnumber());
            ps.setString(3,shop.getShoparea());
            ps.setString(4,shop.getShopname());
            n=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.closeAll(con, st, rs);
        }
        if(n>0){
            return 1;
        }else{
            return 0;
        }
    }
}
