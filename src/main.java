import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class main {
    public static String file_name = "example.txt";

    public static void main(String[] args) throws IOException {
    //Scanner
        boolean bo;
        //bo = true for appending , bo = false for overwriting
        bo = true;
        FileOutputStream fo = new FileOutputStream("E:\\examplea.txt" , bo);
        OutputStreamWriter os = new OutputStreamWriter(fo);
        BufferedWriter  bufferedWriter = new BufferedWriter(os);
        FileInputStream fi = new FileInputStream("E:\\examplea.txt");
        InputStreamReader is = new InputStreamReader(fi);
        BufferedReader reader = new BufferedReader(is);
        StringBuilder sb = new StringBuilder();
        bufferedWriter.write(("shivam is thevjvkj jkgkj \nwefegerb  \ngreatelllll \nllllllllllst\n"));
        bufferedWriter.flush();
        String text;
        while((text = reader.readLine()) != null) {
            sb.append(text + "\n");

        }
        System.out.println(sb);
        fo.close();
        os.close();
        bufferedWriter.close();
        fi.close();
        is.close();
        reader.close();
        int r = 3;
        while(r < 4){System.out.println("ab");
        r++;}





    }
}
