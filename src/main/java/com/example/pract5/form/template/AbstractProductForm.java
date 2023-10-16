package com.example.pract5.form.template;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractProductForm{
    @NotNull(message = "Поле id_seller не может быть пустым")
    private Long id_seller;

    @NotNull(message = "Поле price не может быть пустым")
    private Integer price;

    @NotNull(message = "Поле price не может быть пустым")
    private String title;

    @NotNull(message = "Поле amount не может быть пустым")
    @Min(value = 0, message = "Минимальное значение для amount 0")
    private int amount = 0;
}
