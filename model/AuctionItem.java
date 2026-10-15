package model;

public abstract class AuctionItem implements Auctionable {
    private String nama;
    private double totalHarga;
    private int totalUnit;

    public AuctionItem(String nama, double totalHarga, int totalUnit) {
        this.nama = nama;
        this.totalHarga = totalHarga;
        this.totalUnit = totalUnit;
    }

    public String getNama() {
        return nama;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public int getTotalUnit() {
        return totalUnit;
    }

    @Override
    public double getHargaSatuan() {
        return totalHarga / totalUnit;
    }

    public abstract String getKategori();

    public abstract void printDetail();

    public void print() {
        System.out.print(getNama() + ", total unit " + getTotalUnit() + ", total harga ");

        if (totalHarga == (int) totalHarga) {
            System.out.print((int) totalHarga);
        } else {
            System.out.print(totalHarga);
        }

        System.out.println();
    }

    public void print(boolean tampilkanHargaSatuan) {
        System.out.print(getNama() + ", total unit " + getTotalUnit() + ", total harga ");

        if (totalHarga == (int) totalHarga) {
            System.out.print((int) totalHarga);
        } else {
            System.out.print(totalHarga);
        }

        if (tampilkanHargaSatuan) {
            System.out.print(" (harga satuan @");

            if (getHargaSatuan() == (int) getHargaSatuan()) {
                System.out.print((int) getHargaSatuan());
            } else {
                System.out.print(getHargaSatuan());
            }

            System.out.print(")");
        }

        System.out.println();
    }
}