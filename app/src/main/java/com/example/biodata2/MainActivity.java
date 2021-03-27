package com.example.biodata2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView txtNama,txtNoHp,txtAlamat,txtNoInduk,txtNama2,txtNoHp2,txtAlamat2,txtNoInduk2;
    ApiInterpace apiInterpace;
    List<Orang> daftarOrang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNama=(TextView)findViewById(R.id.txt_nama);
        txtNoHp=(TextView)findViewById(R.id.txt_NoHp);
        txtAlamat=(TextView)findViewById(R.id.txt_Alamat);
        txtNoInduk=(TextView)findViewById(R.id.txt_NoInduk);
        txtNama2=(TextView)findViewById(R.id.txt_nama2);
        txtNoHp2=(TextView)findViewById(R.id.txt_NoHp2);
        txtAlamat2=(TextView)findViewById(R.id.txt_Alamat2);
        txtNoInduk2=(TextView)findViewById(R.id.txt_NoInduk2);
        apiInterpace=Apiclient.ambilOrang().create(ApiInterpace.class);
        Call<List<Orang>>call=apiInterpace.getDaftarOrang();
        call.enqueue(new Callback<List<Orang>>() {
            @Override
            public void onResponse(Call<List<Orang>> call, Response<List<Orang>> response) {
                daftarOrang=response.body();
                txtNama.setText(daftarOrang.get(0).getNama());
                txtNoHp.setText(daftarOrang.get(0).getNo_hp());
                txtAlamat.setText(daftarOrang.get(0).getAlamat());
                txtNoInduk.setText(daftarOrang.get(0).getNo_induk());
                txtNama2.setText(daftarOrang.get(1).getNama());
                txtNoHp2.setText(daftarOrang.get(1).getNo_hp());
                txtAlamat2.setText(daftarOrang.get(1).getAlamat());
                txtNoInduk2.setText(daftarOrang.get(1).getNo_induk());

            }

            @Override
            public void onFailure(Call<List<Orang>> call, Throwable t) {

            }
        });
    }
}