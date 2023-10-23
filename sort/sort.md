## Sort comparator

## OverView
This is an implementation for sorting a movie based on title or year using java


## MovieClass
### Description
MovieClass is a Java class that represents a movie. It encapsulates information about a movie's title, release year, and a list of genres associated with it.

#### Fields
- year (int) - The year in which the movie was released.
- title (String) - The title of the movie.
- genres (List of Strings) - A list of genres associated with the movie.
#### Constructors
- MovieClass(String title, int year, List<String> genres) - A constructor for creating a MovieClass object. It initializes the movie's title, release year, and genres.
#### Methods
- getYear(): Returns the release year of the movie.
- setYear(int year): Sets the release year of the movie.
- getTitle(): Returns the title of the movie.
- setTitle(String title): Sets the title of the movie.
- getGenres(): Returns the list of genres associated with the movie.
- setGenres(List<String> genres): Sets the list of genres for the movie.
#### code 
```java
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

```
## MovieSorterClass
### Description
MovieSorterClass is a Java class that provides methods to sort a list of MovieClass objects based on their title and release year.

#### Methods
- sortMovieByTitle(List<MovieClass> movies): Sorts a list of movies alphabetically by their titles, ignoring common English articles (e.g., "A," "An," "The").
- sortMovieByYear(List<MovieClass> movies): Sorts a list of movies in descending order based on their release years.

#### code 

```java
public class MovieSorterClass {
    public List<MovieClass> sortMovieByTitle(List<MovieClass> movies){
        movies.sort((a, b) -> {
            String titleA = a.getTitle().replaceAll("^(A |An |The )", "");
            String titleB = b.getTitle().replaceAll("^(A |An |The )", "");
            return titleA.compareToIgnoreCase(titleB);
        });
        return  movies;
    }
    public List<MovieClass> sortMovieByYear(List<MovieClass> movies){
        movies.sort(Comparator.comparingInt(MovieClass::getYear).reversed());
        return movies;
    }
}
```