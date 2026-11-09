/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author masha
 */
public class UserData {
    //ключ - логин, значение - объект User
    private static final Map<String, User> users = new HashMap<>();

    static {
        users.put("admin", new User("admin", "123", "admin", null));
        users.put("moder", new User("moder", "123", "moderator", null));
        users.put("user",  new User("user",  "123", "user", null));
    }

    public static User getUser(String login) {
        return users.get(login);
    }
}
