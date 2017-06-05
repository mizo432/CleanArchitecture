package biz.paluch.clean.architecture.facade;

import biz.paluch.clean.architecture.applicationmodel.Item;
import biz.paluch.clean.architecture.contracts.repositories.ItemRepository;
import biz.paluch.clean.architecture.contracts.usecases.CreateOrUpdateItem;
import biz.paluch.clean.architecture.contracts.usecases.ListItemsOutput;
import biz.paluch.clean.architecture.usecases.advanced.ListItemsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:mpaluch@paluch.biz">Mark Paluch</a>
 * @since 02.08.13 12:45
 */
@Component
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ListItemsImpl listItems;

    @Autowired
    private CreateOrUpdateItem createOrUpdateItem;

    /**
     * Wire all dependencies.
     */
    @PostConstruct
    public void postConstruct() {
        createOrUpdateItem.setItemRepository(itemRepository);
        listItems.setItemRepository(itemRepository);
    }

    /**
     * List items and illustrate the use of an output boundary without an adapter. While this may look awkward, imagine this use
     * case might have a conversation with the output boundary. The use case does some action and talks to the output boundary
     * in order to push some intermediate results until the operation is finished.
     * 
     * @return list of items.
     */
    public List<Item> listItems() {

        final List<Item> results = new ArrayList<>();

        listItems.listItems(new ListItemsOutput() {
            @Override
            public void onResponse(List<Item> items) {
                results.addAll(items);
            }
        });

        return results;
    }

    /**
     * A simple use case without the need of an output boundary.
     * 
     * @param item
     */
    public void createOrUpdateItem(String item) {
        createOrUpdateItem.createOrUpdateItem(item);
    }

    public Item find(String itemId) {
        return itemRepository.find(itemId);
    }
}
