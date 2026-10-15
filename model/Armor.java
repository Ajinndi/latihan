package model;

public class Armor extends AuctionItem {
    private int defense;
    private ArmorType jenis;

    public Armor(String nama, double totalHarga, int defense, ArmorType jenis) {
        super(nama, totalHarga, 1);
        this.defense = defense;
        this.jenis = jenis;
    }

    public int getDefense() {
        return defense;
    }

    public ArmorType getJenis() {
        return jenis;
    }

    @Override
    public String getKategori() {
        return "Armor";
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
        System.out.println("Defense: " + defense);
        System.out.println("Type: " + jenis);
    }
}