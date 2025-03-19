import java.util.Scanner;

public class latihan_THT {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        final double TARIF_PAGI = 25000;    
        final double TARIF_SIANG = 30000;   
        final double TARIF_MALAM = 35000;   
        final double TARIF_LEMBUR = 1.5;    
        final double POTONGAN_ABSEN = 100000; 
        final int JAM_NORMAL = 40;          
        final int JAM_MINIMUM = 30;         
        
        System.out.println("=== Program Perhitungan Gaji Karyawan ===");
        System.out.print("Masukkan jumlah karyawan: ");
        int jumlahKaryawan = input.nextInt(); 
        input.nextLine();
        
        String[] idKaryawan = new String[jumlahKaryawan];
        String[] namaKaryawan = new String[jumlahKaryawan];
        int[] shiftKaryawan = new int[jumlahKaryawan];
        int[] jamKerja = new int[jumlahKaryawan];
        int[] hariAbsen = new int[jumlahKaryawan];
        double[] gajiTotal = new double[jumlahKaryawan];
        
        for (int i = 0; i < jumlahKaryawan; i++) {
            System.out.println("\nData Karyawan ke-" + (i + 1));
            System.out.print("Masukkan ID Karyawan: ");
            idKaryawan[i] = input.nextLine();
            
            System.out.print("Masukkan Nama Karyawan: ");
            namaKaryawan[i] = input.nextLine();

            do {
                System.out.print("Masukkan Shift Kerja (1=Pagi, 2=Siang, 3=Malam): ");
                shiftKaryawan[i] = input.nextInt();
                if (shiftKaryawan[i] < 1 || shiftKaryawan[i] > 3) {
                    System.out.println("Shift tidak valid! Masukkan 1, 2, atau 3.");
                }
            } while (shiftKaryawan[i] < 1 || shiftKaryawan[i] > 3);
            
            do {
                System.out.print("Masukkan Total Jam Kerja (0-70 jam): ");
                jamKerja[i] = input.nextInt();
                if (jamKerja[i] < 0 || jamKerja[i] > 70) {
                    System.out.println("Jam kerja tidak valid! Masukkan antara 0-70 jam.");
                }
            } while (jamKerja[i] < 0 || jamKerja[i] > 70);
            
            do {
                System.out.print("Masukkan Jumlah Hari Absen (0-7 hari): ");
                hariAbsen[i] = input.nextInt();
                if (hariAbsen[i] < 0 || hariAbsen[i] > 7) {
                    System.out.println("Hari absen tidak valid! Masukkan antara 0-7 hari.");
                }
            } while (hariAbsen[i] < 0 || hariAbsen[i] > 7);
            
            input.nextLine();
            double tarifPerJam = 0;
            switch (shiftKaryawan[i]) {
                case 1:
                    tarifPerJam = TARIF_PAGI;
                    break;
                case 2:
                    tarifPerJam = TARIF_SIANG;
                    break;
                case 3:
                    tarifPerJam = TARIF_MALAM;
                    break;
            }
            
            double gajiNormal = 0;
            double gajiLembur = 0;
            
            if (jamKerja[i] > JAM_NORMAL) {
                gajiNormal = JAM_NORMAL * tarifPerJam;
                gajiLembur = (jamKerja[i] - JAM_NORMAL) * tarifPerJam * TARIF_LEMBUR;
            } else {
                gajiNormal = jamKerja[i] * tarifPerJam;
            }
            
            double totalGaji = gajiNormal + gajiLembur;
            
            if (jamKerja[i] < JAM_MINIMUM) {
                totalGaji = totalGaji * 0.9; 
            }
            
            totalGaji -= hariAbsen[i] * POTONGAN_ABSEN;
            
            gajiTotal[i] = (totalGaji < 0) ? 0 : totalGaji;
        }
        
        System.out.println("\n=== Laporan Gaji Karyawan ===");
        System.out.printf("%-10s %-20s %-10s %-15s %-10s %-15s\n", "ID", "Nama", "Shift", "Jam Kerja", "Absen", "Total Gaji");
        System.out.println("------------------------------------------------------------------------------------------");
        
        for (int i = 0; i < jumlahKaryawan; i++) {
            String shiftText = "";
            switch (shiftKaryawan[i]) {
                case 1: shiftText = "Pagi"; break;
                case 2: shiftText = "Siang"; break;
                case 3: shiftText = "Malam"; break;
            }
            
            System.out.printf("%-10s %-20s %-10s %-15d %-10d Rp %-15.2f\n",
                idKaryawan[i], namaKaryawan[i], shiftText, jamKerja[i], hariAbsen[i], gajiTotal[i]);
        }
        input.close();
    }
}