package Praktikum10;

import java.util.ArrayList;
import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Jumlah Titik: ");
        int jumlah = input.nextInt();

        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();

        //Menginput koordinat titik
        for (int i = 0; i < jumlah; i++) {
            System.out.print("Koordinat x " + (i + 1) + " : ");
            x.add(input.nextInt());
            System.out.print("Koordinat y " + (i + 1) + " : ");
            y.add(input.nextInt());
        }

        ArrayList<String> urutanTitik = new ArrayList<>();
        urutanTitik.add("(0, 0)");
        double totalJarak = 0;
        int titikAwalX = 0, titikAwalY = 0;

        //Mengloop untuk mencari jarak yang terpendek dari smua hitungan
        for (int i = 0; i < jumlah; i++) {
            ArrayList<Double> jarak = titikTerpendek(x, y, titikAwalX, titikAwalY);
            int posisi = findMinimalPosition(jarak);
            //menambahkan jarak terpendek ke dalam total jarak
            totalJarak += jarak.get(posisi);
            //menambahkan titik ke urutan yang dikunjungi
            urutanTitik.add("(" + x.get(posisi) + ", " + y.get(posisi) + ")");
            //mereset titik awal ke titik yang baru dikunjungi
            titikAwalX = x.get(posisi);
            titikAwalY = y.get(posisi);
            //menghapus titik yang sudah dikunjungi
            x.remove(posisi);
            y.remove(posisi);
        }
        // Output urutan titik dan total jarak
        System.out.println("Urutan titik yang dilewati: " + urutanTitik);
        System.out.println("Total jarak yang dilewati: " + totalJarak);
    }

    //Untuk mencari jarak terpendek mulai dri stiap titik awal ke titik yang ada
    public static ArrayList<Double> titikTerpendek(ArrayList<Integer> x, ArrayList<Integer> y, int titikAwalX, int titikAwalY){
        ArrayList<Double> array = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            array.add(Math.sqrt(Math.pow(x.get(i) - titikAwalX, 2) + Math.pow(y.get(i) - titikAwalY, 2)));
        }
        return array;
    }
    //Untuk mencari posisi minimalnya yang mana
    public static int findMinimalPosition(ArrayList<Double> array){
        double minimal = Double.MAX_VALUE;
        int position = 0;
        for (int i = 0; i < array.size(); i++) {
            if(array.get(i) < minimal) {
                position = i;
            }
        }
        return position;
    }
}
