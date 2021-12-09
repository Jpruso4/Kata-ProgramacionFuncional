package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        return DataUtil.getMovieLists().stream()
                .flatMap(value -> value.getVideos().stream().flatMap( video -> video.getBoxarts().stream()))
                .reduce( (acum, actual) -> acum.getWidth() * acum.getHeight() > actual.getWidth() * actual.getHeight() ?  acum : actual )
                .get().getUrl();

    }
}
