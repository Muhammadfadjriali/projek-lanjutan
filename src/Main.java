import java.util.Scanner;
public class Main   {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Mahasiswa maha = new Mahasiswa();
        Petugas petugas = new Petugas();
        Buku buku = new  Buku();
        Peminjaman peminjaman = new Peminjaman();

        petugas.listPetugas();
        maha.listMahasiswa();

        int idMahasiswa = peminjaman.Proses(maha);

        Boolean ulang = true;
        while (ulang) {
            int menu = peminjaman.pilihMenu();
            switch (menu) {
                case 1:
                    buku.listBuku();
                    break;
                case 2:
                    peminjaman.prosesPeminjaman(idMahasiswa, maha, buku);
                    break;
                case 3:
                    peminjaman.prosesPengembalian(idMahasiswa, maha, buku);
                    break;
                case 4:
                    peminjaman.peminjamanMahasiswa(maha, buku);
                    break;
                case 5:
                    peminjaman.statusMahasiswa(maha);
                    break;
                case 99:
                    ulang = false;
                    break;
                default: {
                    System.out.println("Menu yang dipilih tidak tersedia\n");
                }
            }
        }
        in.close();
    }
    public void Ucapan() {
        System.out.println("   SELAMAT DATANG DI PERPUSTAKAAN UNIVERSITAS AHMAD DAHLAN   ");
        System.out.println("=============================================================");
    }
}