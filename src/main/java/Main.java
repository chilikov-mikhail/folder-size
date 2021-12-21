import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        for (; ; ) {
            System.out.println("Введите путь к файлу");
            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();
            if (path.equals("0")) {
                break;
            }
            System.out.println(FileUtils.humanReadableFolderSize(path));
        }
    }
}
