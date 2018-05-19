package com.company;
import java.io.File;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

public class DirectoryScanner
{
    private void scan(String path)
    {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++){
            new Thread(new Stream(listOfFiles[i])).start();
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
                break;
            } catch (NullPointerException e) {
                System.out.println("Wrong path. Enter a new one by following the example: \"C:\\path\\to\\your\\directory\" ");
            }
        }
    }
}

class Stream implements Runnable
{
    long size = 0;
    File file;

    Stream(File file)
    {
        this.file = file;
    }

    @Override
    public void run()
    {
        if (file.isDirectory()){
            size = FileUtils.sizeOfDirectory(file);
            size /= 1024*1024;
            System.out.println("Name: " + file.getName() + "\t\t Size: " + size + "MB" + "\t\t Directory: true");
        } else {
            size = file.length();
            size /= 1024*1024;
            System.out.println("Name: " + file.getName() + "\t\t Size: " + size + "MB" + "\t\t Directory: false");
        }
    }
}