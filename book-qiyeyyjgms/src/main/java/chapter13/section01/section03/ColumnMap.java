package chapter13.section01.section03;

import java.lang.reflect.Field;

public class ColumnMap {

    private String columnName;
    private String fieldName;
    private Field field;
    private DataMap dataMap;

    public ColumnMap(String columnName,String fieldName,DataMap dataMap){
        this.columnName = columnName;
        this.fieldName = fieldName;
        this.dataMap = dataMap;
        initField();
    }

    private void initField(){
        try{
            field = dataMap.getClass().getDeclaredField("");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
