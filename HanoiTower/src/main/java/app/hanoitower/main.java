package app.hanoitower;

import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    static Stack<Disk> aPole = new Stack();
    static Stack<Disk> bPole = new Stack();
    static Stack<Disk> cPole = new Stack();
    static int amountOfDisks = 3;

    public static void main(String[] args) {

        for (int i = 0; i < amountOfDisks; i++) {
            aPole.add(new Disk(amountOfDisks - i));
        }

        System.out.println("////START////  ");
        printPoles(amountOfDisks);
        move(aPole.size(), aPole, cPole, bPole);

        System.out.println("////FINISH////  ");
        printPoles(amountOfDisks);

    }

    public static void move(int height, Stack<Disk> from, Stack<Disk> to, Stack<Disk> aux) {
        if (height == 0) {
            return;
        }
        move(height - 1, from, aux, to);
        to.add(from.pop());
        System.out.println("");
        System.out.println("////MOVE////  ");
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        printPoles(amountOfDisks);
        System.out.println("");
        move(height - 1, aux, to, from);
    }

    public static void printPoles(int size) {
        for (int i = size - 1; i > -1; i--) {
            String tmpA = "#";
            int diskSizeA = 0;
            if (aPole.size() > 0 && i < aPole.size()) {
                diskSizeA = aPole.get(i).size;
                for (int j = 0; j < diskSizeA; j++) {
                    tmpA = "X" + tmpA;
                }
                for (int j = 0; j < diskSizeA; j++) {
                    tmpA = tmpA + "X";
                }
            }
            for (int j = 0; j < size - diskSizeA; j++) {
                tmpA = "-" + tmpA;
            }
            for (int j = 0; j < size - diskSizeA; j++) {
                tmpA = tmpA + "-";
            }

            String tmpB = "#";
            int diskSizeB = 0;
            if (bPole.size() > 0 && i < bPole.size()) {
                diskSizeB = bPole.get(i).size;
                for (int j = 0; j < diskSizeB; j++) {
                    tmpB = "X" + tmpB;
                }
                for (int j = 0; j < diskSizeB; j++) {
                    tmpB = tmpB + "X";
                }
            }
            for (int j = 0; j < size - diskSizeB; j++) {
                tmpB = "-" + tmpB;
            }
            for (int j = 0; j < size - diskSizeB; j++) {
                tmpB = tmpB + "-";
            }

            String tmpC = "#";
            int diskSizeC = 0;
            if (cPole.size() > 0 && i < cPole.size()) {
                diskSizeC = cPole.get(i).size;
                for (int j = 0; j < diskSizeC; j++) {
                    tmpC = "X" + tmpC;
                }
                for (int j = 0; j < diskSizeC; j++) {
                    tmpC = tmpC + "X";
                }
            }
            for (int j = 0; j < size - diskSizeC; j++) {
                tmpC = "-" + tmpC;
            }
            for (int j = 0; j < size - diskSizeC; j++) {
                tmpC = tmpC + "-";
            }

            System.out.println(tmpA + " " + tmpB + " " + tmpC + "  ");
        }
    }

    private static class Disk {

        int size;

        public Disk(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }
    }
}
