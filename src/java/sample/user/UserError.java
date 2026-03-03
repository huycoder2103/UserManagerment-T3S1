/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.user;

/**
 *
 * @author ADMIN
 */
public class UserError {
    private String userID;
    private String password;
    private String roleID;
    private String fullname;
    private String confirm;
    private String error;

    public UserError(String userID, String password, String roleID, String fullname, String confirm, String error) {
        this.userID = userID;
        this.password = password;
        this.roleID = roleID;
        this.fullname = fullname;
        this.confirm = confirm;
        this.error = error;
    }

    public UserError() {
        this.userID = "";
        this.password = "";
        this.roleID = "";
        this.fullname = "";
        this.confirm = "";
        this.error = "";
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

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

        
}
