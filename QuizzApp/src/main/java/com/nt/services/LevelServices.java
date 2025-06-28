/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nt.services;

import com.nt.pojo.Category;
import com.nt.pojo.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class LevelServices {
    public List<Level> getLevels() throws ClassNotFoundException, SQLException{
        //B1: Nap driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //b2: mo ket noi
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quizzdb", "root", "root");
            
            //b3: Xu ly truy van
            Statement stm = conn.createStatement();
            ResultSet rs =  stm.executeQuery("SELECT * FROM level");
            
            List<Level> levels = new ArrayList<>();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String note = rs.getString("note");

                levels.add(new Level(id, name, note));
            }
        return levels;
    }
}
