package classes;

public class User {
    private String login;
    private String passwordHash; 
    private String salt;         
    private String role; // "admin", "moderator", "user" 
    private String avatar;

    public User(String login, String passwordHash, String salt, String role) {
        this.login = login;
        this.passwordHash = passwordHash;
        this.salt = salt;
        this.role = role;
    }

    // Геттеры
    public String getLogin() { return login; }
    public String getPasswordHash() { return passwordHash; }
    public String getSalt() { return salt; }
    public String getRole() { return role; }
    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
}