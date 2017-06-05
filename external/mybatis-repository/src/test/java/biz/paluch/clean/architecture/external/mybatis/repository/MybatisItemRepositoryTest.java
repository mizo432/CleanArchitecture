package biz.paluch.clean.architecture.external.mybatis.repository;

import biz.paluch.clean.architecture.applicationmodel.Item;
import biz.paluch.clean.architecture.applicationmodel.NotFoundException;
import jp.or.venuspj.utils.Lists2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 */
public class MybatisItemRepositoryTest {

    MybatisItemRepository mybatisItemRepository;

    @Before
    public void setUp(){
        ItemMapper aaaa = new ItemMapper() {
            @Override
            public Item findOne(String anItem) {
                if("aaaa".equals(anItem))
                return new Item("aaaa");
                return null;
            }

            @Override
            public List<Item> findAll() {
                List<Item> result = Lists2.newArrayList();
                result.add(new Item("aaaa"));
                return result;
            }

            @Override
            public void insert(Item anItem) {
                //nop

            }
        };
        mybatisItemRepository = new MybatisItemRepository(aaaa);

    }

    @After
    public void tearDown(){
        mybatisItemRepository = null;
    }

    @Test
    public void find01() throws Exception {
        Item actual = mybatisItemRepository.find("aaaa");
        assertThat(actual)
                .isNotNull();
    }

    @Test(expected = NotFoundException.class)
    public void find02() throws Exception {
        Item actual = mybatisItemRepository.find("NOT_FOUND");
        assertThat(actual)
                .isNotNull();
    }

    @Test
    public void findAll() throws Exception {
        List<Item> actual = mybatisItemRepository.findAll();
        assertThat(actual)
                .isNotNull();
    }

    @Test
    public void persist() throws Exception {
    }


}
