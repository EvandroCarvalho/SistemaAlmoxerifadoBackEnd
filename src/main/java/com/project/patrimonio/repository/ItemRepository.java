package com.project.patrimonio.repository;

import com.project.patrimonio.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
//Com esta interface o spring jpa prove a implementação da mesma
public interface ItemRepository extends JpaRepository<Item, Long> {
}
