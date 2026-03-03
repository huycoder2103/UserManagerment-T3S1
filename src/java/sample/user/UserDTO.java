/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.user;

/**
 *
 * @author ADMIN
 */
public class UserDTO {
    private String userID;
    private String password;
    private String roleID;
    private String fullname;

    public UserDTO() {
        this.userID = "";
        this.password = "";
        this.roleID = "";
        this.fullname = "";
    }

    public UserDTO(String userID, String password, String roleID, String fullname) {
        this.userID = userID;
        this.password = password;
        this.roleID = roleID;
        this.fullname = fullname;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    
}
