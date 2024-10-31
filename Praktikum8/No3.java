package Praktikum8;

import java.util.Random;
import java.util.Scanner;

public class No3 {
    public static void main(String[] args) {
        Random rd = new Random();
        Scanner input = new Scanner(System.in);
        //Meminta inputan row dan column dari matrix
        System.out.print("Input Row: ");
        int row = input.nextInt();
        System.out.print("Input Column: ");
        int column = input.nextInt();
        int[][] matrix = new int[row][column];
        //Mengisi array matrix dengan angka random
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = rd.nextInt(10);
            }
        }
        int choice = 0;
        while (true){
            System.out.println("Matrix");
            printMatrix(matrix);
            System.out.println("1. Rotate Right");
            System.out.println("2. Rotate Left");
            System.out.println("3. Flip Horizontal");
            System.out.println("4. Flip Vertical");
            System.out.println("5. Exit");
            System.out.print("Pilihan: ");
            choice = input.nextInt();
            if (choice==1) {
                matrix = rotateRight(matrix);//Matrix akan diputar 90 derajat ke kanan
            } else if (choice == 2) {
                matrix = rotateLeft(matrix);//Matrix akan diputar 90 derajat ke kiri
            } else if (choice == 3) {
                matrix = flipHorizontal(matrix);//Matrix akan diflip secara horizontal
            } else if (choice == 4) {
                matrix = flipVertical(matrix);//Matrix akan difflip secara vertical
            }else if(choice == 5){
                System.out.println("Adios..");//Akan keluar dari loop dan program selesai
                break;
            }else{
                System.out.println("Choice nya tidak ada");
            }
        }
    }

    public static void printMatrix(int[][] matrix){
        //Function untuk mengeprint matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static int[][] rotateRight(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] array = new int[cols][rows];
        //Kita ubah ukuran matrix kolom jadi baris, baris jadi kolom
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[j][rows - 1 - i] = arr[i][j];//Kita awal akan menset index paling belakang menjadi index awal di matriks awal
            }
        }
        return array;
    }

    public static int[][] rotateLeft(int[][] arr){
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] array = new int[cols][rows];
        //Kita ubah ukuran matrix kolom jadi baris, baris jadi kolom
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[j][i] = arr[i][arr[0].length-j-1]; //kita akan mengambil index belakang kolom dari array awal dan dimasukkan ke dalam array hasil
            }
        }
        return array;
    }
    public static int[][] flipHorizontal(int[][] arr){
        int[][] array = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                array[i][j] = arr[i][arr[i].length - 1 - j];//kita akan memutar array secara horizontal dengan mengambil index pling belakang kolom dari array awal
            }
        }
        return array;
    }
    public static int[][] flipVertical(int[][] arr){
        int[][] array = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                array[i][j] = arr[arr.length-1-i][j];//Memutar secara vertikal dengan mengambil index baris belakang pada array awal dan dimasukkan ke array hasil
            }
        }
        return array;
    }
}