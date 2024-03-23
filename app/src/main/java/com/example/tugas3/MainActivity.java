package com.example.tugas3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNama = findViewById(R.id.isinama);
        EditText etKodebrg = findViewById(R.id.isikode);
        EditText etJumlahbrg = findViewById(R.id.jumlahbeli);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Button btnPesan = findViewById(R.id.btnPesan);

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNama.getText().toString();
                String kodebarang = etKodebrg.getText().toString().toUpperCase();
                int jumlahbarang = Integer.parseInt(etJumlahbrg.getText().toString());
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedId);
                String membership = radioButton.getText().toString();

                int hargaBarang = 0;
                switch (kodebarang) {
                    case "SGS":
                        hargaBarang = 12999999;
                        break;
                    case "O17":
                        hargaBarang = 2500999;
                        break;
                    case "MP3":
                        hargaBarang = 28999999;
                        break;
                    default:
                        etKodebrg.setError("Kode barang tidak valid");
                        return;
                }
                String namaBarang = "";
                switch (kodebarang) {
                    case "SGS":
                        namaBarang = "Samsung Galaxy S";
                        break;
                    case "O17":
                        namaBarang = "Oppo A17";
                        break;
                    case "MP3":
                        namaBarang = "Macbook Pro M3";
                        break;
                    default:
                        namaBarang = "Nama Barang Tidak Dikenal";
                        break;
                }

                int diskon = 0;
                int totalHarga = hargaBarang * jumlahbarang;
                if (totalHarga > 10000000) {
                    diskon = 100000;
                }

                double diskonMember = 0;
                switch (membership) {
                    case "Gold":
                        diskonMember = 0.1 * totalHarga;
                        break;
                    case "Silver":
                        diskonMember = 0.05 * totalHarga;
                        break;
                    case "Biasa":
                        diskonMember = 0.02 * totalHarga;
                        break;
                }

                int hargaBayar = (int) (totalHarga - diskon - diskonMember);

                Intent beli = new Intent(MainActivity.this, bonActivity.class);
                beli.putExtra("Nama", nama);
                beli.putExtra("Kodebarang", kodebarang);
                beli.putExtra("Nama Barang", namaBarang);
                beli.putExtra("Harga Barang", hargaBarang);
                beli.putExtra("Jumlah", jumlahbarang);
                beli.putExtra("Diskon", diskon);
                beli.putExtra("Diskon Member", diskonMember);
                beli.putExtra("Harga Bayar", hargaBayar);
                startActivity(beli);
            }
        });
    }
}