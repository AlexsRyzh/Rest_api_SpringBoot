package com.example.pract5.entity;


import com.example.pract5.entity.template.AbstractEntity;
import com.example.pract5.entity.template.AbstractProductEntity;
import com.example.pract5.entity.template.Type;
import com.example.pract5.form.BookForm;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity extends AbstractProductEntity<BookForm> {

    private String author;


    @Enumerated(EnumType.STRING)
    @Setter(AccessLevel.NONE)
    private final Type type = Type.Books;



    @Override
    public void update(BookForm form) {
        super.update(form);
        this.author = form.getAuthor();
    }
}
