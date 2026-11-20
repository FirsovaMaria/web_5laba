/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.*;
import java.util.HashMap;

/**
 *
 * @author masha
 */
public class AvatarStorage {
    private static final String FILE_NAME = "avatars.txt";
    
    //загружаем все сохраненные аватарки из файла в память при старте
    public static HashMap<String, String> load(){
        HashMap<String, String> avatars = new HashMap<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return avatars;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine())!= null){
                String[] parts = line.split("=", 2);
                if (parts.length == 2){
                    avatars.put(parts[0], parts[1]);
                    
                }
            }
        }catch(IOException e){
            System.out.println("Ошибка чтения аватарок: " + e.getMessage());
        }
        return avatars;
   }
    
    public static void save(String login, String avatarFileName){
        HashMap<String, String> avatars = load(); // берем текущие
        avatars.put(login, avatarFileName);   // обновляем нужного юзера

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (HashMap.Entry<String, String> entry : avatars.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи аватарки: " + e.getMessage());
        }
    }
}
