package id.sch.smktelkom_mlg.tugas01.xiirpl4036.aplikasihotel3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etNoHP, etEmail, etAlamat, etTglMasuk, etTglKeluar;
    Button btnOk;
    TextView TvHasil;
    CheckBox cbStandart, cbSuperior, cbDuluxe, cbJunior, cbSuite, cbPresidential;
    //    RadioButton rbLk, rbPr;
    RadioGroup rgJK;
    Spinner spKapasitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNoHP = (EditText) findViewById(R.id.editTextNoTelp);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        etTglMasuk = (EditText) findViewById(R.id.editTextTanggalMasuk);
        etTglKeluar = (EditText) findViewById(R.id.editTextTanggalKeluar);

        cbStandart = (CheckBox) findViewById(R.id.checkBoxStandartR);
        cbSuperior = (CheckBox) findViewById(R.id.checkBoxSuperiorR);
        cbDuluxe = (CheckBox) findViewById(R.id.checkBoxDuluxeR);
        cbJunior = (CheckBox) findViewById(R.id.checkBoxJuniorR);
        cbSuite = (CheckBox) findViewById(R.id.checkBoxSuiteR);
        cbPresidential = (CheckBox) findViewById(R.id.checkBoxPresidentialR);

        //      rbLk = (RadioButton) findViewById(R.id.radioButtonLK);
        //    rbPr = (RadioButton) findViewById(R.id.radioButtonPR);

        rgJK = (RadioGroup) findViewById(R.id.radiogroupJK);

        spKapasitas = (Spinner) findViewById(R.id.spinnerKapasitas);

        TvHasil = (TextView) findViewById(R.id.textViewHasil);
        //TvLama = (TextView) findViewById(R.id.textViewLama);

        btnOk = (Button) findViewById(R.id.buttonOK);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doClick();

            }
        });
    }

    private void doClick() {
        if (isValid())
        {

            String nama, no, email, alamat, tglmasuk, tglkeluar;
            nama = etNama.getText().toString();
            no = etNoHP.getText().toString();
            email = etEmail.getText().toString();
            alamat = etAlamat.getText().toString();
            tglmasuk = etTglMasuk.getText().toString();
            tglkeluar = etTglKeluar.getText().toString();
            //int masuk = Integer.parseInt(etTglMasuk.getText().toString());
            //int keluar = Integer.parseInt(etTglKeluar.getText().toString());
            //int lama = (keluar - masuk) / 1000000;

            String jenis = "Jenis Kamar : \n";
            int startlen = jenis.length();
            if(cbStandart.isChecked()) jenis+=cbStandart.getText()+"\n";
            if(cbSuperior.isChecked()) jenis+=cbSuperior.getText()+"\n";
            if(cbDuluxe.isChecked()) jenis+=cbDuluxe.getText()+"\n";
            if(cbJunior.isChecked()) jenis+=cbJunior.getText()+"\n";
            if(cbSuite.isChecked()) jenis+=cbSuite.getText()+"\n";
            if(cbPresidential.isChecked()) jenis+=cbPresidential.getText()+"\n";

            if(jenis.length()==startlen) jenis+="Tidak ada pada pilihan";

            String hasil = null;

            if(rgJK.getCheckedRadioButtonId()!=-1)
            {
                RadioButton rb = (RadioButton)
                        findViewById(rgJK.getCheckedRadioButtonId());
                hasil = rb.getText().toString();
            }

            if (hasil == null)
            {
                TvHasil.setText("Belum Memilih Jenis Kelamin");
            }
            else {
                //TvLama.setText("Lama Inap : " + lama);
                TvHasil.setText("Nama Pemesan : " + nama + "\n" +
                        "No Telp/HP : " + no + "\n" +
                        "Email : " + email + "\n" +
                        "Jenis Kelamin : " + hasil + "\n" +
                        "Alamat : " + alamat + "\n" +
                        "Tanggal Masuk : " + tglmasuk + "\n" +
                        "Tanggal Keluar : " + tglkeluar + "\n" +
                        //"Lama Inap : " + lama + "\n" +
                        jenis + "\n" +
                        "Kapasitas Kamar : " + spKapasitas.getSelectedItem().toString()
                );
            }
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama, no, email, alamat, tglmasuk, tglkeluar;
        nama = etNama.getText().toString();
        no = etNoHP.getText().toString();
        email = etEmail.getText().toString();
        alamat = etAlamat.getText().toString();
        tglmasuk = etTglMasuk.getText().toString();
        tglkeluar = etTglKeluar.getText().toString();

        if(nama.isEmpty()){
            etNama.setError("Nama Pemesan Belum Diisi");
            valid = false;
        }
        else {
            etNama.setError(null);
        }

        if(no.isEmpty()){
            etNoHP.setError("No. Telp/HP Belum Diisi");
            valid = false;
        }
        else {
            etNoHP.setError(null);
        }

        if(email.isEmpty()){
            etEmail.setError("Email Pemesan Belum Diisi");
            valid = false;
        }
        else {
            etEmail.setError(null);
        }

        if(alamat.isEmpty()){
            etAlamat.setError("Alamat Pemesan Belum Diisi");
            valid = false;
        }
        else {
            etAlamat.setError(null);
        }

        if(tglmasuk.isEmpty()){
            etTglMasuk.setError("Tanggal Masuk Belum Diisi");
            valid = false;
        }
        else if(tglmasuk.length()!=8){
            etTglMasuk.setError("Format tanggal masuk bukan ddmmyyyy");
            valid = false;
        }
        else {
            etTglMasuk.setError(null);
        }

        if(tglkeluar.isEmpty()){
            etTglKeluar.setError("Tanggal Masuk Belum Diisi");
            valid = false;
        }
        else if(tglkeluar.length()!=8){
            etTglKeluar.setError("Format tanggal masuk bukan ddmmyyyy");
            valid = false;
        }
        else {
            etTglKeluar.setError(null);
        }

        return valid;
    }


}
