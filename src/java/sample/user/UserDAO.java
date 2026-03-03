/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class UserDAO {
    private static final String LOGIN = "SELECT fullName, roleID FROM tblUsers WHERE userID = ? AND password = ?";
    private static final String SEARCH = "SELECT userID, fullName, roleID FROM tblUsers WHERE fullName like ?";
    private static final String UPDATE = "UPDATE tblUsers SET fullName = ?, roleID = ? WHERE userID = ?";
    private static final String DELETE = "DELETE tblUsers WHERE userID = ?";
    private static final String INSERT = "INSERT INTO tblUsers(userID, fullName, roleID, password) VALUES(?, ?, ?, ?)";
    private static final String DUPLICATE = "SELECT fullName FROM tblUsers WHERE userID = ?";
    
    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;        
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if(rs.next()){
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    user = new UserDTO(userID, "***", roleID, fullName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        
        return user;
    }

    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> listUser = new ArrayList<>();        
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;        
        try {
            conn = DBUtils.getConnection();
            if(conn!= null){
                ptm= conn.prepareStatement(SEARCH);
                ptm.setString(1, search);
                ptm.setString(1, "%" + search + "%");
                rs= ptm.executeQuery();
                while(rs.next()){
                    String userID= rs.getString("userID");
                    String fullName= rs.getString("fullName");
                    String roleID= rs.getString("roleID");                    
                    listUser.add( new UserDTO(userID, "***", roleID, fullName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }        
        return listUser;
    }

    public boolean update(UserDTO user) throws SQLException {            
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;        
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, user.getFullname());
                ptm.setString(2, user.getRoleID());
                ptm.setString(3, user.getUserID());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {            
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        
        return check;
    }
    
    public boolean delete(UserDTO user) throws SQLException {            
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;        
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, user.getUserID());                
                check = ptm.executeUpdate() > 0;                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {            
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        
        return check;
    }        

    public boolean insert(UserDTO user) throws SQLException {
        boolean check = false;           
        Connection conn = null;
        PreparedStatement ptm = null;        
        
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, user.getUserID());
                ptm.setString(2, user.getFullname());
                ptm.setString(3, user.getRoleID());
                ptm.setString(4, user.getPassword());
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        
        return check;
    }

    public boolean checkDuplicate(String userID) throws SQLException  {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;        
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(DUPLICATE);                
                ptm.setString(1, userID);                
                rs = ptm.executeQuery();
                if(rs.next()){
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {            
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return check;
    }
    
}
