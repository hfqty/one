package easy_level;

public class CheckIf2StringCanObtained {


    static boolean isRotated(String str1,String str2){
        if(str1.length() != str2.length()){
            return false;
        }
       String str3 = str1 + str1;
        if(str3.indexOf(str2) !=-1){
            return true;
        }
        return false;
    }

    public static void main(String[]args){
        String str1 ="geeks";
        String str2 = "eksge";

        System.out.println(isRotated(str1,str2)?"可以":"不可以");
    }
}
