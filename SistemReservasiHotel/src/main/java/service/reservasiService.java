package service;

import model.reservasiModel;
import java.util.ArrayList;

public class reservasiService {
    private ArrayList<reservasiModel> daftarReservasi;
    private int Id;

    public reservasiService() {
        this.daftarReservasi = new ArrayList<>();
        this.Id = 1;
        dataAwal();
    }

    private void dataAwal() {
        tambahReservasi("Larry", "DELUXE", 5);
        tambahReservasi("Polin", "SUITE", 5);
        tambahReservasi("Anugrah", "STANDARD", 5);
    }
    
    private int tarif(String tipe) {
        if (tipe.equalsIgnoreCase("deluxe")) {
            return 400000;
        } else if (tipe.equalsIgnoreCase("suite")) {
            return 750000;
        } else if (tipe.equalsIgnoreCase("standard")) {
            return 250000;
        } else {
            return 0;
        }
    }
    // Create
    public void tambahReservasi(String nama, String tipe, int malam) {
        int total = tarif(tipe) * malam;
        reservasiModel reservasiBaru = new reservasiModel(Id++, nama, tipe, malam, total);
        daftarReservasi.add(reservasiBaru);
    }
    // Read    
    public ArrayList<reservasiModel> getReservasi() {
        return daftarReservasi;
    }
    
    public reservasiModel getReservasiId(int id) {
        for (reservasiModel reservasi : daftarReservasi) {
            if (reservasi.getId() == id) {
                return reservasi;
            }
        }
        return null;
    }
    // Update
    public void perbaruiReservasi(int id, String namaBaru, String tipeBaru, int malamBaru) {
        reservasiModel reservasi = getReservasiId(id);
        if (reservasi != null) {
            reservasi.setNamaTamu(namaBaru);
            reservasi.setTipeKamar(tipeBaru);
            reservasi.setLamaMenginap(malamBaru);
            int totalBaru = tarif(tipeBaru) * malamBaru;
            reservasi.setTotalTarif(totalBaru);
        }
    }
    // Delete
    public boolean hapusReservasi(int id) {
        reservasiModel reservasi = getReservasiId(id);
        if (reservasi != null) {
            daftarReservasi.remove(reservasi);
            return true;
        }
        return false;
    }

    public ArrayList<reservasiModel> cariNama(String nama) {
        ArrayList<reservasiModel> hasil = new ArrayList<>();
        String namaLower = nama.toLowerCase();

        for (reservasiModel reservasi : daftarReservasi) {
            if (reservasi.getNamaTamu().toLowerCase().contains(namaLower)) {
                hasil.add(reservasi);
            }
        }
        return hasil;
    }
    
    public ArrayList<reservasiModel> cariTipe(String tipe) {
        ArrayList<reservasiModel> hasil = new ArrayList<>();
        String tipeLower = tipe.toLowerCase();

        for (reservasiModel reservasi : daftarReservasi) {
            if (reservasi.getTipeKamar().toLowerCase().contains(tipeLower)) {
                hasil.add(reservasi);
            }
        }
        return hasil;
    }

}