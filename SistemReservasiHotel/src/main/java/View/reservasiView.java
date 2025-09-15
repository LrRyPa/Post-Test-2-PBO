package view;

import model.reservasiModel;
import java.util.ArrayList;

public class reservasiView {

    public void mainMenu() {
        System.out.println("\n|======================================|");
        System.out.println("|         Menu Reservasi Hotel         |");
        System.out.println("|======================================|");
        System.out.println("| [1] Tambah Reservasi                 |");
        System.out.println("| [2] Lihat Reservasi                  |");
        System.out.println("| [3] Perbarui Reservasi               |");
        System.out.println("| [4] Hapus Reservasi                  |");
        System.out.println("| [5] Cari Reservasi                   |");
        System.out.println("| [6] Keluar                           |");
        System.out.println("|======================================|");
        System.out.print("Masukkan Pilihan menu: ");
    }

    public void daftarReservasi(ArrayList<reservasiModel> daftar) {
        System.out.println("\n========== Daftar Reservasi ==========");
        if (daftar.isEmpty()) {
            System.out.println("Tidak ada reservasi yang terdaftar.");
        } else {
            for (reservasiModel reservasi : daftar) {
                detailReservasi(reservasi);
                System.out.println("--------------------------------------");
            }
        }
    }

    public void detailReservasi(reservasiModel reservasi) {
        System.out.println("\nID             : " + reservasi.getId());
        System.out.println("Nama           : " + reservasi.getNamaTamu());
        System.out.println("Tipe Kamar     : " + reservasi.getTipeKamar());
        System.out.println("Lama Menginap  : " + reservasi.getLamaMenginap() + " malam");
        System.out.println("Tarif          : Rp " + reservasi.getTotalTarif());
    }
    
        public void infoReservasi(reservasiModel reservasi) {
        System.out.println("========== Data Reservasi ==========");
        System.out.println("Nama           : " + reservasi.getNamaTamu());
        System.out.println("Tipe Kamar     : " + reservasi.getTipeKamar());
        System.out.println("Lama Menginap  : " + reservasi.getLamaMenginap() + " malam");
    }

    public void menuPerbarui() {
        System.out.println("\n======================================");
        System.out.println("|  Pilih data yang ingin diperbarui  |");
        System.out.println("|====================================|");
        System.out.println("| [1] Nama Tamu                      |");
        System.out.println("| [2] Tipe Kamar                     |");
        System.out.println("| [3] Lama Menginap                  |");
        System.out.println("| [4] Semua Data                     |");
        System.out.println("| [5] Batal Perbarui                 |");
        System.out.println("|====================================|");
        System.out.print("Pilihan Anda: ");
    }

    public void menuCari() {
        System.out.println("\n======================================");
        System.out.println("|           Cari Reservasi           |");
        System.out.println("|====================================|");
        System.out.println("| [1] ID Reservasi                   |");
        System.out.println("| [2] Nama Tamu                      |");
        System.out.println("| [3] Tipe Kamar                     |");
        System.out.println("| [4] Keluar                         |");
        System.out.println("|====================================|");
        System.out.print("Masukkan Pilihan menu: ");
    }

    public void hasilPencarian(ArrayList<reservasiModel> hasilPencarian) {
        if (hasilPencarian.isEmpty()) {
            System.out.println("Tidak ditemukan reservasi yang cocok");
        } else {
            System.out.println("\n========== Hasil Pencarian ==========");
            for (reservasiModel reservasi : hasilPencarian) {
                detailReservasi(reservasi);
                System.out.println("--------------------------------------");
            }
        }
    }
}
