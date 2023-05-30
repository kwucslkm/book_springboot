package com.example.book.service;

import com.example.book.Entity.BookEntity;
import com.example.book.dto.BookDTO;
import com.example.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public void save(BookDTO bookDTO){
      BookEntity bookEntity = BookEntity.toSaveEntity(bookDTO);
      bookRepository.save(bookEntity);
    }

    public List<BookDTO> findAll() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        List<BookDTO> bookDTOList = BookEntity.toSaveDTO(bookEntities);
        System.out.println("bookDTOList = " + bookDTOList);
        return bookDTOList;
    }
}
