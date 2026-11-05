/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author masha
 */
public class VisitCounter {
    public static final String FILE_NAME = "visits.txt"; // имя файла
    
    public static synchronized long increment() {
        long count = 0;
        File file = new File(FILE_NAME); // путь к файлу
        
        // Чтение с помощью BufferedReader
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = reader.readLine();
                if (line != null && !line.trim().isEmpty()) {
                    count = Long.parseLong(line.trim());
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Ошибка при чтении счетчика: " + e.getMessage());
            }
        } 
        
        count++;
        
        // Запись обратно в файл
        try(FileWriter writer = new FileWriter(file)){
            writer.write(String.valueOf(count));
        }catch(IOException e){
            System.out.println("Ошибка при записи счетчика: " + e.getMessage());
        }
        
        return count;
    } 
} 