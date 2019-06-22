/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author omandotkom
 */
public class BasicQuery {

    private Connection connection;

    public int runQuery(String query) {
        connection = new DBConnector().getConnection();
        try {
            int result;
            try (Statement statement = connection.createStatement()) {
                result = statement.executeUpdate(query);
                System.out.println(result);
                connection.close();
            }
            return result;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            return -1;
        }
    }

    public ResultSet runView(String query) {
        ResultSet rs;
        connection = new DBConnector().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query); 
            statement.close();
            connection.close();
         return rs;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}
