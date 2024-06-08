package com.backend.menu.dto;

import com.backend.menu.model.Menu;
import lombok.Getter;

@Getter
public class CreateMenuResponse {
    private final Long id;
    private final String name;
    public CreateMenuResponse(Menu menus) {
        this.id = menus.getId();
        this.name = menus.getName();

    }
}
