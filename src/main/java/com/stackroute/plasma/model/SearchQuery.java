package com.stackroute.plasma.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SearchQuery {

    private String id;
   // private Timestamp dateTime;
    private String domain;
    private String[] concepts;

}
