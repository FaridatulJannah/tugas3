package com.example.tugas3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.NumberFormat;
import java.util.Locale;

public class bonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bon);

        TextView tvNama = findViewById(R.id.tvNama);
        TextView tvKode = findViewById(R.id.tvKode);
        TextView tvNamaBarang = findViewById(R.id.tvNamabrg);
        TextView tvHargaBarang = findViewById(R.id.tvHargabrg);
        TextView tvJumlah = findViewById(R.id.tvJumlah);
        TextView tvDiskon = findViewById(R.id.tvDiskon);
        TextView tvDiskonMember = findViewById(R.id.tvDiskonMember);
        TextView tvTotalPrice = findViewById(R.id.tvJmlhBayar);
        TextView tvterimaksh = findViewById(R.id.tvThankYou);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("Nama");
        String kodebarang = intent.getStringExtra("Kodebarang");
        String namabarang = intent.getStringExtra("Nama Barang");
        int hargaBarang = intent.getIntExtra("Harga Barang", 0);
        int jumlah = intent.getIntExtra("Jumlah", 0);
        int diskon = intent.getIntExtra("Diskon", 0);
        double diskonMember = intent.getDoubleExtra("Diskon Member", 0);
        int hargaBayar = intent.getIntExtra("Harga Bayar", 0);
        String makasih = intent.getStringExtra("Terima kasih");

        tvNama.setText(getString(R.string.nama)+ nama );
        tvKode.setText(getString(R.string.masukkan_kode) + kodebarang);
        tvNamaBarang.setText(getString(R.string.nama_barang) + namabarang);
        tvHargaBarang.setText(getString(R.string.harga_barang) + hargaBarang);
        tvJumlah.setText(getString(R.string.jumlah_barang) + jumlah);
        tvDiskon.setText(getString(R.string.diskon_belanja)+"Rp. " + diskon);
        tvDiskonMember.setText(getString(R.string.diskon_member) + "Rp. "+ diskonMember );
        tvTotalPrice.setText(getString(R.string.jumlah_bayar) +"Rp."+ hargaBayar);
        tvterimaksh.setText(getString(R.string.terima_kasih) + makasih);

        Button btnshare = findViewById(R.id.btnshare);

        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat string yang akan dibagikan
                String text = getString(R.string.nama) + nama + "\n" +
                        getString(R.string.masukkan_kode) + kodebarang + "\n" +
                        getString(R.string.nama_barang) + namabarang + "\n" +
                        getString(R.string.harga_barang) + hargaBarang + "\n" +
                        getString(R.string.jumlah_barang) + jumlah + "\n" +
                        getString(R.string.diskon_belanja) + "Rp. " + diskon + "\n" +
                        getString(R.string.diskon_member) + "Rp. " + diskonMember + "\n" +
                        getString(R.string.jumlah_bayar) + "Rp." + hargaBayar + "\n" +
                        getString(R.string.terima_kasih) + makasih;

                // Membuat intent untuk berbagi
                Intent share = new Intent();
                share.setAction(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, text);

                // Memulai aktivitas berbagi
                startActivity(Intent.createChooser(share, "Bagikan dengan"));
            }
        });

    }
}