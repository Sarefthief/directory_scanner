package com.company;
import java.util.Scanner;
import java.io.File;


public class Main
{

    public static void main(String[] args)
    {
        DirectoryScanner dirScan = new DirectoryScanner();
        Scanner directory = new Scanner(System.in);
        System.out.print("Full path to the directory: ");
        String path = directory.nextLine();
        System.out.println(path);
    }
}
