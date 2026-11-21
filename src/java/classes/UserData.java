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

    public static User getUser(String login) {
        return users.get(login);
    }

    public static boolean register(String login, String password) {
        if (users.containsKey(login)) {
            return false;
        }
        String salt = PasswordUtil.generateSalt();
        String hash = PasswordUtil.hashPassword(password, salt);
        users.put(login, new User(login, hash, salt, "user"));
        return true;
    }

    private static void createUser(String login, String password, String role) {
        String salt = PasswordUtil.generateSalt();
        String hash = PasswordUtil.hashPassword(password, salt);
        users.put(login, new User(login, hash, salt, role));
    }

    static {
        createUser("admin", "123", "admin");
        createUser("moder", "123", "moderator");
        createUser("user", "123", "user");

        //загружаем аватарки из файла и раздаем их пользователям
        HashMap<String, String> savedAvatars = AvatarStorage.load();
        for (String login : savedAvatars.keySet()) {
            User u = users.get(login);
            if (u != null) {
                u.setAvatar(savedAvatars.get(login));
            }
        }
    }
}
