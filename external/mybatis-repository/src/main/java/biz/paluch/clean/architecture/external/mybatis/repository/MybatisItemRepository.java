package biz.paluch.clean.architecture.external.mybatis.repository;

import biz.paluch.clean.architecture.applicationmodel.Item;
import biz.paluch.clean.architecture.applicationmodel.NotFoundException;
import biz.paluch.clean.architecture.contracts.repositories.ItemRepository;
import jp.or.venuspj.utils.Objects2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MybatisItemRepository implements ItemRepository {
    ItemMapper itemMapper;

    public MybatisItemRepository(ItemMapper anItemMapper) {
        itemMapper = anItemMapper;

    }

    @Override
    public Item find(String anItem) {
        Item item = itemMapper.findOne(anItem);
        if (Objects2.nonNull(item))
            return item;
        throw new NotFoundException("item not fund item:" + item);
    }

    @Override
    public List<Item> findAll() {
        return itemMapper.findAll();
    }

    @Override
    public void persist(Item anItem) {
        Item user = itemMapper.findOne(anItem.getItem());
        if (Objects2.nonNull(user)) {
            itemMapper.insert(anItem);

        }

    }
}
