package com.backend.menu.controller;

import com.backend.menu.dto.CreateMenuRequest;
import com.backend.menu.dto.CreateMenuResponse;
import com.backend.menu.dto.MenuRandomResponse;
import com.backend.menu.dto.MenuResponse;
import com.backend.menu.service.MenuService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/menu")
    public CreateMenuResponse createMenu(@RequestBody CreateMenuRequest createMenuRequest) {
        return menuService.insert(createMenuRequest);
    }

    @GetMapping("/menu")
    public List<MenuResponse> getMenuList() {
        return menuService.get();
    }


    @GetMapping("/menu/random")
    public MenuRandomResponse getMenuRandom() {
        return menuService.random();
    }


    @DeleteMapping("/menu/{id}")
    public void deleteMenuList(@PathVariable Long id) {
        menuService.delete(id);
    }


}
