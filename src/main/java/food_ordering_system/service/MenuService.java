package com.jumpstart.Menu_Entity.service;

import com.jumpstart.Menu_Entity.dto.MenuDto;
import com.jumpstart.Menu_Entity.dto.Response;
import java.util.List;

public interface MenuService {
    Response<MenuDto> createMenu(MenuDto dto);
    Response<List<MenuDto>> getAllMenus();
    Response<MenuDto> getMenuById(Long id);
}