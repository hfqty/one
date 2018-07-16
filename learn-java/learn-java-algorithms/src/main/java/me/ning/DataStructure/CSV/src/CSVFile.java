package me.ning.DataStructure.CSV.src;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class CSVFile  {

    private ArrayList<ArrayList<String>> table;

    private ArrayList<Integer> trackList;

    private char seperator;

    private String pathCSVFile;


    public CSVFile(String path,char seperator){
        this(new File(path),seperator);
    }

    public CSVFile(File file, char seperator) {
        table = new ArrayList<ArrayList<String>>();
        trackList = new ArrayList<Integer>();
        pathCSVFile = file.getPath();
        this.seperator = seperator;
        ArrayList<String> columns = new ArrayList<>();
        if(!file.canRead() ||!file.isFile()){
            System.out.println("无法打开文件");
            System.exit(1);
        }

        try(BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()))){

            bufferedReader.lines().forEach(line -> table.add(compile(line,seperator)));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public CSVFile(char seperator){
        table = new ArrayList<ArrayList<String>>();
        trackList = new ArrayList<>();
        pathCSVFile = "";
        this.seperator = seperator;
    }


    public static ArrayList<String> compile(String row,char seperator){
        ArrayList<String> columns = new ArrayList<>();
        int state = 0;
        char ch = ' ';
        String column = "";
        int countQuotes = 0;

        for(int i = 0; i < row .length(); i++){
            ch = row.charAt(i);

            switch(state){
                case 0:
                    if(Character.isLetter(ch)||Character.isDigit(ch)){
                        state = 1;
                        column += ch;
                    }
                    else if( ch == '"'){
                        state = 2;
                        column += ch;
                    }
                    else if(Character.isWhitespace(ch)){
                        state = 0;
                    }
                    break;
                case 1:
                    if((Character.isLetter(ch)|| Character.isDigit(ch)
                    ||isPunctuation(ch)||Character.isWhitespace(ch))&&ch!=seperator){
                        state = 1;
                        column+=ch;
                    }else if(ch == seperator || ch=='\n'){
                        state = 0;
                        column = column.trim();
                        columns.add(column);
                        column = "";
                    }
                    else {
                        throw new RuntimeException("compile ： invalid character " + ch);
                    }
                    break;
                case 2:
                    if((Character.isLetter(ch)|| Character.isDigit(ch)
                    ||Character.isWhitespace(ch)||isPunctuation(ch))
                    &&(ch != '"')){
                        state = 2;
                        column+=ch;
                    }
                    else if(ch == '"'){
                        state = 3;
                        column += ch;
                    }
                    else{
                        throw new RuntimeException("compile invalid character "+ch);
                    }
                    break;
                case 3:
                    if((Character.isLetter(ch)||Character.isDigit(ch)
                    ||Character.isWhitespace(ch)||isPunctuation(ch))
                    &&(ch!='"')&&(ch != seperator)){
                        state = 2;
                        column += ch;
                    }
                    else if(ch == ','){
                        state = 0;
                        columns.add(column);
                        column = "";
                    }
                    else{
                        throw new RuntimeException("compile invalid character " + ch);
                    }
            }
        }
        columns.add(column);
        column = "";
        return columns;
    }

    private static Pattern PATTERN_PUNCTUATION = Pattern.compile("\\p{Punct}");

    public static boolean isPunctuation (char ch){
        return PATTERN_PUNCTUATION.matcher(""+ch).matches();
    }


    public String getElementString(int row,int column){
        if(row < table.size()&& column<table.get(0).size()){
            return table.get(row).get(column);
        }else{
            throw new RuntimeException("getElementString : argument out of bound.");
        }
    }

    public double getElementDouble(int row, int column){
        if(row<table.size() && column<table.get(0).size()){
            return Double.parseDouble(table.get(row).get(column));
        }
        throw new RuntimeException("getElementDouble : not double ");
    }

    public void addRow(String row){
        table.add(compile(row,seperator));
        trackList.add(table.size()-1);
    }

    public void commit(){
        String row = "";
        PrintWriter printWriter = null;
        try{
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(pathCSVFile,true)));

            for(int index : trackList){
                for(int i =0;i<table.get(index).size();i++){
                    if(i!=0){
                        row += ",";
                        row += table.get(index).get(i);
                    }else{
                        row += table.get(index).get(i);
                    }
                }
                row += "\n";
                printWriter.write(row);
                row = "";
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(printWriter != null){
                printWriter.flush();
                printWriter.close();
            }
        }
        trackList.clear();
    }

    public void commit(String path){
        String row = "";
        pathCSVFile = path;
        PrintWriter printWriter = null;

        try{
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(pathCSVFile,true)));
            for(int index : trackList){
                for(int i = 0 ; i < table.get(index).size(); i++){
                    if(i!= 0){
                        row += ",";
                        row += table.get(index).get(i);
                    }else{
                        row += table.get(index).get(i);
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(printWriter != null){
                printWriter.flush();
                printWriter.close();
            }
        }
        trackList.clear();
    }

    public void commit(File file){
        String row = "";
        pathCSVFile = file.getPath();
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file,true)));
            for( int index : trackList){
                for(int i = 0;i<table.get(index).size();i++){
                    if(i != 0){
                        row += ",";
                        row += table.get(index).get(i);
                    }else{
                        row += table.get(index).get(i);
                    }

                }
                row += "\n";
                printWriter.write(row);
                row = "";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(printWriter != null){
                printWriter.flush();
                printWriter.close();
            }
        }
        trackList.clear();
    }

    public ArrayList<String> findRow(String key){
        ArrayList<String> ans = null;
        key = key.trim();

        for(int i = 0 ; i < table.size(); i++){
            for(String item : table.get(i)){
                item = item.trim();
                if(item.equals(key)){
                    ans = table.get(i);
                    break;
                }
            }
        }
        return ans;
    }

    public boolean contains(String key){
        key = key.trim();
        for(int i = 0;i<table.size();i++){
            for(String item : table.get(i)){
                item = item.trim();
                if(item.equals(key)){
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<String> getColumn(int column){
        ArrayList<String> ans = new ArrayList<String>();
        if(column<table.get(0).size()){
            for(int i = 0; i < table.size();i++){
                ans.add(table.get(i).get(column));
            }
        }else{
            throw new RuntimeException("getColumn : column is too large");
        }
        return ans;
    }

    public ArrayList<String> getColumn(String label){
        ArrayList<String> ans = new ArrayList<String>();
        int n = table.get(0).indexOf(label);
        if(n != -1){
            for(int i = 1;i< table.size();i ++){
                ans.add(table.get(i).get(n));
            }
        }else{
            throw new RuntimeException("getColumn : label "+label + " don't exists,");
        }
        return ans;
    }

    public void removeRow(String key){
        for(int i = 0; i< table.size();i++){
            if(table.get(i) != null){
                for(String item : table.get(i)){
                    if(item.equals(key)){
                        table.set(i,null);

                        if(trackList.indexOf(i) != -1){
                            trackList.remove(i);
                        }
                    }
                }
            }
        }
        table.removeAll(Collections.singleton(null));
    }

    public void removeRow(int column){
        if(column < table.size()){
            table.set(column,null);
            table.removeAll(Collections.singleton(null));

            if(trackList.indexOf(column)!=-1){
                trackList.remove(column);
            }
        }else{
            throw new RuntimeException("removeRow : column is too large");
        }
    }

    public void updateFile(){
        String row = "";
        PrintWriter printWriter = null;
        try{
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(pathCSVFile)));

            for(int i = 0 ; i < table.size(); i++){
                for(int j = 0; j < table.get(i).size();j++){
                    if(j != 0){
                        row += ",";
                        row += table.get(i).get(j);
                    }else{
                        row += table.get(i).get(j);
                    }
                }
                row += "\n";
                row = "";
            }
            for(int index : trackList){
                for(int i= 0 ; i< table.get(index).size();i++){
                    if(i!= 0){
                        row += ",";
                        row += table.get(index).get(i);
                    }else{
                        row += table.get(index).get(i);
                    }
                }
                row += "\n";
                printWriter.write(row);
                row = "";
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(printWriter != null){
                printWriter.flush();
                printWriter.close();
            }
        }
        trackList.clear();
    }

    public int getNumberOfRows(){
        return table.size();
    }

    public void set(int row,int column,String item){
        if(row <table.size()){
            if(column<table.get(row).size()){
                table.get(row).set(column,item);
            }else{
                throw new RuntimeException("set : column is too large");
            }

        }else{
            throw new RuntimeException("set : row is too large");
        }
    }

}
