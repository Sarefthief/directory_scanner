package com.company;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class DirectoryScanner
{
    public static void scan(String path)
    {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        /*
        long size = FileUtils.sizeOfDirectory(new File("E:/webserver"));
        size /= 1024*1024;
        System.out.println("Folder Size: " + size + " MB");
        */

    }
}
