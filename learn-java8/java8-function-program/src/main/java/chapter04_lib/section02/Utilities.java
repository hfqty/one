package chapter04_lib.section02;

import entity.Album;
import entity.Track;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.hibernate.criterion.Subqueries.geSome;

public class Utilities {


    public static void printTrackLengthStatistics(Album album){
        IntSummaryStatistics trackLengthStats
                = album.getTracks()
                .stream()
                .mapToInt(track->track.getLength())
                .summaryStatistics();
        System.out.printf("Max : %d,Min: %d , Ave : %f , Sum : %d",
                            trackLengthStats.getMax(),
                            trackLengthStats.getMin(),
                            trackLengthStats.getAverage(),
                            trackLengthStats.getSum());
    }


    public static void hasFaxing(Album album1){
        Predicate<Album> albumPredicate = album -> album.getTracks().size()>0;

        boolean has = albumPredicate.test(album1);
        System.out.println(has);
    }

    public static void showInfo(Album album){
        Consumer<Album> albumConsumer = album1-> System.out.println(album1.getTracks());
        albumConsumer.accept(album);
    }

    public static List<String> getTracksName(Album album){
        Function<Album,List<String>> tracksNameFunction = album1-> album1.getTracks()
                .stream()
                .map(track -> track.getName())
                .collect(Collectors.toList());
        List<String> tracksName = tracksNameFunction.apply(album);
        System.out.println(tracksName);
        return tracksName;
    }

    public static List<Album> getSome(){
        Supplier<List<Album>> albumSupplier = ()->Album.getSome();
        List<Album> albums =  albumSupplier.get();
        System.out.println(albums);
        return albums;
    }


    public static void main(String []args){
        Album album = new Album();
        album.setTracks(Track.getSome(10));
        hasFaxing(album);
        showInfo(album);
        getTracksName(album);
        getSome();
    }


}
