package org.abhi.springbottmockito.Controllers;

import org.abhi.springbottmockito.Entity.Item;
import org.abhi.springbottmockito.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/api/dummy-item")
    public Item dummyItem(){
        return new Item(1,"Ball",10,100);
    }

    @GetMapping("/api/serviceItem")
    public Item serviceItem(){
        return itemService.retrieveHardCodedItem();
    }

}
