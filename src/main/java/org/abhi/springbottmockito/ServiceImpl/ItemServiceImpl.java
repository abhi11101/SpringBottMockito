package org.abhi.springbottmockito.ServiceImpl;

import org.abhi.springbottmockito.Entity.Item;
import org.abhi.springbottmockito.Service.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Override
    public Item retrieveHardCodedItem() {
        return  new Item(1,"Ball",10,100);
    }
}
