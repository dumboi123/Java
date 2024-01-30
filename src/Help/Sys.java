package Help;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Sys implements Serializable {

    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_YELLOW = "\u001B[33m";

    public static final Pattern STAFF_ID = Pattern.compile("^N+V+[0-9]{3}$");
    public static final Pattern PHONE_FORMAT = Pattern.compile("^0[0-9]{10}$");
    public static final Pattern CCCD_FORMAT = Pattern.compile("^0[0-9]{12}$");



    // Save file tham số obj là obj cần save
 
//Ham kiem tra ten 
public class NameChecker {
    public static final String NAME_REGEX =
            "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";

    
    //Ham so sanh kieu dinh dang voi ten
    public static boolean check_Name(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        if(matcher.matches()){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Ten khong hop le!", "Loi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
}

    
    //Ham kiem tra sdt
    public static boolean check_sdt(String sdt){
         String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";

        // Kiem tra dinh dang
        boolean kt = sdt.matches(reg);

        if (kt == true) {
           return true;
        } else {
            JOptionPane.showMessageDialog(null, "So Dien Thoai khong hop le!", "Loi", JOptionPane.ERROR_MESSAGE);

            return false;
        }
    }
    
    //Ham kiem tra gmail
    public static boolean check_gmail2(String gmail) {
        String regex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
        if (Pattern.matches(regex, gmail)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Dia chi gmail khong hop le!", "Loi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean Check_email(JTextField txtEmailTv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
