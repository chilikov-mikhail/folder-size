import java.io.File;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        long size = 0;
        try {
            File folder = new File(path);
            File[] files = folder.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    size += calculateFolderSize(file.getAbsolutePath());
                } else {
                    size += file.length();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return size;
    }

    public static String humanReadableFolderSize(String path) {
        long size = calculateFolderSize(path);
        String string = "Размер папки " + path + " cоставляет ";

        String[] dimensions = {"байт", "кб", "Мб", "Гб"};
        for (int i = 0; i < dimensions.length; i++) {
            if (size / Math.pow(1024, i + 1) < 1 || i == dimensions.length - 1) {
                string += ((double) Math.round((double) size * 10 / Math.pow(1024, i))) / 10
                        + " " + dimensions[i]
                        + " (" + size + " байт)";
                break;
            }
        }
        return string;
    }
}