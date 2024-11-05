import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyFile myFile = new MyFile();
        try {
            while (true) {
                System.out.println("Ведите ВЫХОД для завершения");
                System.out.println("Ведите 1 - для создания файла;\n2 - для поиска информации в файле");

                Scanner scanner = new Scanner(System.in);
                String inputInformation = scanner.nextLine();
                if (inputInformation.equalsIgnoreCase("Выход")) {
                    break;
                } else {
                    switch (inputInformation) {
                        case "1" -> {
                            System.out.println("Ведите имя создаваемого файла и путь через запятую");
                            String[] strings = scanner.nextLine().split(",");
                            String s1 = strings[0] + ".txt";
                            String s2 = strings[1];
                            String filePath = s2 + "\\" + s1;
                            File file = new File(filePath);
                            myFile.crateTextFile(file, file.getPath());
                            System.out.println("Ведите текст, который хотите записать в файл");
                            myFile.addTextToTheFile(file, file.getPath(), scanner.nextLine());
                        }

                        case "2" -> {
                            System.out.println("Ведите путь искомого файла");
                            String string = scanner.nextLine();
                            myFile.findFile(string);
                        }
                        default -> {
                            System.out.println("Ошибка чтения строки");
                            continue;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения строки");
        }
    }
}
