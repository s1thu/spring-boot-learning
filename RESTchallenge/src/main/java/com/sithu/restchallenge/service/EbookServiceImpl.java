package com.sithu.restchallenge.service;

import com.sithu.restchallenge.entity.Ebook;
import com.sithu.restchallenge.exception.EbookNotFoundException;
import com.sithu.restchallenge.repository.EbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EbookServiceImpl implements EbookService{

    @Autowired
    private EbookRepository ebookRepository;


    @Override
    public List<Ebook> getAllBooks() {
        return ebookRepository.findAll();
    }

    @Override
    public Ebook getBookById(int id) {
        Optional<Ebook> ebook = ebookRepository.findById(id);
        if (ebook.isPresent()) {
            return ebook.get();
        }else
            throw new EbookNotFoundException("Ebook with id " + id + " not found");
    }

    @Override
    public Ebook addBook(Ebook book) {
        book.setId(0);
        return ebookRepository.save(book);
    }

    @Override
    public Ebook updateBook(int id,Ebook book) {
        Optional<Ebook> ebook = ebookRepository.findById(id);
        Ebook updateBook = null;
        if (ebook.isPresent()) {
            updateBook.setAuthor(book.getAuthor());
            updateBook.setTitle(book.getTitle());
            updateBook.setPrice(book.getPrice());
            updateBook.setPublishDate(book.getPublishDate());
            updateBook.setDiscount(book.getDiscount());
            return ebookRepository.save(updateBook);
        }else
            throw new EbookNotFoundException("Ebook with id " + id + " not found");
    }

    @Override
    public String deleteBook(int id) {
        Optional<Ebook> ebook = ebookRepository.findById(id);
        if (ebook.isPresent()) {
            ebookRepository.delete(ebook.get());
            return "Book with id " + id + " successfully deleted";
        }else
            throw new EbookNotFoundException("Ebook with id " + id + " not found");
    }

    @Override
    public Ebook patchBook(int id, Map<String, Object> patchEbook) {
        Optional<Ebook> optionalEbook = ebookRepository.findById(id);
        Ebook ebook = null;
        if (optionalEbook.isPresent()) {
            ebook = optionalEbook.get();
            patchEbook.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Ebook.class, key);
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, optionalEbook.get(), value);
            });
        }
        else
            throw new EbookNotFoundException("Ebook with id " + id + " not found");

        return ebookRepository.save(ebook);
    }


}
