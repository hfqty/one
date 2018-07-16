package easy_level;

import java.util.HashSet;

public class HaveCompule {

    public static boolean check(int arr[],int n,int x){
        for(int i = 0; i < n;i++){
            for(int j = i +1; j < n; j++ ){
                if(arr[i] * arr[j] == x){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check1(int arr[],int n,int x){
        HashSet<Integer> integerHashSet = new HashSet<>();

        if(n<2){
            return false;
        }

        for(int i = 0 ; i < n; i ++){
            if(arr[i]== x ){
               if(x== 0)
                return true;
                else
                continue;
            }

            if(x%arr[i] == 0){
                if(integerHashSet.contains(x/arr[i])){
                    return true;
                }
                integerHashSet.add(arr[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {10,30,40,10};
        int n  = 4;
        int x= 400;
        System.out.println(check(arr,n,x)?"check：是":"check：否");
        System.out.println(check1(arr,n,x)?"check1:是":"check1：否");
    }
}
