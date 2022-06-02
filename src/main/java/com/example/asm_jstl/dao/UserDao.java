package com.example.asm_jstl.dao;

import com.example.asm_jstl.model.User;
import com.example.asm_jstl.until.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    Connection connection = ConnectionUtil.getConnection();


    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public String updateUser(User user) {
        String sql = "UPDATE user SET name = ?,email = ?,address = ?,phone=?  WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getAddress());
            ps.setString(4,user.getPhone());
            ps.setInt(5,user.getId());
            int isSuccess = ps.executeUpdate();
            if (isSuccess > 0){
                return "Success";
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "fail";
    }
    public String deleteUser(int[] listId ) {
        try {
            int isSuccess=0;
            for (int id:listId) {
                String sql = "DELETE FROM user WHERE id = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1,id);
                isSuccess = ps.executeUpdate();
            }
            if (isSuccess > 0){
                return "Success";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "fail";
    }
    public String deleteAllUser() {

        try {
            String sql = "DELETE FROM user";
            PreparedStatement ps = connection.prepareStatement(sql);
            int isSuccess = ps.executeUpdate();
            if (isSuccess > 0){
                return "Success";
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "fail";
    }
    public String insertUser(User user) {
        String sql = "INSERT INTO user (name,email,address,phone) VALUE (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getAddress());
            ps.setString(4,user.getPhone());
            int isSuccess = ps.executeUpdate();
            if (isSuccess > 0){
                return "Success";
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "fail";
    }


}
