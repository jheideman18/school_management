package za.ac.cput.school_management.util;

import org.apache.commons.lang3.StringUtils;

public class Stringhelper{

    public static boolean isEmptyorNull(String str) {
        return StringUtils.isEmpty(str);
    }

    public static String setEmptyIfNull(String str){
        if (isEmptyorNull(str)) return StringUtils.EMPTY;
        return str;
    }

     public static void checkStringParam(String paramName, String paramValue){
        if(isEmptyorNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramValue));
     }


}
