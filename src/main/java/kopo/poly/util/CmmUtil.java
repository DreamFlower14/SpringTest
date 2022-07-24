package kopo.poly.util;

public class CmmUtil {
    public static String nvl(String str, String chg_shr) {
        String res;

        if (str == null) {
            res = chg_shr;
        } else if (str.equals("")){
            res = chg_shr;
        } else {
            res = str;
        }
        return res;
    }

    public static String nvl(String str){
        return nvl(str,"");
    }
}
