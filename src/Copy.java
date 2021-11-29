import java.io.*;
public class Copy {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/input.txt");
        File outputFile = new File("output.txt");
        FileReader in = new FileReader(inputFile);
        FileWriter out = new FileWriter(outputFile);

        BufferedReader bfReader = new BufferedReader(in);

        BufferedWriter bfWriter = new BufferedWriter(out);

        String inputLine;

        while ((inputLine = bfReader.readLine()) != null)
            bfWriter.write(inputLine+"\n");

        bfReader.close();
        bfWriter.close();
        in.close();
        out.close();
    }
}