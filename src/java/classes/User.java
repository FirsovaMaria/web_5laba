/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author masha
 */
public class User {
    private String login;
    private String password;
    private String role; // "admin", "moderator", "user" 
    private String avatar;
    
    public User(String login, String password, String role, String avatar) {
        this.login = login;
        this.password = password;
        this.role = role;
    }
    // Геттеры и сеттеры
    public String getLogin() { return login; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
}
