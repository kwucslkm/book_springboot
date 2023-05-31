package com.example.book.Entity;

import com.example.book.dto.BookDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "book_table")
@ToString
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String bookName;
    @Column(length = 20)
    private String bookAuthor;
    @Column
    private int bookPrice;

    public static BookEntity toSaveEntity(BookDTO bookDTO) {
//        BookEntity bookEntity = new BookEntity();
//        bookEntity.setBookName(bookDTO.getBookName());
//        bookEntity.setBookAuthor(bookDTO.getBookAuthor());
//        bookEntity.setBookPrice(bookDTO.getBookPrice());
        return toSaveEntityNoId(bookDTO);
    }


    public static BookEntity toUpdateEntity(BookDTO bookDTO) {
        BookEntity bookEntity = toSaveEntityNoId(bookDTO);
//        BookEntity bookEntity = new BookEntity();
//        bookEntity.setBookName(bookDTO.getBookName());
//        bookEntity.setBookAuthor(bookDTO.getBookAuthor());
//        bookEntity.setBookPrice(bookDTO.getBookPrice());Book20230530Application
        bookEntity.setId(bookDTO.getId());
        return bookEntity;
    }
    public static BookEntity toSaveEntityNoId(BookDTO bookDTO){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName(bookDTO.getBookName());
        bookEntity.setBookAuthor(bookDTO.getBookAuthor());
        bookEntity.setBookPrice(bookDTO.getBookPrice());
        return bookEntity;
    }
}
