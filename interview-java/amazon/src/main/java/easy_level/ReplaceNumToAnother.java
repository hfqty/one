package easy_level;

public class ReplaceNumToAnother {

    static int convert0To5Rec(int num){
        if(num == 0)
            return 0;
        int digit = num%10;

        if(digit == 0)
            digit = 5;

        return convert0To5Rec(num/10) * 10 + digit;
    }

    static int convert0To5(int num){
        if(num == 0)
            return 5;
        else
            return convert0To5Rec(num);
    }

    public static void main(String[]args){
        System.out.println(convert0To5(10120));
    }
}

