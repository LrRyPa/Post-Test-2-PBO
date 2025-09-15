# Sistem Manajemen Reservasi Hotel
Nama : Larry Polin Anugrah

NIM : 2409116026

Kelas : A

## Deskripsi Program
Program ini merupakan aplikasi sederhana yang dirancang untuk mengelola informasi reservasi hotel. Program ini bertujuan membantu staf hotel dalam mengelola reservasi dengan cepat dan akurat, seperti penambahan (Create), penampilan (Read), pembaruan (Update), dan penghapusan (Delete) data reservasi. Selain itu, program ini juga memanfaatkan struktur data ArrayList untuk menyimpan dan memanipulasi data seperti Id, Nama Tamu, Tipe Kamar, Jumlah Malam, dan Total Tarif.

## Struktur Packages
<img width="499" height="229" alt="image" src="https://github.com/user-attachments/assets/7d4a7a55-e016-4b70-b1ff-6c2614dafe7f" />

Program ini terdiri dari beberapa packages yang memiliki fungsi/tanggung jawab yang berbeda-beda. Pemisahan packages ini dilakukan untuk menerapkan arsitektur MVC (Model-View-Controller) agar kode program menjadi lebih terstruktur, modular, dan mudah untuk dikembangkan.

### Model
<img width="497" height="45" alt="image" src="https://github.com/user-attachments/assets/b9b3791b-6f65-4244-b9e9-bc4a3f98a028" />

Package ini berisikan class **reservasiModel**, yang bertanggung jawab untuk merepresentasikan struktur data, menyimpan atribut data (seperti nama tamu, tipe kamar, dll), serta menyediakan getter dan setter untuk memanipulasi data tersebut.

### View
<img width="500" height="46" alt="image" src="https://github.com/user-attachments/assets/69fceb72-7e3f-47f9-8b3d-03946e6882e2" />

Packages ini berisikan class **reservasiView** yang bertanggung jawab untuk menampilkan data yang diterima dari Model kepada pengguna (User Interface).

### Service
<img width="501" height="49" alt="image" src="https://github.com/user-attachments/assets/9b863351-2a1d-4c02-b85d-a3e306f782c5" />

Packages ini berisikan class **reservasiService** yang bertanggung jawab untuk menerima input dari pengguna (melalui View), yang kemudian memproses data seperti menambahkan, memperbarui, mencari, atau menghapus data dari model.

### Main
<img width="503" height="45" alt="image" src="https://github.com/user-attachments/assets/c3635544-3d4c-48f6-928c-5458f33f6547" />

Package ini berisikan class Main yang bertindak sebagai entry point dari program.
Selain itu, Main juga berfungsi sebagai Controller, yaitu mengatur alur program, menerima input dari pengguna, memanggil service untuk memproses data, dan menggunakan view untuk menampilkan hasil.

## Alur Program
### Menu Utama
<img width="392" height="234" alt="image" src="https://github.com/user-attachments/assets/f8a8a9a8-3048-40ba-bf35-43dd7c577507" />


Gambar di atas merupakan menu awal, yang meminta pengguna untuk memilih opsi menu yang tersedia. <br>Terdapat 5 opsi pada menu utama, yaitu:

1. Tambah Reservasi: untuk membuat reservasi baru.
2. Lihat Reservasi: untuk menampilkan semua data yang tersimpan.
3. Perbarui Reservasi: untuk mengubah data reservasi yang tersedia.
4. Hapus Reservasi: untuk menghapus data reservasi yang tersedia.
5. Cari Reservasi: untuk mencari data reservasi yang tersedia.
6. Keluar:  untuk menghentikan program. 

Setelah mengetahui opsi yang diinginkan, pengguna dapat menginputkan opsi yang diinginkan (1-6).

#### Validasi Input
<img width="446" height="514" alt="image" src="https://github.com/user-attachments/assets/44564c32-f64f-4632-9a00-f02e384bc1ca" />

Jika pengguna menginputkan opsi diluar rentang opsi yang tersedia (1-6) seperti 7. Maka program akan menampilkan pesan "Pilihan tidak tersedia, silahkan input kembali!", yang kemudian menampilkan kembali ke menu utama agar pengguna dapat menginputkan kembali opsi yang diinginkan.

<img width="413" height="513" alt="image" src="https://github.com/user-attachments/assets/2a0e3974-a4f1-4068-9a02-84ab78ed30aa" />

Jika pengguna menginputkan opsi berupa teks seperti contoh di atas "tes". Maka program akan menampilkan pesan "Input tidak valid, silahkan masukkan angka", yang kemudian menampilkan kembali ke menu utama agar pengguna dapat menginputkan kembali opsi yang diinginkan.

### 1. Tambah Reservasi
<img width="419" height="181" alt="image" src="https://github.com/user-attachments/assets/76e89ced-5262-46ce-b348-3e74518635cb" />

Pengguna akan diminta untuk menginputkan data reservasi yang akan ditambahkan, seperti Nama Tamu, Tipe Kamar dan  Lama Menginap (jumlah malam). <br>Setelah itu, program akan melakukan perhitungan total tarif berdasarkan tipe kamar dan jumlah malam yang diinputkan pengguna. 
Pembagian Tipe kamar dibagi menjadi 3 tipe dengan harga yang berbeda-beda.  
Rincian Harga:
* Deluxe   = Rp 400.000
* Suite    = Rp 750.000
* Standard = Rp 250.000

Lalu program akan melakukan perhitungan aritmatika perkalian: <br>
**Harga Tipe Kamar** (Deluxe/Suite/Standard) * **Jumlah malam (Lama Menginap)**

#### Validasi Input
* Nama Tamu
<img width="495" height="91" alt="image" src="https://github.com/user-attachments/assets/ce0de0a7-939a-4254-b410-8ac953d38b66" />

Jika pengguna menginputkan nama tamu berupa angka. Maka program akan menampilkan pesan "Nama tidak valid, Silahkan masukkan nama berupa huruf", yang kemudian menampilkan kembali inputan untuk nama tamu yang akan ditambahkan.

* Tipe Kamar
<img width="605" height="107" alt="image" src="https://github.com/user-attachments/assets/f877dd93-cfdf-4ec6-a595-abd659542f65" />

Jika pengguna menginputkan tipe kamar selain tipe kamar yang tersedia (Deluxe, Suite, dan Standard). Maka program akan menampilkan pesan "Tipe kamar tidak valid. Pilih 'Deluxe', 'Suite', atau 'Standard, yang kemudian menampilkan kembali inputan tipe kamar yang akan ditambahkan.

* Lama Menginap (malam)
<img width="408" height="66" alt="image" src="https://github.com/user-attachments/assets/aa92e9f9-b73b-4867-9675-ce587b318d73" />

Jika pengguna menginputkan lama menginap berupa teks. Maka program akan menampilkan pesan "Input tidak valid. Silahkan masukkan angka", yang kemudian menampilkan kembali inputan untuk lama menginap yang akan ditambahkan.

<img width="332" height="65" alt="image" src="https://github.com/user-attachments/assets/7713760c-529f-44d5-ac53-9bc4d48ae15e" />

Jika pengguna menginputkan lama menginap kurang dari 0. Maka program akan menampilkan pesan "Lama menginap harus lebih dari 0", yang kemudian menampilkan kembali inputan untuk lama menginap yang akan ditambahkan.

### 2. Lihat Reservasi
<img width="385" height="664" alt="image" src="https://github.com/user-attachments/assets/6d2e58f7-6313-4d6d-9ce1-3f4434cf3ffa" />

Program akan menampilkan daftar semua reservasi yang tersimpan kepada pengguna.

### 3. Perbarui Reservasi 
<img width="426" height="701" alt="image" src="https://github.com/user-attachments/assets/02e2fa01-76eb-4e4e-b1c7-0f0058f65bde" />

Program akan menampilkan daftar reservasi yang tersimpan terlebih dahulu untuk memudahkan pengguna dalam memilih reservasi yang akan diubah, kemudian program meminta pengguna untuk menginputkan "ID Reservasi" yang ingin diperbarui.

<img width="419" height="125" alt="image" src="https://github.com/user-attachments/assets/517988fb-fa95-4723-892b-428e1b3ad724" />

Setelah menginputkan reservasi yang akan diperbarui, program akan menampilkan informasi reservasi yang diinputkan seperti Nama Tamu, Tipe Kamar, dan Jumlah Malam (Lama Menginap).

<img width="404" height="325" alt="image" src="https://github.com/user-attachments/assets/0b967c65-b60a-48cd-8969-96d314caf6b7" />

Lalu, program akan memberikan beberapa opsi kepada pengguna dalam memperbarui data reservasinya.
1. Nama Tamu: untuk mengubah nama tamu saja.
2. Tipe Kamar: untuk mengubah tipe kamar saja.
3. Lama Menginap: untuk mengubah jumlah malam (lama menginap) saja.
4. Semua data: untuk mengubah data nama tamu, tipe kamar, dan lama menginap)
5. Batal Perbarui: untuk keluar dari perbarui data.

#### 1. Nama Tamu
<img width="378" height="296" alt="image" src="https://github.com/user-attachments/assets/af137636-9b5a-4639-80a8-39fd36502483" />


Program akan meminta pengguna untuk menginputkan nama tamu yang terbaru. Setelah itu, program akan menampilkan pesan bahwa pembaruan nama tamu berhasil dilakukan, kemudian kembali ke menu utama.


<img width="347" height="118" alt="image" src="https://github.com/user-attachments/assets/69b6913a-62b1-435b-b12d-577cc9e910c1" />

Tampilan nama tamu setelah diperbarui.

#### Validasi Input
<img width="501" height="275" alt="image" src="https://github.com/user-attachments/assets/1b29e466-1723-466e-bd83-001d858c37be" />

Jika pengguna menginputkan nama tamu berupa angka. Maka program akan menampilkan pesan "Nama tidak valid, Silahkan masukkan nama berupa huruf", yang kemudian menampilkan kembali inputan untuk nama tamu yang akan diperbarui.

#### 2. Tipe Kamar
<img width="429" height="301" alt="image" src="https://github.com/user-attachments/assets/bbedba57-2806-464d-9778-4251611da9e2" />


Program akan meminta pengguna untuk menginputkan tipe kamar yang terbaru. Setelah itu, program akan menampilkan pesan bahwa pembaruan tipe kamar berhasil dilakukan, kemudian kembali ke menu utama.
Lalu tarif reservasi akan diperbarui juga dikarenakan adanya perubahan tipe kamar.

<img width="335" height="111" alt="image" src="https://github.com/user-attachments/assets/e1a66a09-aa4d-498d-894f-f118d8cf1a7c" />

Tampilan tipe kamar setelah diperbarui.

#### Validasi Input
<img width="583" height="279" alt="image" src="https://github.com/user-attachments/assets/00ee662c-ddda-4fc2-99bd-50e7ff58bc40" />

Jika pengguna menginputkan tipe kamar selain tipe kamar yang tersedia (Deluxe, Suite, dan Standard). Maka program akan menampilkan pesan "Tipe kamar tidak valid. Pilih 'Deluxe', 'Suite', atau 'Standard, yang kemudian menampilkan kembali inputan tipe kamar yang akan diperbarui.

#### 3. Lama Menginap
<img width="375" height="295" alt="image" src="https://github.com/user-attachments/assets/4e6bd253-4440-443c-b26b-669e9b85484d" />


Program akan meminta pengguna untuk menginputkan jumlah malam yang terbaru. Setelah itu, program akan menampilkan pesan bahwa pembaruan tipe kamar berhasil dilakukan, kemudian kembali ke menu utama. 
Lalu tarif reservasi akan diperbarui juga dikarenakan adanya perubahan lama menginap (jumlah malam).

<img width="334" height="112" alt="image" src="https://github.com/user-attachments/assets/ae83f45c-d3f7-4ead-b74e-52ac6f8ce56e" />

Tampilan lama menginap setelah diperbarui.

#### Validasi Input
<img width="424" height="281" alt="image" src="https://github.com/user-attachments/assets/3698f8d1-32cc-4003-a40f-79e1571636b3" />

Jika pengguna menginputkan lama menginap berupa teks. Maka program akan menampilkan pesan "Input tidak valid. Silahkan masukkan angka", yang kemudian menampilkan kembali inputan untuk lama menginap yang akan diperbarui.


#### 4. Semua Data
<img width="383" height="348" alt="image" src="https://github.com/user-attachments/assets/4fb16c59-b8e2-49df-a582-b9b6c6816914" />


Program akan meminta pengguna untuk menginputkan nama tamu, tipe kamar, jumlah malam yang terbaru. Setelah itu, program akan menampilkan pesan bahwa pembaruan data reservasi berhasil dilakukan, kemudian kembali ke menu utama.

<img width="347" height="108" alt="image" src="https://github.com/user-attachments/assets/1af9f45c-22b0-47d8-99d0-9859bc012dae" />

Tampilan data reservasi setelah diperbarui.

#### Validasi Input
* Nama Tamu
<img width="495" height="280" alt="image" src="https://github.com/user-attachments/assets/0f6c00bb-ae13-4828-9715-af7592268c31" />

Jika pengguna menginputkan nama tamu berupa angka. Maka program akan menampilkan pesan "Nama tidak valid, Silahkan masukkan nama berupa huruf", yang kemudian menampilkan kembali inputan untuk nama tamu yang akan diperbarui.

* Tipe Kamar
<img width="576" height="342" alt="image" src="https://github.com/user-attachments/assets/236e5a1e-c29f-47cb-bd4c-92563fa8add0" />

Jika pengguna menginputkan tipe kamar selain tipe kamar yang tersedia (Deluxe, Suite, dan Standard). Maka program akan menampilkan pesan "Tipe kamar tidak valid. Pilih 'Deluxe', 'Suite', atau 'Standard, yang kemudian menampilkan kembali inputan tipe kamar yang akan diperbarui.

* Lama Menginap
<img width="582" height="407" alt="image" src="https://github.com/user-attachments/assets/8c3e48c2-ec06-4d49-a7f0-5040b539c1d8" />

Jika pengguna menginputkan lama menginap berupa teks. Maka program akan menampilkan pesan "Input tidak valid. Silahkan masukkan angka", yang kemudian menampilkan kembali inputan untuk lama menginap yang akan diperbarui.

#### 5. Batal Perbarui
<img width="373" height="278" alt="image" src="https://github.com/user-attachments/assets/b6a59e69-a527-4686-b5d5-22077c8491ec" />


Program menampilkan pesan bahwa pembaruan data dibatalkan, kemudian kembali ke menu utama.

### 4. Hapus Reservasi
<img width="443" height="721" alt="image" src="https://github.com/user-attachments/assets/77f67b82-da5b-4a57-914d-e15fedc2eb2d" />

Program akan menampilkan daftar reservasi yang tersimpan terlebih dahulu untuk memudahkan pengguna dalam memilih reservasi yang akan dihapus, kemudian program meminta pengguna untuk menginputkan "ID Reservasi" yang ingin dihapus.


<img width="403" height="317" alt="image" src="https://github.com/user-attachments/assets/9927dad3-2f10-459f-966c-cc4374b52b15" />

Setelah menginputkan reservasi yang akan dihapus, program akan menampilkan pesan untuk memastikan penghapusan reservasi akan dilakukan atau tidak (y/n). Setelah pengguna, memilih melanjutkan penghapusan data reservasi (y). Program akan menampilkan pesan bahwa penghapusan data reservasi berhasil dilakukan, kemudian kembali ke menu utama.

### 5. Cari Reservasi
<img width="381" height="234" alt="image" src="https://github.com/user-attachments/assets/ada5954b-5101-4174-83d3-22d8b4891cc7" />

Program akan menampilkan menu "Cari Reservasi" yang memberikan beberapa opsi kepada pengguna dalam mencari data reservasinya.
1. ID Reservasi: untuk mengubah nama tamu saja.
2. Nama Tamu: untuk mengubah tipe kamar saja.
3. Tipe Kamar: untuk mengubah jumlah malam (lama menginap) saja.
4. Keluar: untuk mengubah data nama tamu, tipe kamar, dan lama menginap)

#### Validasi Input
<img width="427" height="426" alt="image" src="https://github.com/user-attachments/assets/919d9d22-d99c-4b6b-b548-d6f96ed4d965" />

Jika pengguna menginputkan opsi diluar rentang opsi yang tersedia (1-4) seperti 5. Maka program akan menampilkan pesan "Pilihan tidak tersedia, silahkan input kembali!", yang kemudian menampilkan kembali ke menu "Cari Reservasi" agar pengguna dapat menginputkan kembali opsi yang diinginkan.

#### 1. ID Reservasi
<img width="379" height="448" alt="image" src="https://github.com/user-attachments/assets/b4dbd7f6-2787-42e0-bbc6-2f902ff72b95" />

Program akan meminta pengguna untuk menginputkan ID Reservasi yang akan dicari. Program akan mengecek data reservasi yang memiliki ID Reservasi yang serupa, lalu menampilkan informasi reservasinya kepada pengguna. Setelah itu, program akan kembali ke menu "Cari Reservasi" untuk memudahkan pengguna jika ingin melakukan pencarian reservasi kembali.

#### Validasi Input
<img width="453" height="274" alt="image" src="https://github.com/user-attachments/assets/53e721d9-5734-4c88-a5fb-cbf3576473ba" />

Jika pengguna menginputkan ID Reservasi berupa teks atau angka id yang tidak sesuai. Maka program akan menampilkan pesan bahwa input tidak valid atau reservasi tidak ditemukan, yang kemudian kembali ke menu "Cari Reservasi".

#### 2. Nama Tamu
<img width="368" height="443" alt="image" src="https://github.com/user-attachments/assets/8bcb2789-3f10-406d-b42e-1449fad2f70e" />

Program akan meminta pengguna untuk menginputkan nama tamu yang akan dicari (kata kuncinya). Program akan mengecek data reservasi yang memiliki kata kunci yang serupa, lalu menampilkan informasi reservasinya kepada pengguna. Setelah itu, program akan kembali ke menu "Cari Reservasi" untuk memudahkan pengguna jika ingin melakukan pencarian reservasi kembali.

#### Validasi Input
<img width="355" height="276" alt="image" src="https://github.com/user-attachments/assets/3c7acdd2-eb21-4c5c-9238-d38bf439daad" />

Jika pengguna menginputkan nama tamu berupa kata kunci yang tidak sesuai. Maka program akan menampilkan pesan bahwa tidak ditemukan data reservasi yang sesuai, yang kemudian kembali ke menu "Cari Reservasi".

#### 3. Tipe Kamar
<img width="479" height="446" alt="image" src="https://github.com/user-attachments/assets/1b394028-30fc-4422-82a3-77aff2b472b6" />

Program akan meminta pengguna untuk menginputkan tipe kamar yang akan dicari (kata kuncinya). Program akan mengecek data reservasi yang memiliki kata kunci yang serupa, lalu menampilkan informasi reservasinya kepada pengguna. Setelah itu, program akan kembali ke menu "Cari Reservasi" untuk memudahkan pengguna jika ingin melakukan pencarian reservasi kembali.

#### Validasi Input
<img width="463" height="279" alt="image" src="https://github.com/user-attachments/assets/87cf738b-db0f-4e66-8461-2089baf3f349" />

Jika pengguna menginputkan tipe kamar berupa kata kunci yang tidak sesuai. Maka program akan menampilkan pesan bahwa tidak ditemukan data reservasi yang sesuai, yang kemudian kembali ke menu "Cari Reservasi".

<img width="416" height="422" alt="image" src="https://github.com/user-attachments/assets/8d8cb3ff-7b22-4fd2-8713-3262f74b559a" />

Jika pengguna menginputkan opsi berupa teks seperti contoh di atas "tes". Maka program akan menampilkan pesan "Input tidak valid, silahkan masukkan angka", yang kemudian menampilkan kembali ke menu "Cari Reservasi" agar pengguna dapat menginputkan kembali opsi yang diinginkan.

#### 4. Keluar
<img width="398" height="274" alt="image" src="https://github.com/user-attachments/assets/a38df739-aa6a-4d8d-a582-eb159bcaa8fb" />

Program secara otomatis kembali ke menu utama.

### 6. Keluar
<img width="666" height="409" alt="image" src="https://github.com/user-attachments/assets/9b440528-7000-4f7a-8501-8cefc5a26ffa" />

Program akan menampilkan pesan bahwa program telah berhenti/selesai.
