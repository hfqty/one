package chapter03_stream.section03;

import entity.Track;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static org.junit.Assert.assertEquals;

public class MaxAndMinDemo {

    public void useForEach(){
        List<Track> tracks = asList(new Track("Bgads",123),
                                    new Track("Wosidf",131),
                                    new Track("WEREW",591));
        Track shortestTrack = tracks.get(0);
        for(Track track : tracks){
            if(track.getLength() < shortestTrack.getLength()){
                shortestTrack = track;
            }
        }
        assertEquals(tracks.get(0),shortestTrack);
    }

    public void useStream(){
        List<Track> tracks = asList(new Track("Bakai",523),
                                    new Track("Violets for Your Furs",378),
                                    new Track("Time Was",412));
        Track shortestTrack = tracks.stream().min(comparing(track->track.getLength()))
                .get();
        assertEquals(tracks.get(1),shortestTrack);
    }

    public static void main(String []args){
        MaxAndMinDemo maxAndMinDemo = new MaxAndMinDemo();
        maxAndMinDemo.useStream();
        maxAndMinDemo.useForEach();
    }
}
