import java.util.Scanner;

public class Postest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan total belanja (dalam Rupiah): ");
        double totalBelanja = input.nextDouble();
        System.out.print("Masukkan tipe member (Platinum/Gold/Silver/Tidak Ada): ");
        input.nextLine();
        String tipeMember = input.nextLine().trim();
        double diskonUtama = 0;
        double diskonTambahan = 0;
        double totalDiskon;
        double totalAkhir;


        if (totalBelanja > 500000) {
            diskonUtama = totalBelanja * 0.20;
        } else if (totalBelanja >= 250000 && totalBelanja <= 500000) {
            diskonUtama = totalBelanja * 0.10; 
        } else {
            diskonUtama = 0;
        }

        switch (tipeMember.toLowerCase()) {
            case "platinum":
                diskonTambahan = (totalBelanja - diskonUtama) * 0.05;
                break;
            case "gold":
                diskonTambahan = (totalBelanja - diskonUtama) * 0.03;
                break;
            case "silver":
                diskonTambahan = (totalBelanja - diskonUtama) * 0.02;
                break;
            case "tidak ada":
                diskonTambahan = 0;
                break;
            default:
                System.out.println("Error: Tipe member tidak valid! Gunakan Platinum, Gold, Silver, atau Tidak Ada.");
                input.close();
                return;
        }

        totalDiskon = diskonUtama + diskonTambahan;
        totalAkhir = totalBelanja - totalDiskon;

        String statusDiskon = (totalDiskon > 0) ? "Pelanggan mendapatkan diskon" : "Pelanggan tidak mendapatkan diskon";

        System.out.println("\n--- Rincian Pembayaran ---");
        System.out.printf("Total Belanja: Rp %.2f%n", totalBelanja);
        System.out.printf("Diskon Utama: Rp %.2f%n", diskonUtama);
        System.out.printf("Diskon Tambahan (%s): Rp %.2f%n", tipeMember, diskonTambahan);
        System.out.printf("Total Diskon: Rp %.2f%n", totalDiskon);
        System.out.printf("Total Akhir: Rp %.2f%n", totalAkhir);
        System.out.println("Status: " + statusDiskon);

        input.close();
    }
}