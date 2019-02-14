package com.stackroute.plasma.GoogleResponseModel;

import java.util.ArrayList;

public class GoogleResponse {
    private String kind;
    Url UrlObject;
    Queries QueriesObject;
    Context ContextObject;
    SearchInformation SearchInformationObject;
    ArrayList < Object > items = new ArrayList < Object > ();


    // Getter Methods

    public String getKind() {
        return kind;
    }

    public Url getUrl() {
        return UrlObject;
    }

    public Queries getQueries() {
        return QueriesObject;
    }

    public Context getContext() {
        return ContextObject;
    }

    public SearchInformation getSearchInformation() {
        return SearchInformationObject;
    }

    // Setter Methods

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setUrl(Url urlObject) {
        this.UrlObject = urlObject;
    }

    public void setQueries(Queries queriesObject) {
        this.QueriesObject = queriesObject;
    }

    public void setContext(Context contextObject) {
        this.ContextObject = contextObject;
    }

    public void setSearchInformation(SearchInformation searchInformationObject) {
        this.SearchInformationObject = searchInformationObject;
    }

    @Override
    public String toString() {
        return "GoogleResponse{" +
                "kind='" + kind + '\'' +
                ", UrlObject=" + UrlObject +
                ", QueriesObject=" + QueriesObject +
                ", ContextObject=" + ContextObject +
                ", SearchInformationObject=" + SearchInformationObject +
                ", items=" + items +
                '}';
    }
}

