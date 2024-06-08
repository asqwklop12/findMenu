package com.backend.menu.model;

import com.backend.menu.dto.CreateMenuRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Menu(CreateMenuRequest createMenuRequest) {
        this.name = createMenuRequest.getName();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
