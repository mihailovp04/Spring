package com.example.library.controller;

import com.example.library.dto.LibraryDTO;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public ResponseEntity<List<LibraryDTO>> getAllLibraries() {
        List<LibraryDTO> libraries = libraryService.getAllLibraries();
        return ResponseEntity.ok(libraries);
    }

    @GetMapping("/{id}")
    public LibraryDTO getLibraryById(@PathVariable Long id) {
        return libraryService.getLibraryById(id);
    }

    @PostMapping
    public ResponseEntity<LibraryDTO> createLibrary(@RequestBody LibraryDTO libraryDTO) {
        LibraryDTO dto = libraryService.createLibrary(libraryDTO);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public LibraryDTO updateLibrary(@PathVariable Long id, @RequestBody LibraryDTO libraryDTO) {
        return libraryService.updateLibrary(id, libraryDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Long id) {
        libraryService.deleteLibrary(id);
        return ResponseEntity.noContent().build();
    }
}