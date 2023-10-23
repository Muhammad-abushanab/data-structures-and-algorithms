package sort.classes;

import java.util.Comparator;
import java.util.List;

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
