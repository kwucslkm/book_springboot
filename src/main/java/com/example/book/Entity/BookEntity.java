package com.example.book.Entity;

import com.example.book.dto.BookDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "book_table")
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
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName(bookDTO.getBookName());
        bookEntity.setBookAuthor(bookDTO.getBookAuthor());
        bookEntity.setBookPrice(bookDTO.getBookPrice());
        return bookEntity;
    }


    public static List<BookDTO> toSaveDTO(List<BookEntity> bookEntities) {
        List<BookDTO> bookDTOList = null;
        for (BookEntity e : bookEntities) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setBookName(e.getBookName());
            bookDTO.setBookAuthor(e.getBookAuthor());
            bookDTO.setBookPrice(e.getBookPrice());
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }
}
