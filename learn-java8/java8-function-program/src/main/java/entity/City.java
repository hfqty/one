package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {

    public static String names[]  = {"Beijing","Shanghai","Guangzhou","Shenzhen","Hangzhou","Chengdu","Xian","Shijiazhuang"};



    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
