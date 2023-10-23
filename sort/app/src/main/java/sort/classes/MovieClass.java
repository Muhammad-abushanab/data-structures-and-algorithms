package sort.classes;

import java.util.List;

public class MovieClass {
    private int year;
    private String title;
    private List<String> genres;

    public MovieClass(String title,int year,List<String> genres){
        this.genres = genres;
        this.title = title;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getGeners() {
        return genres;
    }

    public void setGeners(List<String> genres) {
        this.genres = genres;
    }
}
