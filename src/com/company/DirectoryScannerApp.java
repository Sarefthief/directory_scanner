package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class DirectoryScannerApp
{
    public static void main(String[] args)
    {
        DirectoryScanner dirScan = new DirectoryScanner();
        Scanner input = new Scanner(System.in);
        ArrayList<FileInfo> filesInfo;

        System.out.print("Full path to the directory: ");
        try {
            String path = input.nextLine();
            filesInfo = dirScan.scan(path);
            for (FileInfo file: filesInfo){
                System.out.println("Name: " + file.getName() + "\t\t Size: " + file.getSize() + "MB" + "\t\t Directory: " + file.getDirStatus());
            }
        } catch (NullPointerException e) {
            System.out.println("Wrong path. Enter a new one by following the example: \"C:\\path\\to\\your\\directory\" ");
        }
    }
}

