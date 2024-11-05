import java.io.*;
import java.time.LocalDateTime;

public class MyFile {
    public void crateTextFile(File file, String filePath) {
        try {
            boolean created = file.createNewFile();
            if (created) {
                System.out.println("Файл успешно создан." +
                        "\nРазмер файла: " + file.length() + ";" +
                        "\nВремя записи: " + LocalDateTime.now() + ";");
            }
        } catch (IOException e) {
            System.out.println("Ошибка создания файла.");
        }

    }

    public void addTextToTheFile(File file, String filePath, String text) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    new FileOutputStream(filePath));
            outputStreamWriter.write(text);
            outputStreamWriter.close();
        } catch (Exception e) {
            System.out.println("Ошибка записи в файл.");
        }
        System.out.println("Файл успешно обновлён." +
                "\nНовый размер файла: " + file.length() + " байт;" +
                "\nВремя Обновления: " + LocalDateTime.now() + ";");
    }

    public void findFile(String filePath) {
        File searchFile = new File(filePath);
        if (searchFile.isDirectory()) {
            System.out.println("Не указано имя искомого файла");
        } else {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                String s = bufferedReader.readLine();
                System.out.println(s);
            } catch (Exception e) {
                System.out.println("Ошибка чтения файла");
            }
        }
    }
}