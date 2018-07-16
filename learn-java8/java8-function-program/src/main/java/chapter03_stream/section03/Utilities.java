package chapter03_stream.section03;

import entity.Album;
import entity.Artist;
import entity.Song;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Utilities {

    public void findRegion(){
        Album album = new Album();
        album.setIssueDate(new Date(304102931));
        album.setName("SHFS");
        album.setSongs(asList(new Song(),new Song()));
        album.setMusicians(asList(new Artist("aasdf","china"),
                new Artist("The Yu", "japan"),
                new Artist("The ere","USA"),
                new Artist("The UI","canada")));
        Set<String> origins = album.getMusicians().stream()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(artist -> artist.getNationality())
                .collect(Collectors.toSet());
        System.out.println(origins);
    }

    public static void main(String []args){
        Utilities utilities = new Utilities();
        utilities.findRegion();
    }
}
