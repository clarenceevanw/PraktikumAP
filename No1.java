package Praktikum10;

import java.util.Scanner;
import java.util.ArrayList;

public class No1 {
    public static void main(String[] args) {
        //Menerima inputan user untuk strength andi, jumlah bos, kekuatan setiap bos, dan bonus strength ketika mengalahkan setiap bos.
        Scanner input = new Scanner(System.in);
        System.out.print("Strength Andi: ");
        int strengthAndi = input.nextInt();
        System.out.print("Jumlah Bos: ");
        int jumlahBoss = input.nextInt();
        int[] strengthBoss = new int[jumlahBoss];
        int[] bonusStrength = new int[jumlahBoss];
        for (int i = 0; i < jumlahBoss; i++) {
            System.out.print("Strength Boss " + (i+1) + ": ");
            strengthBoss[i] = input.nextInt();
            System.out.print("Bonus strength dari Boss " + (i+1) + ": ");
            bonusStrength[i] = input.nextInt();
        }
        checkBos(strengthBoss,bonusStrength,strengthAndi,jumlahBoss);
    }

    public static void checkBos(int[] kekuatanBos, int[] bonusKekuatan, int strengthAndi, int jumlahBos){
        ArrayList<Integer> menang = new ArrayList<>();//List ini untuk menampung bos mana yang sudah dikalahkan
        int counter = 0;//Untuk mengetahui sudah berapa kali bos yang dikalahkan
        boolean defeated;
        while (counter < jumlahBos){
            defeated = false;
            for (int j = 0; j < kekuatanBos.length; j++) {
                //If disini akan mengecek apakah strength andi lebih besar dibanding bos dan bila kekuatan bos blm direset 0, jika kekuatan bos 0  maka akan dianggap sudah dikalahkan
                    if (strengthAndi > kekuatanBos[j] && kekuatanBos[j] != 0) {
                        strengthAndi += bonusKekuatan[j];
                        kekuatanBos[j] = 0;//Kekuatan bos akan direset agar tidak dilawan lagi
                        menang.add(j + 1);
                        counter++;
                        defeated = true;
                    }
            }
            if (!defeated){
                break;
            }
        }
        //Untuk mengecek apakah ada bos yang dikalahkan
        if(counter < jumlahBos){
            //Jika tidak ada bos dikalahkan maka dioutputkan tanpa bos
            if(menang.isEmpty()){
                System.out.println("Andi gagal membersihkan area.");
            }else {
                System.out.print("Andi gagal membersihkan area, pertualangan andi berhenti setelah mengalahkan: ");
                for (int i = 0; i < menang.size(); i++) {
                    if(i < menang.size() - 1) {
                        System.out.print("Boss " + menang.get(i) + ", ");
                    }
                    else {
                        System.out.print("Boss " + menang.get(i));
                    }
                }
            }
        }else {
            System.out.print("Andi sukses membersihkan area dengan urutan: ");
            for (int i = 0; i < menang.size(); i++) {
                if(i < menang.size() - 1) {
                    System.out.print("Boss " + menang.get(i) + ", ");
                }
                else {
                    System.out.print("Boss " + menang.get(i));
                }
            }
        }
    }
}

/*
Decomposition:
1. Menerima inputan dalam segi strength andi, jumlah bos, kekuatan setiap bos, dan bonus kekuatan setelah mengalahkan setiap bos
2. Mencatat semua dalam bentuk variabel maupun array
3. Membuat function untuk mengecek kemenangan dari andi, dimana terjadi loop while dan for dimana ada pengecekan ketika kekuatan andi lebih kecil maka bosnya di skip dan mencari bos yang kekuatannya lebih kecil dari andi, lalu akan mengecek jika dalam 1 loop tersebut andi sudah tidak mengalahkan bos apapun nantinya loop akan berhenti.
 */
