import java.io.*;
import java.util.StringTokenizer;

public class MultilineCalculator {
    public static void main(String[]args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("/Users/mac/IdeaProjects/LapTrinhMang/src/input.txt"));
        try {
            while (true) {
                String line = in.readLine();
                calculate("+", line);
                calculate("-", line);
                calculate("*", line);
                calculate("/", line);
            }
        } catch (Exception e) {
            //Cho xu li loi
        }
        in.close();
    }

    private static void calculate(String operator, String line) {
        double result = 0;
        double x;
        double y;
        int pos = line.indexOf(operator);
        if(pos>=0){
            StringTokenizer st = new StringTokenizer(line, operator);
            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());
            switch (operator){
                case "+":
                    result = x + y;
                    break;
                case "-":
                    result = x - y;
                    break;
                case "*":
                    result = x * y;
                    break;
                case "/":
                    result = x/y;
                    break;
            }
            System.out.println(x + operator + y + "=" + result);
        }
    }
}
