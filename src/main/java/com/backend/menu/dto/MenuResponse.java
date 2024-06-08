package com.backend.menu.dto;

import com.backend.menu.model.Menu;
import lombok.Getter;

@Getter
public class MenuResponse {
    private final Long id;
    private final String name;

    public MenuResponse(Menu m) {
        this.id = m.getId();
        this.name = m.getName();
    }
}
