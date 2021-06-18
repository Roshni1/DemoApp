package main.repository;

import main.model.Rest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {

    static Connection con = Database.getConnection();

    public int add(Rest rst) throws SQLException
    {

        String query
                = "insert into resttable(id, " + "name, " + " description) VALUES (?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, rst.getId());
        ps.setString(2, rst.getName());
        ps.setString(3, rst.getDescription());
        int n = ps.executeUpdate();
        return n;
    }

    public Rest getrestapi(String id)
            throws SQLException
    {

        String query
                = "select * from resttable where id= ?";
        PreparedStatement ps
                = con.prepareStatement(query);

        ps.setString(1, id);
        Rest rst = new Rest();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            rst.setId(rs.getString("id"));
            rst.setName(rs.getString("name"));
            rst.setDescription(rs.getString("description"));
        }

        if (check == true) {
            return rst;
        }
        else
            return null;
    }

    public void deleteapi(String id)
            throws SQLException
    {
        String query
                = "delete from resttable where id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, id);
        ps.executeUpdate();
    }


    public void updateapi(Rest rst, String id)
            throws SQLException
    {

        System.out.println("hello dao");

        String query
                = "update resttable set name=?, "
                + " description= ? where id = ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, rst.getName());
        ps.setString(2, rst.getDescription());
        ps.setString(3, id);
        ps.executeUpdate();
    }

    public List<Rest> getallrest()
            throws SQLException
    {

        String query = "select * from resttable";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Rest> ls = new ArrayList();

        while (rs.next()) {
            Rest rst = new Rest();
            rst.setId(rs.getString("id"));
            rst.setName(rs.getString("name"));
            rst.setDescription(rs.getString("description"));
            ls.add(rst);
        }
        return ls;
    }

}

