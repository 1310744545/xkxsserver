package org.xkx.pojo;

import javax.validation.OverridesAttribute;
import java.util.List;

public class movie {
    private int movieId;
    private String movieName;
    private String movieImg;
    private String directors;
    private String screenWriters;
    private String stars;
    private String type;
    private String score;
    private String IMDb;
    private String introduction;
    private List<movieContent> movieContents;

    public movie(int movieId, String movieName, String movieImg, String directors, String screenWriters, String stars, String type, String score, String IMDb, String introduction, List<org.xkx.pojo.movieContent> movieContents) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieImg = movieImg;
        this.directors = directors;
        this.screenWriters = screenWriters;
        this.stars = stars;
        this.type = type;
        this.score = score;
        this.IMDb = IMDb;
        this.introduction = introduction;
        this.movieContents = movieContents;
    }

    public movie(int movieId, String movieName, String movieImg, String directors, String screenWriters, String stars, String type, String score, String IMDb, String introduction) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieImg = movieImg;
        this.directors = directors;
        this.screenWriters = screenWriters;
        this.stars = stars;
        this.type = type;
        this.score = score;
        this.IMDb = IMDb;
        this.introduction = introduction;
    }

    public movie(int movieId, String movieName, String movieImg) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieImg = movieImg;
    }

    public movie() {
    }


    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieImg() {
        return movieImg;
    }

    public void setMovieImg(String movieImg) {
        this.movieImg = movieImg;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getScreenWriters() {
        return screenWriters;
    }

    public void setScreenWriters(String screenWriters) {
        this.screenWriters = screenWriters;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getIMDb() {
        return IMDb;
    }

    public void setIMDb(String IMDb) {
        this.IMDb = IMDb;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<movieContent> getMovieContents() {
        return movieContents;
    }

    public void setMovieContents(List<movieContent> movieContents) {
        this.movieContents = movieContents;
    }

    @Override
    public String toString() {
        return "movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieImg='" + movieImg + '\'' +
                ", directors='" + directors + '\'' +
                ", screenWriters='" + screenWriters + '\'' +
                ", stars='" + stars + '\'' +
                ", type='" + type + '\'' +
                ", score='" + score + '\'' +
                ", IMDb='" + IMDb + '\'' +
                ", introduction='" + introduction + '\'' +
                ", movieContent=" + movieContents +
                '}';
    }
}
