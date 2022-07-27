package utils;

public class ConversionUtils {

    // from decimal
    public static String fromDecimalToBinary(int decimal) {
//        StringBuilder binary = new StringBuilder();
//        int index = 0;
//
//        while (decimal > 0) {
//            binary.insert(0, decimal % 2);
//            decimal = decimal / 2;
//        }
//
//        return binary.toString();

        return Integer.toBinaryString(decimal);
    }

    public static String fromDecimalToOctal(int decimal){
        return Integer.toOctalString(decimal);
    }

    public static String fromDecimalToHexadecimal(int decimal){
        return Integer.toHexString(decimal);
    }


    // from binary
    public static String fromBinaryToDecimal(int binary) {
        int decimal = 0;
        int n = 0;
        while (true) {
            if (binary == 0) {
                break;
            }
            else {
                int temp = binary % 10;
                decimal += temp * Math.pow(2, n);
                binary = binary / 10;
                n++;
            }
        }
        return Integer.toString(decimal);
    }

    public static String fromBinaryToOctal(int binary){
        return fromDecimalToOctal(Integer.parseInt(fromBinaryToDecimal(binary)));
    }

    public static String fromBinaryToHexadecimal(int binary){
        return fromDecimalToHexadecimal(Integer.parseInt(fromBinaryToDecimal(binary)));
    }


    // from octal
    public static String fromOctalToDecimal(int octal){
        int decimal = 0;
        int n = 0;
        while(true){
            if(octal == 0){
                break;
            }
            else {
                int temp = octal % 10;
                decimal += temp * Math.pow(8, n);
                octal = octal / 10;
                n++;
            }
        }
        return Integer.toString(decimal);
    }

    public static String fromOctalToBinary(int octal){
        return fromDecimalToBinary(Integer.parseInt(fromOctalToDecimal(octal)));
    }

    public static String fromOctalToHexadecimal(int octal){
        return fromDecimalToHexadecimal(Integer.parseInt(fromOctalToDecimal(octal)));
    }


    // from hexadecimal
    public static String fromHexadecimalToDecimal(String  hex){
        String digits = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        int decimal = 0;
        for (int i = 0; i < hex.length(); i++)
        {
            char c = hex.charAt(i);
            int d = digits.indexOf(c);
            decimal = 16 * decimal + d;
        }
        return Integer.toString(decimal);
    }

    public static String fromHexadecimalToBinary(String hex){
        return fromDecimalToBinary(Integer.parseInt(fromHexadecimalToDecimal(hex)));
    }

    public static String fromHexadecimalToOctal(String hex){
        return fromDecimalToOctal(Integer.parseInt(fromHexadecimalToDecimal(hex)));
    }
}
