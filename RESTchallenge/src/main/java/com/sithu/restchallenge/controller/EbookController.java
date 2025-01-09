package com.sithu.restchallenge.controller;

import com.sithu.restchallenge.entity.Ebook;
import com.sithu.restchallenge.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EbookController {
    @Autowired
    EbookService service;

    @GetMapping("/ebooks")
    public List<Ebook> allEbooks() {
        return service.getAllBooks();
    }

    @GetMapping("/ebooks/{id}")
    public Ebook getEbook(@PathVariable int id){
        return service.getBookById(id);
    }

    @PostMapping("/ebooks")
    public Ebook addEbook(@RequestBody Ebook ebook) {
        ebook.setId(0);
        return service.addBook(ebook);
    }

    @PutMapping("/ebooks/{id}")
    public Ebook updateEbook(@PathVariable int id, @RequestBody Ebook ebook) {
        return service.updateBook(id, ebook);
    }

    @PatchMapping("/ebooks/{id}")
    public Ebook partialUpdate(@PathVariable int id, @RequestBody Map<String, Object> ebookPatch) {
        return service.patchBook(id, ebookPatch);
    }

    @DeleteMapping("/ebooks/{id}")
    public void deleteEbook(@PathVariable int id) {
        service.deleteBook(id);
    }
}
