package HW.day11;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task2 extends TestBase {

    @Test
    public void test() throws IOException, InterruptedException {
        //Create a File on Desktop
        String userDir = System.getProperty("user.dir");
        String separator =System.getProperty("file.separator");
        String path =userDir+separator+"file2.txt";
        System.out.println("path = " + path);

        // Create a FileWriter object
        FileWriter writer = new FileWriter(path);
        writer.close();

        //Verify that the file exists
        Thread.sleep(500);
        boolean isExist = Files.exists(Paths.get(path));
        Assert.assertTrue(isExist);
        Files.deleteIfExists(Path.of(path));

        Assert.assertFalse(Files.exists(Paths.get(path)));

    }

}
