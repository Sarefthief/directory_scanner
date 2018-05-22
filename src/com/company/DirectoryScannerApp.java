package com.company;
import java.util.Scanner;

public class DirectoryScannerApp
{
    public static void main(String[] args)
    {
        DirectoryScanner dirScan = new DirectoryScanner();
        Scanner input = new Scanner(System.in);

        while(true){
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
