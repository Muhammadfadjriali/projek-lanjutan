import java.util.ArrayList;
import java.util.Scanner;

public class Peminjaman extends Main  {

    private ArrayList<Integer> idMahasiswa = new ArrayList<Integer>();
    private ArrayList<Integer> idBuku = new ArrayList<Integer>();
    private ArrayList<Integer> banyak = new ArrayList<Integer>();

    Scanner in = new Scanner(System.in);

    public int Proses(Mahasiswa oMahasiswa) {
        super.Ucapan();
        System.out.print("Masukkan id Mahasiswa : ");
        int idMahasiswaInput = in.nextInt();
        if (idMahasiswaInput >= oMahasiswa.getJmlMahasiswa()) {
            System.out.println("Mahasiswa tidak terdaftar\n");
            System.exit(0);
        }
        if (oMahasiswa.getStatus(idMahasiswaInput) == true) {
            System.out.println("Halo " + oMahasiswa.getNama(idMahasiswaInput) + " status anda adalah true. Anda bisa meminjam buku");
            System.out.println("=========================================");
        } else {
            System.out.println("Halo " + oMahasiswa.getNama(idMahasiswaInput) + " status anda adalah false. Anda harus mengembalikan buku terlebih dahulu.");
            System.out.println("=========================================");
        }
        return idMahasiswaInput;
    }

    //list pinjaman
    public void peminjamanMahasiswa(Mahasiswa Mahasiswa, Buku buku) {
        System.out.println("Berikut adalah daftar pinjaman buku");
        System.out.println("Nama Mahasiswa\t|Nama Buku\t|Banyak");
        for (int i = 0; i < this.idMahasiswa.size(); i++) {
            System.out.println(Mahasiswa.getNama(this.idMahasiswa.get(i)) + "\t\t|" + buku.getNama(this.idBuku.get(i)) + "\t\t|" + this.banyak.get(i));
        }
        System.out.println("");
    }

    //tambah peminjaman
    public void peminjamanMahasiswa(int idMahasiswa, int idBuku, int banyak) {
        this.idMahasiswa.add(idMahasiswa);
        this.idBuku.add(idBuku);
        this.banyak.add(banyak);
    }

    public int getIdBuku(int idMahasiswa) {
        return this.idBuku.get(idMahasiswa);
    }

    public int getBanyak(int idMahasiswa) {
        return this.banyak.get(idMahasiswa);
    }

    public void hapusPeminjaman(int idSiswa) {
        this.banyak.remove(idSiswa);
        this.idBuku.remove(idSiswa);
        this.idMahasiswa.remove(idSiswa);
    }

    public int pilihMenu() {
        System.out.println("\nPilih Menu");
        System.out.println(" 1. List Buku");
        System.out.println(" 2. Peminjaman");
        System.out.println(" 3. Pengembalian");
        System.out.println(" 4. Data Peminjaman");
        System.out.println(" 5. Status Mahasiswa");
        System.out.println("99. Keluar");
        System.out.print("=> ");
        return in.nextInt();
    }

    public void prosesPeminjaman(int idMahasiswa, Mahasiswa Mahasiswa, Buku buku) {
        if (!Mahasiswa.getStatus(idMahasiswa)) {
            System.out.println("Siswa sedang meminjam buku, tidak dapat meminjam lagi\n");
            return;
        }

        buku.listBuku();
        System.out.print("Input ID buku\t: ");
        int idBuku = in.nextInt();
        System.out.print("Banyak buku\t: ");
        int banyak = in.nextInt();

        if (buku.getStok(idBuku) < banyak) {
            System.out.println("Sisa stok buku tidak mencukupi\n");
            return;
        }

        peminjamanMahasiswa(idMahasiswa, idBuku, banyak);
        buku.pinjam(idBuku, banyak);
        Mahasiswa.updateStatus(idMahasiswa, false);
        System.out.println("Berhasil melakukan peminjaman buku\n");
    }

    public void prosesPengembalian(int idMahasiswa, Mahasiswa Mahasiswa, Buku buku) {
        int idBuku = getIdBuku(idMahasiswa);
        int banyak = getBanyak(idMahasiswa);

        hapusPeminjaman(idMahasiswa);
        buku.kembali(idBuku, banyak);
        Mahasiswa.updateStatus(idMahasiswa, true);

        System.out.println("Berhasil melakukan pengembalian buku\n");
    }

    public void statusMahasiswa(Mahasiswa Mahasiswa) {
        System.out.println("Status Mahasiswa");
        System.out.println("ID\t|Nama Mahasiswa\t|Alamat\t\t|Telp\t|Status");
        for (int i = 0; i < Mahasiswa.getJmlMahasiswa(); i++) {
            System.out.println(i + "\t|" + Mahasiswa.getNama(i) + "\t\t|"
                    + Mahasiswa.getAlamat(i) + "\t|"
                    + Mahasiswa.getTelepon(i) + "\t|"
                    + Mahasiswa.getStatus(i));
        }
    }
}