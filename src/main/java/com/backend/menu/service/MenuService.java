package com.backend.menu.service;

import com.backend.menu.dto.CreateMenuRequest;
import com.backend.menu.dto.CreateMenuResponse;
import com.backend.menu.dto.MenuRandomResponse;
import com.backend.menu.dto.MenuResponse;
import com.backend.menu.model.Menu;
import com.backend.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public CreateMenuResponse insert(CreateMenuRequest createMenuRequest) {
        Menu menu = new Menu(createMenuRequest);
        Menu menus = menuRepository.save(menu);
        return new CreateMenuResponse(menus);
    }

    public List<MenuResponse> get() {
        return menuRepository.findAll().stream().map(MenuResponse::new).toList();
    }

    public void delete(Long id) {
        menuRepository.deleteById(id);
    }

    public MenuRandomResponse random() {
        List<Menu> allMenuList = menuRepository.findAll();

        return new MenuRandomResponse(allMenuList);
    }
}
