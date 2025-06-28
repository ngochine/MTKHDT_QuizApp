/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nt.services;

import com.nt.pojo.Category;
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
public class CategotyServices {
    public List<Category> getCates() throws ClassNotFoundException, SQLException{
        //B1: Nap driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //b2: mo ket noi
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quizzdb", "root", "root");
            
            //b3: Xu ly truy van
            Statement stm = conn.createStatement();
            ResultSet rs =  stm.executeQuery("SELECT * FROM category");
            
            List<Category> cates = new ArrayList<>();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                cates.add(new Category(id, name));
            }
        return cates;
    }
}
