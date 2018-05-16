package com.company;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class DirectoryScanner
{
    public void scan(String path)
    {
        long size = 0;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++){
            if (listOfFiles[i].isDirectory()){
                size = FileUtils.sizeOfDirectory(listOfFiles[i]);
                size /= 1024*1024;
                System.out.println("Folder Size: " + size + " MB");
            }
        }
}
}
