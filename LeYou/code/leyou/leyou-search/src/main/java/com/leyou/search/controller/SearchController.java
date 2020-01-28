package com.leyou.search.controller;

import com.leyou.search.pojo.SearchRequest;
import com.leyou.search.pojo.SearchResult;
import com.leyou.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author hhl
 * @date - 20:36
 */
@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;


    @PostMapping("/page")
    public ResponseEntity<SearchResult> search(@RequestBody SearchRequest searchRequest){
        SearchResult result =  this.searchService.search(searchRequest);
        if (result == null || CollectionUtils.isEmpty(result.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
}
