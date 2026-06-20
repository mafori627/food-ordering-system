package com.jumpstart.Menu_Entity.repository;

import com.jumpstart.Menu_Entity.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

}
