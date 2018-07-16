package chapter03_stream.section03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class MapDemo {

    public void useForEach(){
        List<String> collected = new ArrayList<>();
        for(String string :  asList("a","b","hi")){
             String uppercaseString = string.toUpperCase();
             collected.add(uppercaseString);
        }
        assertEquals(asList("A","B","HI"),collected);
    }

    public void useStream(){
        List<String> collected = Stream.of("a","b","hello")
                .map(string->string.toUpperCase())
                .collect(toList());
        assertEquals(asList("A","B","HELLO"),collected);
    }

    public static void main(String[]args){
        MapDemo mapDemo = new MapDemo();
        mapDemo.useForEach();
        mapDemo.useStream();
    }
}
