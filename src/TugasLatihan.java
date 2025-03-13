import java.util.Scanner;
public class TugasLatihan {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Kalimat : ");
        String kalimat = input.nextLine();
        String kalimot= "";
        int jumlah_huruf_vokal=0;
        for (int i=kalimat.length()-1; i>=0; i--)
        {
            char huruf= kalimat.charAt(i);
            kalimot = kalimot + huruf;
            if (huruf=='a'){
                jumlah_huruf_vokal++;
            } else if (huruf=='i'){
                jumlah_huruf_vokal++;
            }else if (huruf=='u'){
                jumlah_huruf_vokal++;
            }else if (huruf=='e'){  
                jumlah_huruf_vokal++;
            }else if (huruf=='o'){
                jumlah_huruf_vokal++;
            }
        }
        int isganjil = jumlah_huruf_vokal%2;
        switch (isganjil) {
            case 0:
            System.out.println("Jumlah Huruf Vokal Adalah Genap");
            break;
            case 1:
                System.out.println("Jumlah Huruf Vokal Adalah Ganjil");
                break;
            default:
                break;
        }
        char[] arrayKarakter = kalimot.toCharArray();
        for (char i : arrayKarakter){
             System.out.print(i);
        }
    }
}
