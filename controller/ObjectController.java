package controller;

import java.util.ArrayList;
import java.util.List;

import model.AuctionItem;
import model.Potion;
import model.Weapon;
import model.Armor;
import model.WeaponType;
import model.ArmorType;

import util.CLIUtil;

import exception.EmptyInputException;
import exception.InvalidNumberException;
import exception.EmptyListException;

public class ObjectController {
    private List<AuctionItem> potions = new ArrayList<>();
    private List<AuctionItem> weapons = new ArrayList<>();
    private List<AuctionItem> armors = new ArrayList<>();

    public void tambahBarang() {
        System.out.println();
        System.out.println("TAMBAH BARANG LELANG");
        System.out.println();

        System.out.println("1. Potion");
        System.out.println("2. Weapon");
        System.out.println("3. Armor");

        try {
            System.out.print("Pilih kategori: ");
            int pilihan = CLIUtil.readInt();

            if (pilihan < 1 || pilihan > 3) {
                throw new InvalidNumberException("Kategori tidak tersedia.");
            }

            System.out.print("Nama: ");
            String nama = CLIUtil.readLine();

            System.out.print("Total harga: ");
            double harga = CLIUtil.readDouble();

            if (harga <= 0) {
                throw new InvalidNumberException("Harga harus lebih dari 0.");
            }

            if (pilihan == 1) {
                tambahPotion(nama, harga);
            } else if (pilihan == 2) {
                tambahWeapon(nama, harga);
            } else {
                tambahArmor(nama, harga);
            }
        } catch (EmptyInputException e) {
            System.out.println(e.getMessage());
        } catch (InvalidNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    private void tambahPotion(String nama, double harga) throws EmptyInputException, InvalidNumberException {
        System.out.print("Total unit: ");
        int unit = CLIUtil.readInt();

        System.out.print("HP Restore: ");
        int hp = CLIUtil.readInt();

        System.out.print("Mana Restore: ");
        int mana = CLIUtil.readInt();

        if (unit <= 0 || hp < 0 || mana < 0) {
            throw new InvalidNumberException("Unit harus lebih dari 0 dan restore tidak boleh negatif.");
        }

        Potion potion = new Potion(nama, harga, unit, hp, mana);
        potions.add(potion);

        System.out.println("Potion berhasil ditambahkan.");
    }

    private void tambahWeapon(String nama, double harga) throws EmptyInputException, InvalidNumberException {
        System.out.print("Attack: ");
        int attack = CLIUtil.readInt();

        if (attack < 0) {
            throw new InvalidNumberException("Attack tidak boleh negatif.");
        }

        System.out.println("1. Sword");
        System.out.println("2. Axe");
        System.out.println("3. Spear");
        System.out.println("4. Bow");

        System.out.print("Pilih type: ");
        int pilihan = CLIUtil.readInt();

        WeaponType jenis;

        if (pilihan == 1) {
            jenis = WeaponType.SWORD;
        } else if (pilihan == 2) {
            jenis = WeaponType.AXE;
        } else if (pilihan == 3) {
            jenis = WeaponType.SPEAR;
        } else if (pilihan == 4) {
            jenis = WeaponType.BOW;
        } else {
            throw new InvalidNumberException("Type Weapon tidak tersedia.");
        }

        Weapon weapon = new Weapon(nama, harga, attack, jenis);
        weapons.add(weapon);

        System.out.println("Weapon berhasil ditambahkan.");
    }

    private void tambahArmor(String nama, double harga) throws EmptyInputException, InvalidNumberException {
        System.out.print("Defense: ");
        int defense = CLIUtil.readInt();

        if (defense < 0) {
            throw new InvalidNumberException("Defense tidak boleh negatif.");
        }

        System.out.println("1. Heavy");
        System.out.println("2. Medium");
        System.out.println("3. Light");

        System.out.print("Pilih type: ");
        int pilihan = CLIUtil.readInt();

        ArmorType jenis;

        if (pilihan == 1) {
            jenis = ArmorType.HEAVY;
        } else if (pilihan == 2) {
            jenis = ArmorType.MEDIUM;
        } else if (pilihan == 3) {
            jenis = ArmorType.LIGHT;
        } else {
            throw new InvalidNumberException("Type Armor tidak tersedia.");
        }

        Armor armor = new Armor(nama, harga, defense, jenis);
        armors.add(armor);

        System.out.println("Armor berhasil ditambahkan.");
    }

    public void printBerdasarkanTotalHarga() {
        System.out.println();
        System.out.println("BARANG BERDASARKAN TOTAL HARGA");

        urutkanDanPrint(potions, "Potion", true);
        urutkanDanPrint(weapons, "Weapon", true);
        urutkanDanPrint(armors, "Armor", true);
    }

    public void printBerdasarkanHargaSatuan() {
        System.out.println();
        System.out.println("BARANG BERDASARKAN HARGA SATUAN");

        urutkanDanPrint(potions, "Potion", false);
        urutkanDanPrint(weapons, "Weapon", false);
        urutkanDanPrint(armors, "Armor", false);
    }

    private void urutkanDanPrint(List<AuctionItem> daftar, String kategori, boolean berdasarkanTotal) {
        try {
            if (daftar.isEmpty()) {
                throw new EmptyListException("Belum ada " + kategori + ".");
            }

            for (int i = 0; i < daftar.size() - 1; i++) {
                for (int j = 0; j < daftar.size() - 1 - i; j++) {
                    boolean tukar = false;

                    if (berdasarkanTotal) {
                        if (daftar.get(j).getTotalHarga() > daftar.get(j + 1).getTotalHarga()) {
                            tukar = true;
                        }
                    } else {
                        if (daftar.get(j).getHargaSatuan() > daftar.get(j + 1).getHargaSatuan()) {
                            tukar = true;
                        }
                    }

                    if (tukar) {
                        AuctionItem sementara = daftar.get(j);
                        daftar.set(j, daftar.get(j + 1));
                        daftar.set(j + 1, sementara);
                    }
                }
            }

            System.out.println();
            System.out.println(kategori);

            for (AuctionItem item : daftar) {
                if (berdasarkanTotal) {
                    item.print();
                } else {
                    item.print(true);
                }
            }
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
    }
}