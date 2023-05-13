package com.hostbuddy.Items;

import com.hostbuddy.Items.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item/")
@CrossOrigin("*")
public class ItemController {
    @Autowired
    ItemService itemService;
    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item){
        Item resItem=itemService.addItem(item);
        return new ResponseEntity<Item>(item, HttpStatus.CREATED);
    }
    @GetMapping("/viewAll")
    public ResponseEntity<List<Item>> getAll(){
        List<Item> itemList=itemService.getAll();
        return new ResponseEntity<List<Item>>(itemList,HttpStatus.CREATED);
    }
    @GetMapping("/search-item")
    public ResponseEntity<List<Item>> search(@RequestParam String name){
        List<Item> itemList=itemService.search(name);
        return new ResponseEntity<List<Item>>(itemList,HttpStatus.CREATED);
    }
}
