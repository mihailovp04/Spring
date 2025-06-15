package com.example.library.controller;

import com.example.library.dto.PublisherDTO;
import com.example.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public ResponseEntity<List<PublisherDTO>> getAllPublishers() {
        List<PublisherDTO> publishers = publisherService.getAllPublishers();
        return ResponseEntity.ok(publishers);
    }

    @GetMapping("/{id}")
    public PublisherDTO getPublisherById(@PathVariable Long id) {
        return publisherService.getPublisherById(id);
    }

    @PostMapping
    public ResponseEntity<PublisherDTO> createPublisher(@RequestBody PublisherDTO publisherDTO) {
        PublisherDTO dto = publisherService.createPublisher(publisherDTO);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public PublisherDTO updatePublisher(@PathVariable Long id, @RequestBody PublisherDTO publisherDTO) {
        return publisherService.updatePublisher(id, publisherDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return ResponseEntity.noContent().build();
    }
}