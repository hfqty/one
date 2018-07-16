package chapter03_stream.section04;

import entity.Album;
import entity.Track;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Utilities {


    public Set<String> findLongTracksUseForeach(List<Album> albums){
        Set<String> trackNames = new HashSet<>();
        for(Album album : albums){
            for(Track track : album.getTracks()){
                if(track.getLength()>60){
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }



    public Set<String> findLongTracksUseStream(List<Album> albums){
        Set<String> trackNames = new HashSet<>();
        albums.stream().forEach(album -> {
            album.getTracks()
                    .forEach(track -> {
                        if(track.getLength()>60){
                            String name = track.getName();
                            trackNames.add(name);
                        }
                    });
        });
        return trackNames;
    }

    public Set<String> findLongTracksUseStream02(List<Album> albums){
        Set<String> trackNames = new HashSet();
        albums.stream()
                .forEach(album -> {
                    album.getTracks().stream()
                            .filter(track -> track.getLength()>60)
                            .map(track-> track.getName())
                            .forEach(name->trackNames.add(name));
                });
        return trackNames;
    }

    public Set<String> findLongTracksUseStream03(List<Album> albums){
        Set<String> trackNames = new HashSet();
        albums.stream()
                .flatMap(album->album.getTracks().stream())
                .filter(track -> track.getLength()>60)
                .map(track -> track.getName())
                .forEach(name ->trackNames.add(name));
        return trackNames;
    }


    public Set<String> findLongTracksUseStream04(List<Album> albums){
        Set<String> trackNames = new HashSet<>();
        return albums.stream()
                .flatMap(album -> album.getTracks().stream())
                .filter(track -> track.getLength()>60)
                .map(track -> track.getName())
                .collect(Collectors.toSet());
    }


}


