package classes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.time.*;  
/**
 *
 * @author masha
 */
public class News {
    private final int id;
    private final String title;
    private final String text;
    private final String author;
    private final LocalDateTime publicationDate;
    
    public News(int id, String title, String text, String author, LocalDateTime publicationDate){
        this.id = id;
        this.title = title;
        this.text = text;
        this.author = author;
        this.publicationDate = publicationDate;
    }
    
    public int getID(){return id;}
    public String getTitle(){return title;}
    public String getText(){return text;}
    public String getAuthor(){return author;}
    public LocalDateTime getPublicationDate(){return publicationDate;}
}

