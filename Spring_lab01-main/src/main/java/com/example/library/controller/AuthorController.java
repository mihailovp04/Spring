package com.example.library.controller;

import com.example.library.dto.AuthorDTO;
import com.example.library.service.AuthorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors()
    {
        List<AuthorDTO> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public AuthorDTO getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO>  createAuthor(@RequestBody AuthorDTO authorDTO) {
        AuthorDTO dto = authorService.createAuthor(authorDTO);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public AuthorDTO updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        return authorService.updateAuthor(id, authorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id)
    {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}