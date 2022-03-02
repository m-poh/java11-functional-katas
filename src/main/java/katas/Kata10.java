package katas;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.ImmutableMap;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
    Goal: Create a datastructure from the given data:

    We have 2 arrays each containing lists, and videos respectively.
    Each video has a listId field indicating its parent list.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id and title.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber"
                },
                {
                    "id": 675465,
                    "title": "Fracture"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos()
    Output: the given datastructure
*/
public class Kata10 {
    public static List<Map> execute() {
        List<Map> lists = DataUtil.getLists();
        List<Map> videos = DataUtil.getVideos();

        // precondition, that no list is empty and no video points to non-existing list.
        var listStream = lists.stream()
                .collect(Collectors.groupingBy(list -> list.get("id"), TreeMap::new, Collectors.toList()));
        var videoStream = videos.stream()
                .collect(Collectors.groupingBy(video -> video.get("listId"), TreeMap::new, Collectors.toList()));

        return StreamUtils.zip(
                listStream.entrySet().stream(),
                videoStream.entrySet().stream(),
                (listGroup, videoGroup) -> {
                    var listName = listGroup.getValue().stream()
                            .findAny()
                            .map(list -> (String) list.get("name")).orElse("");
                    var listVideos = videoGroup.getValue().stream()
                            .map(video -> ImmutableMap.of("id", video.get("id"), "title", video.get("title")))
                            .collect(Collectors.toUnmodifiableList());
                    return ImmutableMap.of("name", listName, "videos", listVideos);
                }
        ).collect(Collectors.toUnmodifiableList());
    }
}
