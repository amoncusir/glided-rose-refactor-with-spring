package com.gildedrose;

import com.gildedrose.entity.Item;
import com.gildedrose.repository.ItemRepository;
import com.gildedrose.service.ItemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import reactor.core.publisher.Flux;

import java.util.List;


/**
 * <!-- Documentation for: com.gildedrose.ItemServiceTest on 14/12/18 -->
 *
 * @author Aran Moncusí Ramírez
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class ItemServiceTest
{
    //~ Constants ======================================================================================================

    //~ Properties =====================================================================================================

    @Autowired
    public ItemService service;

    @Autowired
    public ItemRepository repository;

    //~ Constructors ===================================================================================================

    //~ Methods ========================================================================================================

    @Test
    public void testGetAllItems()
    {
        final Flux<Item> serviceAllItems = service.getAllItems();
        final Flux<Item> repositoryAllItems = repository.getAllItems();

        final List<Item> itemsService = serviceAllItems.collectList().block();
        final List<Item> itemsRepository = repositoryAllItems.collectList().block();

        Assert.assertEquals(itemsRepository, itemsService);
    }

    //~ Static Methods =================================================================================================

    //~ Implementations ================================================================================================
}
