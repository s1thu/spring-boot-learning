package com.sithu.restchallenge.service;

import com.sithu.restchallenge.entity.Ebook;

import java.util.List;
import java.util.Map;

public interface EbookService {
    public List<Ebook> getAllBooks();
    public Ebook getBookById(int id);
    public Ebook addBook(Ebook book);
    public Ebook updateBook(int id,Ebook book);
    public String deleteBook(int id);
    public Ebook patchBook(int id, Map<String,Object> patchEbook);
}
