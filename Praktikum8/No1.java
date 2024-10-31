package Praktikum8;

import java.util.Scanner;

public class No1 {
    public static int[] kesatria = {4, 4}; // Posisi awal kesatria (S)

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] maze = {
                {'.', 'X', '.', '.', '.'},
                {'.', '.', '.', 'X', 'E'},
                {'.', '.', 'X', 'X', '.'},
                {'X', '.', '.', 'X', 'X'},
                {'.', '.', '.', '.', 'S'}
        };

        //print mesh awal
        printMesh(maze);

        while (true) {
            maze[4][4] = '.';
            System.out.print("Gerak (w / a / s / d): ");
            char move = input.next().toLowerCase().charAt(0);
            moveSatria(move, maze);
            printMesh(maze); // Tampilkan peta setelah kesatria bergerak
            if(kesatria[0] == 1 && kesatria[1] == 4) {
                System.out.println("Anda telah menang");
                break;
            }
        }
    }

    public static void moveSatria(char gerak, char[][] mesh) {
        // Simpan posisi kesatria saat ini
        int row = kesatria[0];
        int col = kesatria[1];
        // Cek arah gerakan
        if (gerak == 'w') {
            // Gerak ke atas
            if (row > 0 && mesh[row - 1][col] != 'X') {
                kesatria[0]--; // Pindah ke atas
            } else {
                System.out.println("Tidak bisa bergerak ke atas karena ada X atau di luar batas.");
            }
        } else if (gerak == 'a'){
            if (col > 0 && mesh[row][col - 1] != 'X') {
                kesatria[1]--; // Pindah ke kiri
            } else {
                System.out.println("Tidak bisa bergerak ke kiri karena ada X atau di luar batas.");
            }
        }else if (gerak == 's') {
            if (row < mesh.length - 1 && mesh[row + 1][col] != 'X') {
                kesatria[0]++; // Pindah ke bawah
            } else {
                System.out.println("Tidak bisa bergerak ke bawah karena ada X atau di luar batas.");
            }
        } else if (gerak == 'd') {
            if (col < mesh[0].length - 1 && mesh[row][col + 1] != 'X') {
                kesatria[1]++; // Pindah ke kanan
            } else {
                System.out.println("Tidak bisa bergerak ke kanan karena ada X atau di luar batas.");
            }
        }else {
            System.out.println("Inputan salah.");
        }
    }

    public static void printMesh(char[][] mesh) {
        // Cetak peta dengan posisi kesatria
        for (int i = 0; i < mesh.length; i++) {
            for (int j = 0; j < mesh[i].length; j++) {
                if (i == kesatria[0] && j == kesatria[1]) {
                    System.out.print("S "); // Cetak kesatria di posisi baru
                } else {
                    System.out.print(mesh[i][j] + " "); // Cetak elemen peta
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}