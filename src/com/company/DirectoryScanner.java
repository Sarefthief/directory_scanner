package com.company;
import java.io.File;
import java.util.Scanner;
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
                System.out.println("Name: " + listOfFiles[i].getName() + "\t\t Size: " + size + "MB" + "\t\t Directory: true");
            } else {
                size = listOfFiles[i].length();
                size /= 1024*1024;
                System.out.println("Name: " + listOfFiles[i].getName() + "\t\t Size: " + size + "MB" + "\t\t Directory: false");
            }
        }
    }

    public static void main(String[] args)
    {
        DirectoryScanner dirScan = new DirectoryScanner();
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.print("Full path to the directory: ");
            try {
                String path = input.nextLine();
                dirScan.scan(path);
            } catch (NullPointerException e) {
                System.out.println("Wrong path. Enter a new one by following the example: \"C:\\path\\to\\your\\directory\" ");
            }
        }
    }
}
