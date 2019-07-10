package DAO;
import User.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.sql.*;

public class Dao {

    public void createDataSet(String email) throws InterruptedException{
        int max = 7;
        int min = 3;
        int range = max-min+1;
        int[] power = new int[5];
        ArrayList<User> dataSet = new ArrayList<User>();
        for(int i = 0; i<power.length;i++){
            int rand = (int)(Math.random() * range) + min;
            power[i] = rand;
            dataSet.add(new User(email,rand));
            System.out.println(rand);
            Thread.sleep(10000);
        }
        sendToDB(dataSet,email);
    }

    public void sendToDB(ArrayList<User> dataSet, String emailAddress){
        Connection conn = null;
        try{
            conn = createConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS EcoScopeTemplate (email varchar(32),powerconsumption int ,powerTime TIMESTAMP not null);");
            PreparedStatement insertDataSet = conn.prepareStatement("INSERT INTO EcoScopeTemplate VALUES(?,?,CURRENT_TIMESTAMP())");
            for(int i = 0; i<dataSet.size();i++){
                insertDataSet.setString(1,dataSet.get(i).getEmail());
                insertDataSet.setInt(2,dataSet.get(i).getPower());
                insertDataSet.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private Connection createConnection() throws SQLException{
        return  DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s153679?"
                +"user=s153679&password=2IYMod6yoCtICi61cdPFR");
    }
}


