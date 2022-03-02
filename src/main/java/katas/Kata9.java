package katas;

import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.InterestingMoment;
import model.MovieList;
import util.DataUtil;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .map(MovieList::getVideos)
                .flatMap(Collection::stream)
                .map(movie -> {
                    var middleInterestingMomentTime = movie.getInterestingMoments().stream()
                            .map(InterestingMoment::getTime)
                            .mapToLong(Date::getTime)
                            .average().orElse(0.0);
                    var smallestBoxArtUrl = movie.getBoxarts().stream()
                            .collect(Collectors.groupingBy(ba -> ba.getWidth() * ba.getHeight())).entrySet().stream()
                            .min(Map.Entry.comparingByKey())
                            .flatMap(entry -> entry.getValue().stream().findAny())
                            .map(BoxArt::getUrl)
                            .orElse("");
                    return ImmutableMap.of(
                            "id", movie.getId(),
                            "title", movie.getTitle(),
                            "time", middleInterestingMomentTime,
                            "url", smallestBoxArtUrl);
                })
                .collect(Collectors.toUnmodifiableList());
    }
}
