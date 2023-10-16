package com.example.pract5.view;

import com.example.pract5.entity.BasketEntity;
import com.example.pract5.entity.ClientEntity;
import com.example.pract5.entity.template.Type;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BasketView {

    private Long id;

    private Long goodId;

    @Enumerated(EnumType.STRING)
    private Type goodType;

    private ClientEntity client;

    private Integer amount;

    public void update(BasketEntity basket){
        this.id = basket.getId();
        this.goodId = basket.getGoodId();
        this.goodType = basket.getGoodType();
        this.client = basket.getClient();
        this.amount = basket.getAmount();
    }

}
