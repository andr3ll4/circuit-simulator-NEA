
package Database;

import java.sql.*;

public class SQLServerConnection {
    public static void Connect(){
        String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
        String url = "jdbc:sqlserver://DREEA;Database=Circuit Simulator;IntegratedSecurity=true";
        try {
            Class.forName(driverClass);
            Connection con = DriverManager.getConnection(url);
            System.out.println("Connected");
        }catch(ClassNotFoundException | SQLException e){
            System.out.print("Error");
            e.printStackTrace();
        }
    }
    public void insert(String insert, String values, Connection con) throws SQLException{ //takes insert
        Statement stm = con.createStatement();
        String sql = "insert into " + insert + " values("+ values+")";
        int x = stm.executeUpdate(sql);
    }
    public void update(String update, String set, String where, Connection con) throws SQLException{ //takes insert
        Statement stm = con.createStatement();
        String sql = "update " + update + " set " + set + " where " + where;
        int x = stm.executeUpdate(sql);
    }
    public void delete(String delete, String from, String where, Connection con) throws SQLException{ //takes insert
        Statement stm = con.createStatement();
        String sql = "delete " + delete + " from " + from + " where " + where;
        int x = stm.executeUpdate(sql);
    }
    public ResultSet select(String select, String from, String where, Connection con) throws SQLException{
        Statement stm = con.createStatement();
        String sql = "select " + select + " from " + from + " where " + where;
        return stm.executeQuery(sql);
    }
   
}
