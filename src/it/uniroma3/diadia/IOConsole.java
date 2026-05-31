package it.uniroma3.diadia;

public class IOConsole implements IO {

    private final java.util.Scanner scannerDiLinee;

    public IOConsole(java.util.Scanner scanner) {
        this.scannerDiLinee = scanner;
    }

    @Override
    public void mostraMessaggio(String msg) {
        System.out.println(msg);
    }

    @Override
    public String leggiRiga() {
        return scannerDiLinee.nextLine();
    }
}