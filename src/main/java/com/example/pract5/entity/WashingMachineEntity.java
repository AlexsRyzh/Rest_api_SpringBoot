package com.example.pract5.entity;

import com.example.pract5.entity.template.AbstractProductEntity;
import com.example.pract5.entity.template.Type;
import com.example.pract5.form.WashingMachineForm;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "washing_machines")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WashingMachineEntity extends AbstractProductEntity<WashingMachineForm> {

    private String manufacturer;
    private Integer tank_capacity;

    @Enumerated(EnumType.STRING)
    @Setter(AccessLevel.NONE)
    private final Type type = Type.Plumbing;


    @Override
    public void update(WashingMachineForm form) {
        super.update(form);
        this.manufacturer = form.getManufacturer();
        this.tank_capacity = form.getTank_capacity();
    }
}
