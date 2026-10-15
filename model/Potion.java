package model;

public class Potion extends AuctionItem {
    private int hpRestore;
    private int manaRestore;

    public Potion(String nama, double totalHarga, int totalUnit, int hpRestore, int manaRestore) {
        super(nama, totalHarga, totalUnit);
        this.hpRestore = hpRestore;
        this.manaRestore = manaRestore;
    }

    public int getHpRestore() {
        return hpRestore;
    }

    public int getManaRestore() {
        return manaRestore;
    }

    @Override
    public String getKategori() {
        return "Potion";
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
        System.out.println("HP Restore: " + hpRestore);
        System.out.println("Mana Restore: " + manaRestore);
    }
}