package za.ac.cput.school_management.Helper;
import org.apache.commons.lang3.StringUtils;

public class StringHelper {
    public static boolean isEmptyOrNull(String str) { return StringUtils.isEmpty(str);}

    public static String setEmptyIfNull(String str){
        if (isEmptyOrNull(str)) return StringUtils.EMPTY;
        return str;

    }

    public static void checkStringParam(String paraName, String studentemail){
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paraName));
    }
}