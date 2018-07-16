package entity;

import java.util.List;

import static java.util.Arrays.asList;

public class Track {

    private String name;
    private int length;

    public Track() {
    }

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public static List<Track> getSome(int count){
        return asList(new Track("why not you ",100),
                        new Track("the only rule",201),
                        new Track("we together",300),
                        new Track("who be ",230));
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}';
    }
}
