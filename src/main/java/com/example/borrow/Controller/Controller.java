package com.example.borrow.Controller;


import com.example.borrow.Entity.Borrow;
import com.example.borrow.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/borrow")
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired
    private  Repository repository;
    @Autowired
    private  RestTemplate restTemplate;



    @GetMapping("/all")
    public List<Borrow> getAllBorrows() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> borrowBook(@RequestBody Borrow borrow) {
        // Validate user
        ResponseEntity<Map> userResponse = restTemplate.getForEntity(
                "http://localhost:8082/user/" + borrow.getUserId(), Map.class);
        if (!userResponse.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        // Validate book
        ResponseEntity<Map> bookResponse = restTemplate.getForEntity(
                "http://localhost:8081/books/" + borrow.getBookId(), Map.class);
        if (!bookResponse.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }

        // Save borrow
        return ResponseEntity.ok(repository.save(borrow));
    }
}


