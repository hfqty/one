package chapter03_stream.section03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class FilterDemo {


    public void useForEach(){
        List<String> beginningWithNumbers = new ArrayList<>();
        for(String value  : asList("a","1abc","abc1")){
            if(isDigit(value.charAt(0))){
                beginningWithNumbers.add(value);
            }
        }
        assertEquals(asList("1abc"),beginningWithNumbers);

    }

    public void useFunction(){
        List<String> beginningWithNumber =
                Stream.of("a","1abc","abc1")
                .filter(value->isDigit(value.charAt(0)))
                .collect(Collectors.toList());
    assertEquals(asList("1abc"),beginningWithNumber);
    }


}
