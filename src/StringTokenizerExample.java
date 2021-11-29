import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[]ags){
        String text = "12 12 1245 1259203 234 238 23 0 2";
        sort(text);
       // System.out.println("Tong la: " + tong);
        //System.out.println("Danh sach sap xep:" + arrayList);
    }
    public static ArrayList<Long> sort(String text){
        StringTokenizer stringTokenizer = new StringTokenizer(text," ");
        int i = 1;
        long tong = 0;
        ArrayList<Long> arrayList = new ArrayList<Long>();
        while (stringTokenizer.hasMoreTokens()){
            String token = stringTokenizer.nextToken();
            long value = Long.parseLong(token);
            arrayList.add(value);
            System.out.println("Gia tri " + i +":" + value);
            tong += value;
            i++;
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
