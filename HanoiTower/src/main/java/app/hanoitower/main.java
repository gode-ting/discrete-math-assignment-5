/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.hanoitower;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Frederik
 */
public class main {

    static Stack<Disk> aPole = new Stack();
    static Stack<Disk> bPole = new Stack();
    static Stack<Disk> cPole = new Stack();
    
    public static void main(String[] args) {
        int amountOfDisks = 4;
        for (int i = 0; i < amountOfDisks; i++) {
            aPole.add(new Disk(4-i));
        }
        
        System.out.println("----START----");
        System.out.println("Pole A:");
        for (int i = aPole.size()-1; i > -1; i--) {
            System.out.println(aPole.get(i).size);
        }
        System.out.println("Pole B:");
        for (int i = bPole.size()-1; i > -1; i--) {
            System.out.println(bPole.get(i).size);
        }
        System.out.println("Pole C:");
        for (int i = cPole.size()-1; i > -1; i--) {
            System.out.println(cPole.get(i).size);
        }
        
        move(aPole.size(), aPole, cPole, bPole);
        
        System.out.println("----FINISH----");
        System.out.println("Pole A:");
        for (int i = aPole.size()-1; i > -1; i--) {
            System.out.println(aPole.get(i).size);
        }
        System.out.println("Pole B:");
        for (int i = bPole.size()-1; i > -1; i--) {
            System.out.println(bPole.get(i).size);
        }
        System.out.println("Pole C:");
        for (int i = cPole.size()-1; i > -1; i--) {
            System.out.println(cPole.get(i).size);
        }
        
    }
    
    public static void move(int height, Stack<Disk> from, Stack<Disk> to, Stack<Disk> aux) {
        if(height == 0){
            return;
        }
        move(height-1, from, aux, to);
        to.add(from.pop());
        move(height-1, aux,to,from);
    }

    private static class Disk {
        
        int size;
        public Disk(int size) {
            this.size = size;
        }
        
        public int getSize(){
            return size;
        }
    }
}
