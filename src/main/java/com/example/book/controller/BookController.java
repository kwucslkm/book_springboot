package com.example.book.controller;

import com.example.book.dto.BookDTO;
import com.example.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/save")
    public String save() {
        return "bookSave";
    }

    @PostMapping("/save")
    public String saveform(@ModelAttribute BookDTO bookDTO) {
        bookService.save(bookDTO);

        return "index";
    }

    @GetMapping("/books")
    public String findAll(Model model) {
        List<BookDTO> bookDTOList = bookService.findAll();
        model.addAttribute("books", bookDTOList);
        return "books";

    }

}
