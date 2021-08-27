package com.sparta.myselectshop.controller;

import com.sparta.myselectshop.dto.ItemDto;
import com.sparta.myselectshop.util.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SearchRequestController {

    private final NaverShopSearch naverShopSearch;

    // /api/search?query=~~
    @GetMapping("/api/search")
    public List<ItemDto> getItems(@RequestParam String query){
        String result = naverShopSearch.search(query);
        return naverShopSearch.fromJSONtoItems(result);
    }
}
