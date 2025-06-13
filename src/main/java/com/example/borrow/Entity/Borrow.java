package com.example.borrow.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="borrows")
public class Borrow {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

    private Long userId;
    private Long bookId;


    public Borrow() {
    }

    public Borrow(LocalDate borrowDate, Long bookId, Long userId) {

        this.bookId = bookId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }


}
