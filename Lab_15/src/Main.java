import java.io.*;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Для записи состояния объекта введите save ");
        System.out.println("Для записи состояния объекта введите upload");
        while(true) {
            String vvod = in.next();
            switch (vvod) {
                case "save" -> {
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"))) {
                        System.out.println("Введите x");
                        int x = in.nextInt();
                        Calculation cal = new Calculation(x);
                        cal.action();
                        oos.writeObject(cal);
                    }
                    catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case "upload" -> {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"))) {
                        Calculation cal = (Calculation) ois.readObject();
                        System.out.println("x=" + cal.x + " y=" + cal.y);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case "exit" -> {
                    return;
                }
                default -> System.out.println("не знаю такой команды");
            }
        }
    }
}