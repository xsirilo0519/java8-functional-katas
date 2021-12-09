package katas;

import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        return movieLists.stream().map(movi->movi.getVideos().stream().map(
                x->x.getBoxarts().stream()
                        .reduce((acum,num)->acum.getWidth()>num.getWidth()?acum:num).get())
                .reduce((acum,num)->acum.getWidth()>num.getWidth()?acum:num).get())
                .reduce((acum,num)->acum.getWidth()>num.getWidth()?acum:num).get().getUrl();
    }

//    public static String execute() {
//        List<MovieList> movieLists = DataUtil.getMovieLists();
//        return movieLists.stream().map(movi->movi.getVideos().stream().map(
//                                x->x.getBoxarts().stream()
//                                        .reduce((acum,num)->acum.getWidth()>num.getWidth()?acum:num).get())
//                        .reduce((acum,num)->acum.getWidth()>num.getWidth()?acum:num).get())
//                .reduce((acum,num)->acum.getWidth()>num.getWidth()?acum:num).get().getUrl();
//    }
}
