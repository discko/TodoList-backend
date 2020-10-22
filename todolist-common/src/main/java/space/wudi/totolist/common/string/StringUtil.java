package space.wudi.totolist.common.string;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtil {

    public static String randmoString(int length, boolean number, boolean uppercase, boolean lowercase, boolean specialchars){
        String NUMBERS = "0123456789";
        String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
        String SPECIALCHAR = "!@#$%^&*()-=_+,./<>?;':\"[]\\{}|";

        StringBuilder sb=new StringBuilder();
        if(number){
            sb.append(NUMBERS);
        }
        if(uppercase){
            sb.append(UPPERCASE);
        }
        if(lowercase){
            sb.append(LOWERCASE);
        }
        if(specialchars){
            sb.append(SPECIALCHAR);
        }
        if(sb.length()==0){
            sb.append(NUMBERS).append(LOWERCASE).append(UPPERCASE);
        }

        StringBuilder password=new StringBuilder();
        if(length<0){
            length=8;
            System.err.println("RandomString: ask for length="+length+", too short. set it to default="+8);
        }
        int total=sb.length();
        for(int i=0;i<length;i++){
            password.append(sb.charAt((int)(Math.random()*total)));
        }
        return password.toString();
    }

    public static String stringToMd5String(String s){
        try {
            MessageDigest md= MessageDigest.getInstance("MD5");
            byte[] md5Digits=md.digest(s.getBytes(StandardCharsets.UTF_8));
            StringBuilder buf = new StringBuilder();
            for (byte md5Digit : md5Digits) {
                int tmp = md5Digit;
                if (tmp < 0)
                    tmp += 256;
                if (tmp < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(tmp));
            }

            return buf.toString();
        } catch (NoSuchAlgorithmException ignored) {

        }
        return "";
    }
}
