package view;

import controller.ObjectController;

public class ObjectView {
    public static void main(String[] args) {
        ObjectController controller = new ObjectController();
        int input = -1;

        try {
            while (input != 0) {
                System.out.println();
                System.out.println("BARANG LELANG");
                System.out.println();

                System.out.println("1. Tambah Barang Lelang");
                System.out.println("2. Tampilkan Berdasarkan Total Harga");
                System.out.println("3. Tampilkan Berdasarkan Harga Satuan");
                System.out.println("0. Keluar");

                System.out.print("Pilih menu: ");

                try {
                    input = util.CLIUtil.readInt();

                    if (input == 1) {
                        controller.tambahBarang();
                    } else if (input == 2) {
                        controller.printBerdasarkanTotalHarga();
                    } else if (input == 3) {
                        controller.printBerdasarkanHargaSatuan();
                    } else if (input == 0) {
                        System.out.println("Program selesai.");
                    } else {
                        System.out.println("Pilihan tidak tersedia.");
                    }
                } catch (exception.EmptyInputException e) {
                    System.out.println(e.getMessage());
                } catch (exception.InvalidNumberException e) {
                    System.out.println(e.getMessage());
                }
            }
        } finally {
            util.CLIUtil.close();
        }
    }
}