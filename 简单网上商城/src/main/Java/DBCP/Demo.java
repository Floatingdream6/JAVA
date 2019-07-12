package DBCP;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Demo {
    public static void main(String[] args) throws SQLException {
        DataSource ds = new DBCPDemo().getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        List<Map> list = (List) qr.query("select * from shopinfo", new MapListHandler());
        for(Map<String,Object> map :list){
            for(Map.Entry<String, Object> me : map.entrySet())
            {
                System.out.println(me.getKey() + "=" + me.getValue());
            }
        }
}
}