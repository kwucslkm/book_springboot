package com.example.book.service;

import com.example.book.Entity.BookEntity;
import com.example.book.dto.BookDTO;
import com.example.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Long save(BookDTO bookDTO) {
        BookEntity bookEntity = BookEntity.toSaveEntity(bookDTO);
        bookRepository.save(bookEntity);
        return bookRepository.save(bookEntity).getId();
    }

    public List<BookDTO> findAll() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (BookEntity bookEntity : bookEntities) {
            bookDTOList.add(BookDTO.toSaveDTO(bookEntity));
        }
//        List<BookDTO> bookDTOList = BookDTO.toSaveDTO(bookEntities);
//        System.out.println("bookDTOList = " + bookDTOList);
        return bookDTOList;
    }

    public BookDTO findById(Long id) {
        Optional<BookEntity> optionalBookEntity = bookRepository.findById(id);
        if (optionalBookEntity.isPresent()) {
            System.out.println("있따.");
            BookEntity bookEntity = optionalBookEntity.get();
            BookDTO bookDTO = BookDTO.toSaveDTO(bookEntity);
            return bookDTO;
//            return BookDTO.toSaveDTO(optionalBookEntity.get());
        } else {
            System.out.println("없다.");
            return null;
        }
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public void update(BookDTO bookDTO) {
        BookEntity bookEntity = BookEntity.toUpdateEntity(bookDTO);
        bookRepository.save(bookEntity);
    }
}
