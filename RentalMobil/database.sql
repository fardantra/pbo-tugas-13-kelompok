CREATE DATABASE rental_db;
USE rental_db;

CREATE TABLE pegawai (
    id_pegawai VARCHAR(10) NOT NULL,
    nama VARCHAR(30),
    alamat VARCHAR(50),
    cp VARCHAR(30),
    username VARCHAR(20),
    password VARCHAR(20),
    kode INT,
    PRIMARY KEY (id_pegawai)
);

CREATE TABLE pelanggan (
    id_pelanggan VARCHAR(10) NOT NULL,
    nama VARCHAR(30),
    cp VARCHAR(30),
    alamat VARCHAR(50),
    PRIMARY KEY (id_pelanggan)
);

CREATE TABLE mobil (
    id_mobil VARCHAR(10) NOT NULL,
    jenis VARCHAR(10),
    sewa BIGINT,
    stok INT,
    PRIMARY KEY (id_mobil)
);

CREATE TABLE peminjaman (
    id_peminjaman VARCHAR(10),
    id_pelanggan VARCHAR(10),
    id_mobil VARCHAR(10),
    id_pegawai VARCHAR(10),
    tgl_pinjam DATE,
    tgl_hrs_kembali DATE,
    lama INT(11),
    telat INT(11),
    biaya BIGINT(20),
    denda BIGINT(20),
    PRIMARY KEY (id_peminjaman),
    FOREIGN KEY (id_pelanggan) REFERENCES pelanggan(id_pelanggan),
    FOREIGN KEY (id_mobil) REFERENCES mobil(id_mobil),
    FOREIGN KEY (id_pegawai) REFERENCES pegawai(id_pegawai)
)