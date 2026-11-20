/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordUtil {
    
    //генерирует случайную соль
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt); //заполняет целый массив байтов случайными значениями.
        return Base64.getEncoder().encodeToString(salt);
                //Base64.getEncoder() - кодировает байты в текст.
                //encodeToString(salt) - переводит массив байтов в строку.
    }

    //хеширует пароль с солью
    public static String hashPassword(String password, String salt) {
        try {
            //использует алгоритм PBKDF2WithHmacSHA256
            PBEKeySpec spec = new PBEKeySpec(
            password.toCharArray(),//по стадндартам передается массив символов, в отличии от String, после использования мы можем «затереть» этот массив нулями в памяти, чтобы злоумышленник не смог вытащить пароль
            Base64.getDecoder().decode(salt), //соль декодируем обратно в массив байтов, так как так нужно алгоритму
            65536, //количество итераций, сколько раз алгоритм «перемешает» пароль и соль
            128);//длина итогового ключа в битах
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("Ошибка при хешировании пароля", e);
        }
    }

    //проверка пароля при входе
    public static boolean checkPassword(String enteredPassword, String storedHash, String salt) {
        String newHash = hashPassword(enteredPassword, salt);
        return newHash.equals(storedHash);
    }
}