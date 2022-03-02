package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .map(Movie::getBoxarts)
                .flatMap(Collection::stream)
                .reduce((ba1, ba2) -> Stream.of(ba1, ba2).max(Comparator.comparingInt(ba -> ba.getWidth() * ba.getHeight())).get())
                .map(BoxArt::getUrl)
                .orElse("");
    }
}
