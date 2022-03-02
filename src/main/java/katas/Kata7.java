package katas;

import com.codepoetics.protonpack.collectors.CollectorUtils;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .map(MovieList::getVideos)
                .flatMap(Collection::stream)
                .map(movie -> {
                    var smallestBoxArtUrl = movie.getBoxarts().stream()
                            .collect(CollectorUtils.minBy(boxArt -> boxArt.getWidth() * boxArt.getHeight()))
                            .map(BoxArt::getUrl)
                            .orElse("");
                    return ImmutableMap.of("id", movie.getId(), "title", movie.getTitle(), "boxart", smallestBoxArtUrl);
                })
                .collect(Collectors.toUnmodifiableList());
    }
}
