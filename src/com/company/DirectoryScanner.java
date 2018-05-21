package com.company;
import java.io.File;
import java.util.Scanner;

public class DirectoryScanner
{
    private void scan(String path)
    {
        File folder = new File(path);
        File[] listOfFiles  = folder.listFiles();
        DirectoryThread[] myThreads = new DirectoryThread[listOfFiles.length];

        for (int i = 0; i < listOfFiles.length; i++){
            myThreads[i] = new DirectoryThread(listOfFiles[i]);
        }
        for (DirectoryThread thread: myThreads){
            try {
                thread.t.join();
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted");
            }
        }
        for (DirectoryThread thread: myThreads){
            System.out.println(thread.result);
        }
    }

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
