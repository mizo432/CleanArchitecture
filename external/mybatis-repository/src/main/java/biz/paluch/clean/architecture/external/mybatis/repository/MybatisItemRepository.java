package biz.paluch.clean.architecture.external.mybatis.repository;

import biz.paluch.clean.architecture.applicationmodel.Item;
import biz.paluch.clean.architecture.contracts.repositories.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MybatisItemRepository implements ItemRepository {
    ItemMapper itemMapper;

    public MybatisItemRepository(ItemMapper anItemMapper) {
        itemMapper = anItemMapper;

    }

    @Override
    public Item find(String item) {
        return null;
    }

    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public void persist(Item item) {

    }
}
