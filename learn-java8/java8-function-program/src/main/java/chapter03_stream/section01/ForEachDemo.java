package chapter03_stream.section01;

import entity.Artist;

import java.util.Iterator;
import java.util.List;

import static entity.Artist.artists;

public class ForEachDemo {

    public void useForEach(List<Artist> artists){
        int count = 0;
        for(Artist artist : artists){
            if(artist.isFrom("Beijing")){
                count++;
            }
        }
        System.out.println("count = " + count);

    }

    public void useIterator(List<Artist> artists){
        int count = 0 ;
        Iterator<Artist> iterator = artists.iterator();
        while(iterator.hasNext()){
            Artist artist = iterator.next();
            if(artist.isFrom("Beijing")){
                count++;
            }
        }
        System.out.println("count = " + count);
    }

    public void useStream(List<Artist> artists){
        long count = artists.stream()
                .filter(artist -> artist.isFrom("Beijing"))
                .count();
        System.out.println("count = " + count);
    }

    public static void main(String []args){
        ForEachDemo forEachDemo = new ForEachDemo();
        forEachDemo.useForEach(artists());
        forEachDemo.useIterator(artists());
        forEachDemo.useStream(artists());
    }
}
