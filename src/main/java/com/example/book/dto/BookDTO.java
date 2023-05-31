package com.example.book.dto;

import com.example.book.Entity.BookEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class BookDTO {
    private Long id;
    private String bookName;
    private String bookAuthor;
    private int bookPrice;

    public static BookDTO toSaveDTO(BookEntity bookEntity) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(bookEntity.getId());
            bookDTO.setBookName(bookEntity.getBookName());
            bookDTO.setBookAuthor(bookEntity.getBookAuthor());
            bookDTO.setBookPrice(bookEntity.getBookPrice());
//        for (BookEntity e : bookEntities) {
//            BookDTO bookDTO = new BookDTO();
//            bookDTO.setBookName(e.getBookName());
//            bookDTO.setBookAuthor(e.getBookAuthor());
//            bookDTO.setBookPrice(e.getBookPrice());
//            bookDTOList.add(bookDTO);
//        }
        return bookDTO;
    }
}


