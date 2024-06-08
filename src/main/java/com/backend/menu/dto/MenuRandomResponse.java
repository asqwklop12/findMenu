package com.backend.menu.dto;

import com.backend.menu.model.Menu;
import lombok.Getter;

import java.util.List;

@Getter
public class MenuRandomResponse {
    private final Long idx;
    private final String name;

    public MenuRandomResponse(List<Menu> allMenuList) {
        this.idx = (long) (Math.random() * allMenuList.size()) + 1;
        this.name = allMenuList.get(Math.toIntExact(this.idx - 1)).getName();
    }
}
