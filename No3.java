package Praktikum10;

import java.util.Scanner;
public class No3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Menu pilihan rumah yang kecil, sedang maupun besar
        System.out.println("Menu");
        System.out.println("1. Rumah kecil");
        System.out.println("2. Rumah sedang");
        System.out.println("3. Rumah besar");
        System.out.print("Pilihan: ");
        int pilihan = input.nextInt();
        System.out.print("Pemakaian (kWh): ");
        int pemakaian = input.nextInt();
        int biaya = 0;//Untuk biaya ketika rumah mana yang dipilih
        switch (pilihan){
            case 1:
                biaya = 1200;
                break;
            case 2:
                biaya = 1400;
                break;
            case 3:
                biaya = 1700;
                break;
            default:
                System.out.println("Tidak ada pilihan");
                break;
        }
        int total = 0;
        //Melakukan pengecekan apakah pemakaian lebih dari syarat
        if (pemakaian > 500) {
            total += (pemakaian - 500) * biaya * 1.20;
            pemakaian = 500;
        }
        if (pemakaian > 300) {
            total += (pemakaian - 300) * biaya * 1.10;
            pemakaian = 300;
        }
        if (pemakaian > 100) {
            total += (pemakaian - 100) * biaya * 1.05;
            pemakaian = 100;
        }
        total += pemakaian * biaya;
        //Pajak
        total *= 1.10;
        System.out.printf("Tagihan Bulan ini: Rp%d" , total);
    }
}

/*
Decomposition:
1.  Menu menerima inputan apakah rumah kecil, sedang , maupun besar dan seberapa banyak pemakaian.
2.  Memberikan biaya sesuai rumah yang dipilih
3.  Mengecek apakah pemakaian sesuai syarat nantinya akan tagihan ditambahkan dengan hasil kali sesuai biayanya dengan pemakaian dikurangi syarat
4.  Total dari semua pengecekan akan ditambah ppn 10 %
 */
