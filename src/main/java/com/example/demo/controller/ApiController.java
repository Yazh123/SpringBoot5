package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
@RestController

public class ApiController {
	@Autowired
    BookService bs;
   
	@PostMapping("/")
    public boolean postinfo(@RequestBody Book book) {
   	 bs.saveinfo(book);
   	 return true;
    }
    
    @PostMapping("/n")
    public boolean postninfo(@RequestBody List<Book> book) {
   	 bs.saveninfo(book);
   	 return true;
    }
    
    @GetMapping("/")
     public List<Book> getinfo(){
   	 return bs.printinfo();
    }
    
    @GetMapping("/{id}")
    public Optional<Book> findid(@PathVariable int id)
    {
        return bs.findid(id);
    }
    
   @PutMapping("/{id}")
   public String updatebyid(@PathVariable int id , @RequestBody Book book){
   	return bs.add(id,book);
   
   }
   
   @DeleteMapping("/{id}")
	public void deletebyid(@PathVariable int id) {
		bs.deleteid(id);
	}
	
}
