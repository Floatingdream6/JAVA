package DBCP;

import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class DOCPTest {
    public static void main(String[] args) throws SQLException {

        DataSource ds = new DBCPDemo().getDataSource();
        Connection conn = ds.getConnection();
       /* Connection conn = ds.getConnection();
        //5.获取数据库连接信息
        DatabaseMetaData metaData = conn.getMetaData();
        //6.打印数据库连接信息
        System.out.println(metaData.getURL()+"\n"
                +"UserName="+metaData.getUserName()+"\n"
                +metaData.getDriverName());
         Connection con = ds.getConnection();
        con.setAutoCommit(false);
        if (con != null) {
            System.out.println("获取连接成功！");
        } else {
            System.out.println("获取连接失败！");
        }*/
        QueryRunner qr = new QueryRunner(ds);
        //ShopInfo shopInfo = qr.query("select * from shopinfo where Name=?", new BeanHandler<>(ShopInfo.class),"x4");
        List<ShopInfo> list =  qr.query("select * from shopinfo", new BeanListHandler<>(ShopInfo.class));
        for(ShopInfo shopInfo : list){
            System.out.println(shopInfo);
        }
        
    }
}
