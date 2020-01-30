/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TresEnRaya;

import java.util.Scanner;

/**
 *
 * @author jazzviji
 */
public class TresEnRaya {
    private char [][] tablero;
    
    TresEnRaya(){
        tablero = new char[3][3];
        for(int i=0; i<tablero.length; ++i){
            for(int j=0; j<tablero[i].length; ++j){
                tablero[i][j]=' ';
            }
        }
    }
    
    public void ponerFicha(char ficha){
        if(charValido(ficha)){
            Scanner sc = new Scanner (System.in);
            int f,c;
            do{
                System.out.print("Fila: ");
                f=sc.nextInt();
                System.out.print("Columna: ");
                c=sc.nextInt();
            }while(!posValida(f,c));
            tablero[f][c]=ficha;
        }
    }
    
    public boolean comprobarVictoria(){
        if(comprobarHorizontal()){
            return true;
        }
        if(comprobarVertical()){
            return true;
        }
        if(comprobarDiagonal()){
            return true;
        }
        return false;
    }
    
    public boolean comprobarVictoria(char ficha){
        if(comprobarHorizontal(ficha)){
            return true;
        }
        if(comprobarVertical(ficha)){
            return true;
        }
        if(comprobarDiagonal(ficha)){
            return true;
        }
        return false;
    }
    
    public void mostrar(){
        for(int i=0; i<tablero.length; ++i){
            
            for(int j=0; j<tablero[i].length; ++j){
                System.out.print(" | "+tablero[i][j]);
            }
            System.out.println(" |");
        }
    }
    
    public int getTamanyo(){
        return tablero.length;
    }
    
    
    public boolean tableroLleno() {
        for(int i=0; i<tablero.length; ++i){
            for(int j=0; j<tablero[i].length; ++j){
                if(!charValido(tablero[i][j])){
                    return false;
                }
            }
        }
        return true;
    }
    
    
    /* METODOS PRIVADOS */

    private boolean posValida(int f, int c) {
        if(f>=0 && f<tablero.length && c>=0 && c<tablero[0].length){
            if(charValido(tablero[f][c])){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

    private boolean comprobarHorizontal() {
        int cont1=0;
        int cont2=0;
        for(int i=0; i<tablero.length; ++i){
            for(int j=0; j<tablero[i].length; ++j){
                if(charValido(tablero[i][j])){
                    if(tablero[i][j]=='X'){
                        ++cont1;
                    }
                    if(tablero[i][j]=='O'){
                        ++cont2;
                    }
                }
            }
            if(cont1==3 || cont2==3){
                return true;
            }
            cont1=0;
            cont2=0;
        }
        return false;
    }

    private boolean comprobarVertical() {
        int cont1=0;
        int cont2=0;
        for(int j=0; j<tablero[0].length; ++j){
            for(int i=0; i<tablero.length; ++i){
                if(charValido(tablero[i][j])){
                    if(tablero[i][j]=='X'){
                        ++cont1;
                    }
                    if(tablero[i][j]=='O'){
                        ++cont2;
                    }
                }
            }
            if(cont1==3 || cont2==3){
                return true;
            }
            cont1=0;
            cont2=0;
        }
        return false;
    }

    private boolean comprobarDiagonal() {
        int cont1=0;
        int cont2=0;
        for(int i=0; i<tablero.length; ++i){
            if(charValido(tablero[i][i])){
                if(tablero[i][i]=='X'){
                    ++cont1;
                }
                if(tablero[i][i]=='O'){
                    ++cont2;
                }
            }
        }
        if(cont1==3 || cont2==3){
            return true;
        }
        cont1=0;
        cont2=0;
        for(int i=0; i<tablero.length; ++i){
            if(charValido(tablero[i][tablero.length-1-i])){
                if(tablero[i][tablero.length-1-i]=='X'){
                    ++cont1;
                }
                if(tablero[i][tablero.length-1-i]=='O'){
                    ++cont2;
                }
            }
        }
        if(cont1==3 || cont2==3){
            return true;
        }
        return false;
    }

    private boolean charValido(char ficha) {
        return ficha=='X' || ficha=='O';
    }
    
    private boolean comprobarHorizontal(char ficha) {
        int cont=0;
        for(int i=0; i<tablero.length; ++i){
            for(int j=0; j<tablero[i].length; ++j){
                if(tablero[i][j]==ficha){
                    ++cont;
                }
            }
            if(cont==3){
                return true;
            }
            cont=0;
        }
        return false;
    }

    private boolean comprobarVertical(char ficha) {
        int cont=0;
        for(int j=0; j<tablero[0].length; ++j){
            for(int i=0; i<tablero.length; ++i){
                if(tablero[i][j]==ficha){
                    ++cont;
                }
            }
            if(cont==3){
                return true;
            }
            cont=0;
        }
        return false;
    }

    private boolean comprobarDiagonal(char ficha) {
        int cont=0;
        for(int i=0; i<tablero.length; ++i){
            if(charValido(tablero[i][i])){
                if(tablero[i][i]==ficha){
                    ++cont;
                }
            }
        }
        if(cont==3){
            return true;
        }
        cont=0;
        for(int i=0; i<tablero.length; ++i){
            if(charValido(tablero[i][tablero.length-1-i])){
                if(tablero[i][tablero.length-1-i]==ficha){
                    ++cont;
                }
            }
        }
        if(cont==3){
            return true;
        }
        return false;
    }
    
    
    public static void main(String[] args){
        TresEnRaya partida = new TresEnRaya();
        
        while(!partida.comprobarVictoria() && !partida.tableroLleno()){
            partida.mostrar();
            System.out.println();
            
            if(!partida.tableroLleno()){
                System.out.println("Jugador 1: ");
                partida.ponerFicha('X');
                System.out.println();
                partida.mostrar();
                System.out.println();
            }
            
            
            if(partida.comprobarVictoria('X')){
                System.out.println("Ha ganado el jugador 1");
                break;
            }
            if(!partida.tableroLleno()){
                System.out.println("Jugador 2: ");
                partida.ponerFicha('O');
                System.out.println();
            }
            
            if(partida.comprobarVictoria('O')){
                partida.mostrar();
                System.out.println();
                System.out.println("Ha ganado el jugador 2");
                break;
            }
        }
        
        if(partida.tableroLleno() && !partida.comprobarVictoria()){
            System.out.println("Empate");
        }
    }

}
