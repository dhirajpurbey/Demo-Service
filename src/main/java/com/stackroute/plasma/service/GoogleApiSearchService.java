package com.stackroute.plasma.service;

import com.stackroute.plasma.GoogleResponseModel.GoogleResponse;
import com.stackroute.plasma.model.SearchQuery;
import com.stackroute.plasma.model.SearchResultDoc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class GoogleApiSearchService {

    @Value("${application.google.apikey}")
    private String apiKey;

    @Value("${application.google.customsearchenginekey}")
    private String customSearchEngineKey;
    // base url for the search query

    @Value("${application.google.searchURL}")
    private String searchURL;

    public SearchResultDoc search(SearchQuery searchQuery, int start, int numOfResults) {


        System.out.println("++++++++++++++++++++++++++++++++++service method call");
        //  System.out.println(apiKey);
        //  System.out.println(customSearchEngineKey);
        // System.out.println(searchURL);
        try {

            String toSearch = searchURL + "key=" + apiKey + "&cx="
                    + customSearchEngineKey + "&q=";

         toSearch += searchQuery.getDomain()+" "+searchQuery.getConcepts();

            toSearch += "&alt=json";

            toSearch += "&start=" + start;

            toSearch += "&num=" + numOfResults;

            System.out.println(toSearch);

            URL url = new URL(toSearch);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
           String result= buffer.toString();
          // System.out.println(result);
            com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
            objectMapper.disable(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            GoogleResponse googleResponse = objectMapper.readValue(result, GoogleResponse.class);
            System.out.println("googleResponse:" + googleResponse.getUrl().getTemplate());

            SearchResultDoc searchResultDoc  = new SearchResultDoc();

            searchResultDoc.setDomain(searchQuery.getDomain());
            searchResultDoc.setConcepts(searchQuery.getConcepts());


            return searchResultDoc;

        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
   }
}
