import java.util.ArrayList;
public class Mahasiswa  implements User  {

    private ArrayList<String> namaMahasiswa = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> nim = new ArrayList<String>();
    private ArrayList<Boolean> status = new ArrayList<Boolean>();

    public Mahasiswa() {
        this.namaMahasiswa.add("Fadjri");
        this.alamat.add("Yogya");
        this.nim.add("2100018291");
        this.status.add(true);

        this.namaMahasiswa.add("Radia");
        this.alamat.add("Sleman");
        this.nim.add("2100018226");
        this.status.add(true);

        this.namaMahasiswa.add("Adawi");
        this.alamat.add("Malang");
        this.nim.add("2100018225");
        this.status.add(true);
    }

    public void listMahasiswa() {
        System.out.println("Mahasiswa terdaftar : ");
        System.out.println("-----------------------------------------------");
        System.out.println("ID\t|Nama Mahasiswa\t|Alamat\t|NIM \t\t|Status");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < this.namaMahasiswa.size(); i++) {
            System.out.println(i + "\t|" + this.namaMahasiswa.get(i) + "\t\t\t|" + this.alamat.get(i) + "\t|" + this.nim.get(i) + "\t|" + this.status.get(i));
        }
        System.out.println("");
    }

    protected int getJmlMahasiswa() {
        return this.namaMahasiswa.size();
    }

    public void setNama(String namaMahasiswa) {
        this.namaMahasiswa.add(namaMahasiswa);
    }

    @Override
    public void setAlamat(String alamat) {
        this.alamat.add(alamat);
    }

    @Override
    public void setTelepon(String telepon) {
        this.nim.add(telepon);
    }

    public void setStatus(Boolean status) {
        this.status.add(status);
    }

    public void updateStatus(int idMahasiswa, boolean status) {
        this.status.set(idMahasiswa, status);
    }

    @Override
    public String getNama(int idMahasiswa) {
        return this.namaMahasiswa.get(idMahasiswa);
    }

    @Override
    public String getAlamat(int idMahasiswa) {
        return this.alamat.get(idMahasiswa);
    }

    @Override
    public String getTelepon(int idMahasiwa) {
        return this.nim.get(idMahasiwa);
    }

    public Boolean getStatus(int idMahasiswa) {
        return this.status.get(idMahasiswa);
    }
}