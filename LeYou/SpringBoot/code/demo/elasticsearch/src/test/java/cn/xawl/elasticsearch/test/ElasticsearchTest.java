package cn.xawl.elasticsearch.test;

import cn.xawl.elasticsearch.pojo.Item;
import cn.xawl.elasticsearch.repository.ItemRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.metrics.avg.InternalAvg;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.search.suggest.SortBy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author hhl
 * @date - 21:41
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ElasticsearchTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testIndex(){
        this.elasticsearchTemplate.createIndex(Item.class); //创建索引
        this.elasticsearchTemplate.putMapping(Item.class); //添加映射
    }

    @Test
    public void indexList() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1L, "小米手机7", "手机", "小米", 3299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(2L, "坚果手机R1", "手机", "锤子", 3699.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(3L, "华为META10", "手机", "华为", 4499.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(4L, "小米Mix2S", "手机", "小米", 4299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(5L, "荣耀V10", "手机", "华为", 2799.00, "http://image.leyou.com/13123.jpg"));
        // 接收对象集合，实现批量新增
        itemRepository.saveAll(list);
    }

    @Test
    public void testCreate(){
        /*Item item = new Item(1L,"小米手机7","手机","小米",2799.00,"http://image.leyou.com/13123.jpg");
        this.itemRepository.save(item);*/
        List<Item> list = new ArrayList<>();
        list.add(new Item(2L, "坚果手机R1", " 手机", "锤子", 3699.00, "http://image.leyou.com/123.jpg"));
        list.add(new Item(3L, "华为META10", " 手机", "华为", 4499.00, "http://image.leyou.com/3.jpg"));
        this.itemRepository.saveAll(list);
    }

    @Test
    public void testFind(){
        /*Optional<Item> item = this.itemRepository.findById(1l);
        System.out.println(item.get());*/
        Iterable<Item> items = this.itemRepository.findAll(Sort.by("price").descending());
        items.forEach(System.out::println);
    }

    @Test
    public void findByTitle(){
        //List<Item> items = this.itemRepository.findByTitle("手机");
        List<Item> items = this.itemRepository.findByPriceBetween(2000d, 3000d);
        items.forEach(System.out::println);
    }

    @Test
    public void testQuery(){
        //通过查询构建器构建查询条件
        MatchQueryBuilder queryBuild = QueryBuilders.matchQuery("title", "手机");
        //执行查询，获取结果集
        Iterable<Item> items = this.itemRepository.search(queryBuild);
        items.forEach(System.out::println);
    }

    @Test
    public void testNativeQuery(){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "小米"));
        // 执行搜索，获取结果
        Page<Item> items = this.itemRepository.search(queryBuilder.build());
        // 打印总条数
        System.out.println(items.getTotalElements());
        // 打印总页数
        System.out.println(items.getTotalPages());
        items.forEach(System.out::println);
    }

    @Test
    public void testPage(){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("category", "手机"));
        //添加分页条件，页码从零开始
        //queryBuilder.withPageable(PageRequest.of(1,2));

        //根据价格降序排序
        queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));

        // 执行搜索，获取结果
        Page<Item> items = this.itemRepository.search(queryBuilder.build());
        // 打印总条数
        System.out.println("总条数" + items.getTotalElements());
        // 打印总页数
        System.out.println("总页数" + items.getTotalPages());
        //打印当前页
        System.out.println("当前页" + items.getNumber());
        //打印每页大小
        System.out.println("每页大小" + items.getSize());

        items.forEach(System.out::println);
    }

    @Test
    public void testAggregation(){
        //初始化自定义查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //添加聚合
        queryBuilder.addAggregation(AggregationBuilders.terms("brandAgg").field("brand"));
        //添加结果集过滤，不包括任何字段
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{},null));

        //执行聚合查询
        AggregatedPage<Item> itemPage = (AggregatedPage<Item>)this.itemRepository.search(queryBuilder.build());

        //解析聚合结果集，根据聚合的类型以及字段要进行强转，brand是字符串类型，聚合类型是词条聚合，brandAgg：通过聚合名称获取聚合对象
        StringTerms brandAgg =(StringTerms) itemPage.getAggregation("brandAgg");
        //通过getBuckets获取桶的集合
        List<StringTerms.Bucket> buckets = brandAgg.getBuckets();
        //遍历输出
        buckets.forEach(bucket -> {
            System.out.println(bucket.getKeyAsString());
            System.out.println(bucket.getDocCount() + "条");
        });
    }


    @Test
    public void testSubAggregation(){
        //初始化自定义查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //添加聚合
        queryBuilder.addAggregation(AggregationBuilders.terms("brandAgg").field("brand")
                .subAggregation(AggregationBuilders.avg("price_avg").field("price"))  //该处.field要跟在名字后面
        );
        //添加结果集过滤，不包括任何字段
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{},null));

        //执行聚合查询
        AggregatedPage<Item> itemPage = (AggregatedPage<Item>)this.itemRepository.search(queryBuilder.build());

        //解析聚合结果集，根据聚合的类型以及字段要进行强转，brand是字符串类型，聚合类型是词条聚合，brandAgg：通过聚合名称获取聚合对象
        StringTerms brandAgg =(StringTerms) itemPage.getAggregation("brandAgg");
        //通过getBuckets获取桶的集合
        List<StringTerms.Bucket> buckets = brandAgg.getBuckets();
        //遍历输出
        buckets.forEach(bucket -> {
            System.out.println(bucket.getKeyAsString());
            System.out.println(bucket.getDocCount() + "条");
            //获取字聚合的map集合，key：聚合名称；value：对应的子聚合对象
            Map<String, Aggregation> stringAggregationMap = bucket.getAggregations().asMap();
            InternalAvg price_avg = (InternalAvg)stringAggregationMap.get("price_avg");
            System.out.println("平均售价" + price_avg.getValue());
        });
    }




}
