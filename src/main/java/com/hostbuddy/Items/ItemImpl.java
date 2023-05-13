package com.hostbuddy.Items;

import com.hostbuddy.Items.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ItemImpl implements ItemService {
    HashMap<Integer,Item> itemMap=new HashMap<>();
    @Override
    public Item addItem(Item item) {
        int key= itemMap.size()+1;
        itemMap.put(key,item);
        return item;
    }

    @Override
    public List<Item> getAll() {
        return new ArrayList<>(itemMap.values());
    }

    @Override
    public List<Item> search(String keyword) {
        List<Item> itemList=new ArrayList<>(itemMap.values());
        List<Item> searchList=new ArrayList<>();
        keyword=keyword.trim().toLowerCase();
        for(Item item:itemList){
            String name=item.getName().trim().toLowerCase();
            String description=item.getDescription().trim().toLowerCase();
            if(name.contains(keyword) || description.contains(keyword)) {
                searchList.add(item);
            }
        }
        return searchList;
    }
}
