package utils;

public class ValidationUtils {
    public static boolean isValidDecimalNumber(String s){
        if(s == null){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            int a = s.charAt(i);
            if(a < 48 || a > 57){
                return false;
            }
        }
        return true;
    }

    public static boolean isValidBinaryNumber(String s){
        if(s == null){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            int a = s.charAt(i);
            if(a < 48 || a > 49){
                return false;
            }
        }
        return true;
    }

    public static boolean isValidOctalNumber(String s){
        if(s == null){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            int a = s.charAt(i);
            if(a < 48 || a > 55){
                return false;
            }
        }
        return true;
    }

    public static boolean isValidHexadecimalNumber(String s){
        if(s == null){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            int a = s.charAt(i);
            if(a < 48 || a > 57 && a < 65 || a > 70 && a < 97 || a > 102){
                return false;
            }
        }
        return true;
    }
}
