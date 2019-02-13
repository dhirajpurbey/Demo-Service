package com.stackroute.plasma.controller;

import com.stackroute.plasma.model.SearchQuery;
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

    @Autowired
    public GoogleApiSearchController(GoogleApiSearchService googleApiSearchService) {
        this.googleApiSearchService = googleApiSearchService;
    }

    @PostMapping("search")
    public ResponseEntity<?> getByName(@RequestBody SearchQuery searchQuery) {
        googleApiSearchService.search(searchQuery,0,10);

        responseEntity = new ResponseEntity<SearchQuery>(searchQuery, HttpStatus.FOUND);
        return responseEntity;
    }
}
