package model;

public class Weapon extends AuctionItem {
    private int attack;
    private WeaponType jenis;

    public Weapon(String nama, double totalHarga, int attack, WeaponType jenis) {
        super(nama, totalHarga, 1);
        this.attack = attack;
        this.jenis = jenis;
    }

    public int getAttack() {
        return attack;
    }

    public WeaponType getJenis() {
        return jenis;
    }

    @Override
    public String getKategori() {
        return "Weapon";
    }

    @Override
    public void print() {
        super.print();
        printDetail();
    }

    @Override
    public void print(boolean tampilkanHargaSatuan) {
        super.print(tampilkanHargaSatuan);
        printDetail();
    }

    @Override
    public void printDetail() {
        System.out.println("Attack: " + attack);
        System.out.println("Type: " + jenis);
    }
}