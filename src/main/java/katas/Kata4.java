package katas;

import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .map(MovieList::getVideos)
                .flatMap(Collection::stream)
                .flatMap(m -> m.getBoxarts().stream()
                        .map(ba -> Map.of("id", m.getId(), "title", m.getTitle(), "boxart", ba)))
                .filter(map -> {
                    BoxArt boxArt = (BoxArt) map.get("boxart");
                    return boxArt.getWidth() == 150 && boxArt.getHeight() == 200;
                })
                .collect(Collectors.toUnmodifiableList());
    }
}
