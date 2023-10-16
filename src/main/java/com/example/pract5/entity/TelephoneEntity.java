package com.example.pract5.entity;
import com.example.pract5.entity.template.AbstractProductEntity;
import com.example.pract5.entity.template.Type;
import com.example.pract5.form.TelephoneForm;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "telephones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TelephoneEntity extends AbstractProductEntity<TelephoneForm> {

    private String manufacturer;
    private Integer battery_capacity;

    @Enumerated(EnumType.STRING)
    @Setter(AccessLevel.NONE)
    private final Type type = Type.Electronics;


    @Override
    public void update(TelephoneForm form) {
        super.update(form);
        this.manufacturer = form.getManufacturer();
        this.battery_capacity = form.getBattery_capacity();
    }

}
