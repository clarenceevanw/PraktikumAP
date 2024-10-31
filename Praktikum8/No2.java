package Praktikum8;

import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        char[][] arr = new char[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = '.';
            }
        }
        int giliran = 1;
        while (true){
            //Ketika giliran ganjil maka adalah giliran player pertama, kalau genap maka player kedua
            if(giliran % 2 != 0) {
                printTicTacToe(arr);
                System.out.println("Giliran Player pertama");
                System.out.print("Input koordinat Baris (Player 1): ");
                int xBaris = input.nextInt()-1;
                System.out.print("Input koordinat Kolom (Player 1): ");
                int xKolom = input.nextInt()-1;
                if(arr[xBaris][xKolom] == 'O'){
                    System.out.println("Inputan salah");
                }else {
                    ticTacToeP1(arr, xBaris, xKolom);
                    giliran++;
                }

                if(checkWinnings(arr)){
                    printTicTacToe(arr);
                    System.out.println("Player 1 menang");
                    break;
                }
            }else {
                printTicTacToe(arr);
                System.out.print("Input koordinat baris (Player 2): ");
                int oBaris = input.nextInt()-1;
                System.out.print("Input koordinat kolom (Player 2): ");
                int oKolom = input.nextInt()-1;
                if(arr[oBaris][oKolom] == 'X'){
                    System.out.println("Inputan salah");
                }else {
                    ticTacToeP2(arr, oBaris, oKolom);
                    giliran++;
                }

                if(checkWinnings(arr)){
                    printTicTacToe(arr);
                    System.out.println("Player 2 menang");
                    break;
                }
            }
        }
    }
    public static void ticTacToeP1(char[][] arr, int baris, int kolom){
        arr[baris][kolom] = 'X';
    }
    public static void ticTacToeP2(char[][] arr, int baris, int kolom){
        arr[baris][kolom] = 'O';
    }

    public static void printTicTacToe(char[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkWinnings(char[][] arr) {
        int n = arr.length;

        //Memeriksa baris apakah ada yang menang
        for (int i = 0; i < n; i++) {
            boolean baris = true;
            for (int j = 1; j < n; j++) {
                if (arr[i][0] != arr[i][j]) {
                    baris = false;
                    break;
                }
            }
            if (baris && arr[i][0] != '.') {
                return true;
            }
        }

        //Memeriksa kolom apakah ada yang menang
        for (int i = 0; i < n; i++) {
            boolean kolom = true;
            for (int j = 1; j < n; j++) {
                if (arr[0][i] != arr[j][i]) {
                    kolom = false;
                    break;
                }
            }
            if (kolom && arr[0][i] != '.') {
                return true;
            }
        }

        //Mengecek diagonal dari kiri ke kanan
        boolean diagonalKanan = true;
        for (int i = 1; i < n; i++) {
            if (arr[0][0] != arr[i][i]) {
                diagonalKanan = false;
                break;
            }
        }
        if (diagonalKanan && arr[0][0] != '.') {
            return true;
        }

        //Mengecek diagonal dari kanan ke kiri
        boolean diagonalKiri = true;
        for (int i = 1; i < n; i++) {
            if (arr[0][n - 1] != arr[i][n - 1 - i]) {
                diagonalKiri = false;
                break;
            }
        }
        if (diagonalKiri && arr[0][n - 1] != '.') {
            return true;
        }
        //Jika tidak memenuhi semua pengecekan di atas maka belum atau tidak ada yang menang
        return false;
    }

}