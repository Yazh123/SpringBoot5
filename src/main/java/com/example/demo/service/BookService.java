package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;
@Service
public class BookService {
	@Autowired
    BookRepo br;
    
    public Book saveinfo(Book ss) {
    	return br.saveAndFlush(ss);
    }
    public List<Book> saveninfo(List<Book> ss) {
    	return (List<Book>)br.saveAll(ss);
    }
     
    public List<Book> printinfo(){
    	return br.findAll();
    }
    
    public Optional<Book> findid(int id){
    	return br.findById(id);
    }
    public void deleteid(int id){
    	br.deleteById(id);
    }
    public String add(int id, Book ss) {
    	br.saveAndFlush(ss);
    	if(br.existsById(id)) {
    		return "updated";
    	}
    	else {
    		return "enter a valid id";
    	}
    }
} 
