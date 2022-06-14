package za.ac.cput.school_management.helper;

public class StringHelper {
    public static boolean isNullorEmpty(String m) {
        return (m == null || m.equals("") || m.isEmpty());
    }
}
