package com.example.pract5.entity.template;

import com.example.pract5.form.template.AbstractProductForm;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractProductEntity<F extends AbstractProductForm> extends AbstractEntity<F>{

    protected Long id_seller;

    protected Integer price;

    protected String title;

    private Integer amount = 0;

    @Override
    public void update(F form) {
        this.id_seller = form.getId_seller();
        this.price = form.getPrice();
        this.title = form.getTitle();
        this.amount = form.getAmount();
    }
}
