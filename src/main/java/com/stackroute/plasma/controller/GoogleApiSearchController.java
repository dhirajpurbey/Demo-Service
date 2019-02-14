package com.stackroute.plasma.controller;

import com.stackroute.plasma.model.SearchQuery;
import com.stackroute.plasma.model.SearchResultDoc;
import com.stackroute.plasma.service.GoogleApiSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class GoogleApiSearchController {
    @Autowired
    GoogleApiSearchService googleApiSearchService;
    ResponseEntity responseEntity;

    @PostMapping("search")
    public ResponseEntity<?> getByName(@RequestBody SearchQuery searchQuery) {
        System.out.println(searchQuery.getDomain());

        return new ResponseEntity<SearchResultDoc>(googleApiSearchService.search(searchQuery, 1, 10), HttpStatus.FOUND);
    }

}
