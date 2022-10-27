import java.io.*;
import java.util.Scanner;

public class Variant1 {
    public static void main(String[] args) {
        try {
            File f1 = new File("C:\\Users\\User\\IdeaProjects\\laba5\\numIsh.txt");
            f1.createNewFile();
            Scanner sc = new Scanner(System.in, "cp1251");

            DataOutputStream wr = new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));
            System.out.println("kolvo chisel?");
            int count = sc.nextInt();

            System.out.println("vvedite chisla: ");
            for (int i = 0; i < count; i++)
                wr.writeInt(sc.nextInt());
            wr.flush();
            wr.close();

            File f2 = new File("C:\\Users\\User\\IdeaProjects\\laba5\\numRez.txt");
            f2.createNewFile();

            DataInputStream rd = new DataInputStream(new FileInputStream(f1.getAbsolutePath()));
            wr = new DataOutputStream(new FileOutputStream(f2.getAbsolutePath()));

            try {
                System.out.println("Chetnye chisla:");
                while (true) {
                    int number = rd.readInt();
                    wr.writeInt(number);

                    if(number % 2 ==0){
                        System.out.println((int) number);}
                }
            } catch (EOFException e) {
            }
            wr.flush();
            wr.close();
            rd.close();
        } catch (IOException e) {
            System.out.println("End of file");
        }
    }
}
