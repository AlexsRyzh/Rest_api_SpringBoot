package com.example.pract5.entity;

import com.example.pract5.entity.template.AbstractEntity;
import com.example.pract5.form.ClientForm;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
public class ClientEntity extends AbstractEntity<ClientForm> {

    private String name;

    private String email;

    private String login;

    private String password;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<BasketEntity> cart;

    @Override
    public void update(ClientForm form) {
        this.name = form.getName();
        this.email = form.getEmail();
        this.login = form.getLogin();
        this.password = form.getPassword();
    }
}
