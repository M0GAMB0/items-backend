package com.hostbuddy.Items;

import com.hostbuddy.Items.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;
//Interface of services provided by backend
@Service
public interface ItemService {
    public Item addItem(Item item);
    public List<Item> getAll();
    public List<Item> search(String keyword);
}
