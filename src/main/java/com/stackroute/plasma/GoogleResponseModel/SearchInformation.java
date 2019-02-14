package com.stackroute.plasma.GoogleResponseModel;

public class SearchInformation {
    private float searchTime;
    private String formattedSearchTime;
    private String totalResults;
    private String formattedTotalResults;


    // Getter Methods

    public float getSearchTime() {
        return searchTime;
    }

    public String getFormattedSearchTime() {
        return formattedSearchTime;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public String getFormattedTotalResults() {
        return formattedTotalResults;
    }

    // Setter Methods

    public void setSearchTime(float searchTime) {
        this.searchTime = searchTime;
    }

    public void setFormattedSearchTime(String formattedSearchTime) {
        this.formattedSearchTime = formattedSearchTime;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public void setFormattedTotalResults(String formattedTotalResults) {
        this.formattedTotalResults = formattedTotalResults;
    }

    @Override
    public String toString() {
        return "SearchInformation{" +
                "searchTime=" + searchTime +
                ", formattedSearchTime='" + formattedSearchTime + '\'' +
                ", totalResults='" + totalResults + '\'' +
                ", formattedTotalResults='" + formattedTotalResults + '\'' +
                '}';
    }
}
