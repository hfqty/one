package chapter03_stream.section02;

import entity.Artist;

import java.util.List;

import static entity.Artist.artists;

public class FilterDemo {


    public static void main(String []args){
        FilterDemo filterDemo =  new FilterDemo();
        filterDemo.filterTest03(artists());
    }

    public void filterTest01(List<Artist> artists){

        artists.stream()
                .filter(artist -> artist.isFrom("Beijing"));

    }

    public void filterTest02(List<Artist> artists){
        artists.stream()
                .filter(artist ->{
                    System.out.println(artist.getName());
                    return artist.isFrom("Beijing");
                });
    }

    public void filterTest03(List<Artist> artists){
        long count  = artists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("Beijing");
                        }
                ).count();
        System.out.println("count ="+ count);
    }


}
