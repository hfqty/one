package entity;

import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

public class Album {

    private String name;

    private Date IssueDate;

    private List<Song> songs;

    private List<Artist> musicians;

    private List<Track> tracks;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(Date issueDate) {
        IssueDate = issueDate;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Artist> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Artist> musicians) {
        this.musicians = musicians;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public Album(String name){
        this.name = name;
    }
    public Album(){

    }



    public static List<Album> getSome(){
        return asList(new Album("high"),new Album("go with someone"),new Album("how are you"));
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", IssueDate=" + IssueDate +
                ", songs=" + songs +
                ", musicians=" + musicians +
                ", tracks=" + tracks +
                '}';
    }
}
