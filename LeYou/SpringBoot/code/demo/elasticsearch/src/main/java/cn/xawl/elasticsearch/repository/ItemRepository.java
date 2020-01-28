package cn.xawl.elasticsearch.repository;

import cn.xawl.elasticsearch.pojo.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author hhl
 * @date - 19:23
 */

public interface ItemRepository extends ElasticsearchRepository<Item,Long>{

    List<Item> findByTitle(String title);

    List<Item> findByPriceBetween(Double d1,Double d2);

}

