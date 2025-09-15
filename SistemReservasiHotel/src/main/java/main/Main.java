package main;

import service.reservasiService;
import model.reservasiModel;
import view.reservasiView;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        reservasiService reservasiservice = new reservasiService();
        reservasiView view = new reservasiView();

        boolean kondisi = true;

        while (kondisi) {
            view.mainMenu();
            try {
                int pilih = input.nextInt();
                input.nextLine();
                if (pilih == 1){
                    tambahReservasi(input, reservasiservice);
                } else if (pilih == 2){
                    tampilkanReservasi(reservasiservice, view);
                } else if (pilih == 3){
                    perbaruiReservasi(input, reservasiservice, view);
                } else if (pilih == 4){
                    hapusReservasi(input, reservasiservice, view);
                } else if (pilih == 5){
                    cariReservasi(input, reservasiservice, view);
                }else if (pilih == 6){
                    kondisi = false;
                    System.out.println("\nTerima kasih, program selesai. Silahkan running kembali di lain waktu :) ");
                } else {
                    System.out.println("pilihan tidak tersedia, silahkan input kembali!");
                }
            } catch (InputMismatchException e){
                System.out.print("Input tidak valid, silahkan masukkan angka\n");
                input.nextLine();
            }
        }
    }

    private static void tambahReservasi(Scanner input, reservasiService service) {
        System.out.println("\n======= Tambah Reservasi ==========");
        String nama = inputNama(input);
        String tipe = inputTipe(input);
        int malam = inputLamaMenginap(input);

        service.tambahReservasi(nama, tipe, malam);
        System.out.println("Reservasi berhasil ditambahkan!");
    }

    private static void tampilkanReservasi(reservasiService service, reservasiView view) {
        ArrayList <reservasiModel> daftar = service.getReservasi();
        view.daftarReservasi(daftar);
    }

    private static void perbaruiReservasi(Scanner input, reservasiService service, reservasiView view) {
        if (service.getReservasi().isEmpty()) {
            System.out.println("Tidak ada reservasi untuk diperbarui.");
            return;
        }

        tampilkanReservasi(service, view);
        System.out.print("\nMasukkan ID reservasi yang ingin diperbarui: ");
        try {
            int id_reservasi = Integer.parseInt(input.nextLine().trim());
            reservasiModel reservasi = service.getReservasiId(id_reservasi);

            if (reservasi != null) {
                view.infoReservasi(reservasi);

                String namaBaru = reservasi.getNamaTamu();
                String tipeBaru = reservasi.getTipeKamar();
                int malamBaru = reservasi.getLamaMenginap();
                int pilihan = 0;
                boolean batal = false;

                while (true) {
                    view.menuPerbarui();
                    try {
                        pilihan = input.nextInt();
                        input.nextLine();
                        if (pilihan == 1) {
                            namaBaru = inputNama(input);
                            System.out.println("Nama Tamu Berhasil Diperbarui!");
                            break;
                        } else if (pilihan == 2) {
                            tipeBaru = inputTipe(input);
                            System.out.println("Tipe Kamar Berhasil Diperbarui!");
                            break;
                        } else if (pilihan == 3) {
                            malamBaru = inputLamaMenginap(input);
                            System.out.println("Lama Menginap Berhasil Diperbarui!");
                            break;
                        } else if (pilihan == 4) {
                            namaBaru = inputNama(input);
                            tipeBaru = inputTipe(input);
                            malamBaru = inputLamaMenginap(input);
                            System.out.println("Reservasi Berhasil Diperbarui!");
                            break;
                        } else if (pilihan == 5) {
                            System.out.println("Pembaruan dibatalkan.");
                            batal = true;
                            break;
                        } else {
                            System.out.println("Pilihan tidak sesuai, coba lagi!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.print("Input tidak valid, masukkan angka.");
                        input.nextLine();
                    }
                }

                if (!batal) {
                    service.perbaruiReservasi(id_reservasi, namaBaru, tipeBaru, malamBaru);
                }

            } else {
                System.out.println("ID tidak valid.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Masukkan ID berupa angka.");
        }
    }

    private static void hapusReservasi(Scanner input, reservasiService service, reservasiView view) {
        if (service.getReservasi().isEmpty()) {
            System.out.println("Tidak ada reservasi untuk dihapus.");
            return;
        }

        tampilkanReservasi(service, view);
        System.out.println("\n========== Hapus Reservasi ==========");
        System.out.print("Masukkan ID reservasi yang ingin dihapus: ");
        try {
            int id_reservasi = Integer.parseInt(input.nextLine().trim());
            if (service.getReservasiId(id_reservasi) != null){
                System.out.print("Yakin ingin menghapus ID " + id_reservasi + " ? (y/n): ");
                String konfir = input.nextLine().trim();
                
                if (konfir.equalsIgnoreCase("y")) {
                    if (service.hapusReservasi(id_reservasi)) {
                        System.out.println("Reservasi berhasil dihapus!");
                    } else {
                        System.out.println("ID tidak valid.");
                    }
                } else if (konfir.equalsIgnoreCase("n")){
                    System.out.println("Penghapusan dibatalkan");
                } else {
                    System.out.println("Input tidak valid");
                }
            } else {
                System.out.println("ID tidak valid");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Masukkan ID berupa angka.");
        }
    }
    
private static void cariReservasi(Scanner input, reservasiService service, reservasiView view) {
    while (true) {
        view.menuCari();

        try {
            int pilihan = input.nextInt();
            input.nextLine(); 

            if (pilihan == 1) {
                System.out.print("Masukkan ID Reservasi: ");
                try {
                    int id = input.nextInt();
                    input.nextLine(); 

                    reservasiModel hasil = service.getReservasiId(id);

                    if (hasil != null) {
                        System.out.println("\n========== Hasil Pencarian ==========");
                        view.detailReservasi(hasil);
                        System.out.println("--------------------------------------");
                    } else {
                        System.out.println("Reservasi dengan ID " + id + " tidak ditemukan.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input tidak valid. Harap masukkan angka untuk ID.");
                    input.nextLine();
                }
            } else if (pilihan == 2) {
                System.out.print("Masukkan Nama Tamu: ");
                String nama = input.nextLine().trim();
                
                if (nama.isEmpty()) {
                    System.out.println("Nama tamu tidak boleh kosong.");
                } else {
                    ArrayList<reservasiModel> hasilPencarian = service.cariNama(nama);
                    view.hasilPencarian(hasilPencarian);
                }
            } else if (pilihan == 3) {
                System.out.print("Masukkan Tipe Kamar (Deluxe, Suite, Standard): ");
                String tipe = input.nextLine().trim();

                if (tipe.isEmpty()) {
                    System.out.println("Tipe kamar tidak boleh kosong.");
                } else {
                    ArrayList<reservasiModel> hasilPencarian = service.cariTipe(tipe);
                    view.hasilPencarian(hasilPencarian);
                }
            } else if (pilihan == 4) {
                return;
            } else {
                System.out.println("Pilihan tidak sesuai, silahkan input kembali!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid, silahkan masukkan angka.");
            input.nextLine();
        }
    }
}

    private static String inputNama(Scanner input) {
        while (true) {
            System.out.print("Nama Tamu: ");
            String nama = input.nextLine().trim();
            try {
                Integer.parseInt(nama);
                System.out.println("Nama tidak valid, Silahkan masukkan nama berupa huruf");
            } catch (NumberFormatException e){
                if (!nama.isEmpty()) {
                    return nama;
                }
                System.out.println("Nama tidak boleh kosong. Coba lagi.");
            }
        }
    }

    private static String inputTipe(Scanner input) {
        while (true) {
            System.out.print("Tipe Kamar (Deluxe, Suite, Standard): ");
            String tipe = input.nextLine().trim().toUpperCase();
            if (tipe.equalsIgnoreCase("DELUXE") || tipe.equalsIgnoreCase("SUITE") || tipe.equalsIgnoreCase("STANDARD")) {
                return tipe;
            }
            System.out.println("Tipe kamar tidak valid. Pilih 'Deluxe', 'Suite' atau 'Standard.");
        }
    }

    private static int inputLamaMenginap(Scanner input) {
        while (true) {
            System.out.print("Lama Menginap (malam): ");
            try {
                int malam = Integer.parseInt(input.nextLine().trim());
                if (malam > 0) {
                    return malam;
                }
                System.out.println("Lama menginap harus lebih dari 0.");
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Silahkan masukkan angka.");
            }
        }
    }
 
}