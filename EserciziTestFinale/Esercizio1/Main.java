package Esercizio1;

import java.util.ArrayList;
import java.util.Scanner;

// Classe base Veicolo
abstract class Veicolo {
    private String marca;
    private int anno;

    public Veicolo(String marca, int anno) {
        this.marca = marca;
        this.anno = anno;
    }

    // Getter e setter
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    // Metodo astratto da sovrascrivere
    public abstract String dettagli();
}

// Sottoclasse Auto
class Auto extends Veicolo {
    private int numeroPorte;

    public Auto(String marca, int anno, int porte) {
        super(marca, anno);
        this.numeroPorte = porte;
    }

    public int getNumeroPorte() {
        return numeroPorte;
    }

    public void setNumeroPorte(int p) {
        this.numeroPorte = p;
    }

    @Override
    public String dettagli() {
        return "Auto – Marca: " + getMarca()
                + ", Anno: " + getAnno()
                + ", Porte: " + numeroPorte;
    }

}

// Sottoclasse Moto
class Moto extends Veicolo {
    private boolean haMarce;

    public Moto(String marca, int anno, boolean haMarce) {
        super(marca, anno);
        this.haMarce = haMarce;
    }

    public boolean isHaMarce() {
        return haMarce;
    }

    public void setHaMarce(boolean ha) {
        this.haMarce = ha;
    }

    @Override
    public String dettagli() {
        return "Moto – Marca: " + getMarca()
                + ", Anno: " + getAnno()
                + ", " + (haMarce ? "Con" : "Senza")
                + " marce";
    }

}

public class Main {
    public static void main(String[] args) {
        ArrayList<Veicolo> garage = new ArrayList<>();
        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        int scelta;

        do {
            System.out.println("--- MENU VEICOLI ---");
            System.out.println("1) Aggiungi Auto");
            System.out.println("2) Aggiungi Moto");
            System.out.println("3) Mostra tutti i veicoli");
            System.out.println("0) Esci");
            System.out.print("Scelta: ");
            scelta = scannerNum.nextInt();

            switch (scelta) {
                case 1:
                    System.out.print("Marca Auto: ");
                    String ma = scannerStr.nextLine();
                    System.out.print("Anno: ");
                    int aa = scannerNum.nextInt();
                    scannerNum.nextLine();   
                    System.out.print("Numero porte: ");
                    int np = scannerNum.nextInt();
                    garage.add(new Auto(ma, aa, np));
                    System.out.println("Auto aggiunta!");
                    break;

                case 2:
                    System.out.print("Marca Moto: ");
                    String mm = scannerStr.nextLine();
                    System.out.print("Anno: ");
                    int am = scannerNum.nextInt();
                    scannerNum.nextLine();   
                    System.out.print("Ha marce? (true/false): ");
                    boolean hm = scannerStr.nextBoolean();
                    garage.add(new Moto(mm, am, hm));
                    System.out.println("Moto aggiunta!");
                    break;

                case 3:
                    System.out.println("--- Dettagli Veicoli ---");
                    for (Veicolo v : garage) {
                        System.out.println(v.dettagli());
                    }
                    break;

                case 0:
                    System.out.println("Arrivederci!");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);

        scannerStr.close();
        scannerNum.close();
    }
}
