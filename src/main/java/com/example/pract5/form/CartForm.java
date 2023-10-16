package com.example.pract5.form;


import com.example.pract5.entity.template.Type;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartForm {

    @NotNull(message = "Поле id_goods не может быть пустым")
    @Min(1)
    private Long id_good;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Поле good_type не может быть пустым")
    private Type good_type;

}
