package com.example.pract5.entity;

import com.example.pract5.entity.template.AbstractEntity;
import com.example.pract5.entity.template.Type;
import com.example.pract5.form.CartForm;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "carts")
public class BasketEntity extends AbstractEntity<CartForm> {

    @Column(name = "good_id")
    private Long goodId;

    @Enumerated(EnumType.STRING)
    @Column(name = "good_type")
    private Type goodType;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private ClientEntity client;

    private Integer amount = 1;

    @Override
    public void update(CartForm form) {

    }
}
