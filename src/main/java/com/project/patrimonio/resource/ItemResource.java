package com.project.patrimonio.resource;

import com.project.patrimonio.model.Item;
import com.project.patrimonio.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class ItemResource {
    @Autowired //injeção de dependencias
    private ItemRepository itemRepository;

    @GetMapping("/itens" )
    public List<Item> listAll() {
        return itemRepository.findAll();
    }

    @PostMapping("/itens")
    public Item Add(@RequestBody @Valid Item item){
        return itemRepository.save(item);
    }

    @DeleteMapping("/itens")
    public ResponseEntity remove(@RequestBody Item item){
        try {
            itemRepository.delete(item);
        }catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
         return new ResponseEntity(HttpStatus.OK);
    }


}
