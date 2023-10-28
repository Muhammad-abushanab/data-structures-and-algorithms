package hashTable.Classes;

import java.util.Date;

public class Movie {
    private String name;
    private Date releaseDate;
    private String movieStar;
    private Date publishDate;
    private String movieType;

    public Movie(String name, Date releaseDate, String movieStar, Date publishDate, String movieType) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.movieStar = movieStar;
        this.publishDate = publishDate;
        this.movieType = movieType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMovieStar() {
        return movieStar;
    }

    public void setMovieStar(String movieStar) {
        this.movieStar = movieStar;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    @Override
    public String toString() {
        return "\n{\n" +
                "name = " + name + "\n" +
                " releaseDate = " + releaseDate + "\n" +
                " movieStar= '" + movieStar + "'\n" +
                " publishDate = " + publishDate + "\n" +
                " movieType ='" + movieType + "'\n" +
                '}' + "\n";
    }
}

