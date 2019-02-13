package com.stackroute.plasma.service;

import com.stackroute.plasma.model.SearchQuery;
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

    public  String search(SearchQuery searchQuery, int start, int numOfResults) {
        try {

            String toSearch = searchURL + "key=" + apiKey + "&cx="
                    + customSearchEngineKey + "&q=";

            toSearch += searchQuery.getDomain()+" "+searchQuery.getConcepts();

            toSearch += "&alt=json";

            toSearch += "&start=" + start;

            toSearch += "&num=" + numOfResults;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
