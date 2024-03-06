package day11;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

public class C02FileExist {

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String separator =System.getProperty("file.separator");
        String path =userDir+separator+"file1";
        System.out.println("userDir = " + userDir);
        System.out.println("separator = " + separator);

        boolean isExist =Files.exists(Path.of(path));
        System.out.println("isExist = " + isExist);

    }
}
