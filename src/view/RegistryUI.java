package view;

import models.Type;

import java.util.Scanner;

public class RegistryUI implements InputUI{
    private Scanner scan = new Scanner(System.in);
    public String getUserStr() {
        return scan.nextLine();
    }


    @Override
    public char getAction() {
        return 0;
    }
    @Override
    public void closeScanner() {
        scan.close();
    }
}
