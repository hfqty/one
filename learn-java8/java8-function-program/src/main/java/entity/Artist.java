package entity;

import java.util.ArrayList;
import java.util.List;

import static entity.City.names;

public class Artist {




    private int id;

    private String name;

    private String city;

    private String nationality;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Artist() {
    }

    public Artist(String name,String nationality){
        this.name = name;
        this.nationality = nationality;
    }


    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean isFrom(String city){
        if(this.city == null){
            return false;
        }
        if(city == null){
            return false;
        }
        return city.equals(this.city);
    }

    public static List<Artist> artists(){
        List<Artist> artists  =  new ArrayList<>();
        for(int i =0 ; i< 100;i++){
            Artist artist = new Artist();
            artist.setId(i+1);
            artist.setName("name"+artist.getId());
            artist.setCity(names[(int) (Math.random()*names.length-1)]);
            artists.add(artist);
        }
        return artists;
    }
}
