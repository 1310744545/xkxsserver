package org.xkx.pojo;

public class movieContent {
    private int movieId;
    private int contentId;
    private String contentUrl;

    public movieContent(int movieId, int contentId, String contentUrl) {
        this.movieId = movieId;
        this.contentId = contentId;
        this.contentUrl = contentUrl;
    }

    public movieContent() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    @Override
    public String toString() {
        return "movieContent{" +
                "movieId=" + movieId +
                ", contentId=" + contentId +
                ", contentUrl='" + contentUrl + '\'' +
                '}';
    }
}
