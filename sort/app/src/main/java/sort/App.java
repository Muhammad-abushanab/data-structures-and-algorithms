/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package sort;

import sort.classes.MovieClass;
import sort.classes.MovieSorterClass;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        MovieSorterClass movieSort = new MovieSorterClass();
        List<MovieClass> movies = new ArrayList<>();
        movies.add(new MovieClass("The Matrix", 1999, List.of("Action", "Sci-Fi")));
        movies.add(new MovieClass("Forrest Gump", 1994, List.of("Drama", "Romance")));
        movies.add(new MovieClass("A Beautiful Mind", 2001, List.of("Biography", "Drama")));
        movies.add(new MovieClass("Avatar", 2009, List.of("Action", "Adventure", "Sci-Fi")));


        List<MovieClass> sortedByYear = movieSort.sortMovieByYear(new ArrayList<>(movies));
        System.out.println("Movies sorted by year:");
        for (MovieClass movie : sortedByYear) {
            System.out.println(movie.getTitle() + " (" + movie.getYear() + ")");
        }


        List<MovieClass> sortedByTitle = movieSort.sortMovieByTitle(new ArrayList<>(movies));
        System.out.println("\nMovies sorted by title:");
        for (MovieClass movie : sortedByTitle) {
            System.out.println(movie.getTitle());
        }
    }
}
