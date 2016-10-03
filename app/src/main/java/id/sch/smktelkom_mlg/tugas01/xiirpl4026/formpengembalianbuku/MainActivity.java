package id.sch.smktelkom_mlg.tugas01.xiirpl4026.formpengembalianbuku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNo;
    EditText etNama;
    EditText etTgl;
    //    RadioButton rbRPL1, rbRPL2, rbRPL3, rbRPL4, rbRPL5;
    RadioGroup rgKelas;
    CheckBox cbNovel, cbKomik, cbEnsiklopedia;
    Button bSubmit;
    TextView tvHasilNo;
    TextView tvHasilNama;
    TextView tvHasilTgl;
    TextView tvHasilKelas;
    TextView tvHasilJenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNo = (EditText) findViewById(R.id.editTextNo);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etTgl = (EditText) findViewById(R.id.editTextTgl);
       /* rbRPL1 = (RadioButton) findViewById(R.id.radioButtonRPL1);
        rbRPL2 = (RadioButton) findViewById(R.id.radioButtonRPL2);
        rbRPL3 = (RadioButton) findViewById(R.id.radioButtonRPL3);
        rbRPL4 = (RadioButton) findViewById(R.id.radioButtonRPL4);
        rbRPL5 = (RadioButton) findViewById(R.id.radioButtonRPL5);*/
        rgKelas = (RadioGroup) findViewById(R.id.radioGroupKelas);
        cbNovel = (CheckBox) findViewById(R.id.checkBoxNovel);
        cbKomik = (CheckBox) findViewById(R.id.checkBoxKomik);
        cbEnsiklopedia = (CheckBox) findViewById(R.id.checkBoxEnsiklopedia);
        bSubmit = (Button) findViewById(R.id.buttonSubmit);
        tvHasilNo = (TextView) findViewById(R.id.textViewHasilNo);
        tvHasilNama = (TextView) findViewById(R.id.textViewHasilNama);
        tvHasilTgl = (TextView) findViewById(R.id.textViewHasilTgl);
        tvHasilKelas = (TextView) findViewById(R.id.textViewHasilKelas);
        tvHasilJenis = (TextView) findViewById(R.id.textViewHasilJenis);

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });
    }

    private void doProcess() {
        if (isValid()) {
            int no = Integer.parseInt(etNo.getText().toString());
            String nama = etNama.getText().toString();
            String tgl = etTgl.getText().toString();
            tvHasilNo.setText("No Anggota :" + no);
            tvHasilNama.setText("Nama :" + nama);
            tvHasilTgl.setText("Tanggal Pengembalian :" + tgl);
        }

        String hasil = "Jenis Buku : ";
        int startlen = hasil.length();
        if (cbNovel.isChecked()) hasil += cbNovel.getText() + "\n";
        if (cbKomik.isChecked()) hasil += cbKomik.getText() + "\n";
        if (cbEnsiklopedia.isChecked()) hasil += cbEnsiklopedia.getText() + "\n";

        if (hasil.length() == startlen) hasil += "Tidak ada pada pilihan";

        tvHasilJenis.setText(hasil);
    }

    private boolean isValid() {
        boolean valid = true;
        String hasil = null;

        String no = etNo.getText().toString();
        String nama = etNama.getText().toString();
        String tgl = etTgl.getText().toString();

        if (no.isEmpty()) {
            etNo.setError("No Belum Diisi");
            valid = false;
        } else if (no.length() < 2) {
            etNo.setError("No minimal 2 karakter");
        } else {
            etNo.setError(null);
        }
        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
            valid = false;
        } else if (nama.length() < 2) {
            etNama.setError("Nama minimal 2 karakter");
        } else {
            etNama.setError(null);
        }
        if (tgl.isEmpty()) {
            etTgl.setError("Tanggal Belum Diisi");
            valid = false;
        } else {
            etNo.setError(null);
        }


        if (rgKelas.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(rgKelas.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        /*if (rbRPL1.isChecked())
        {
            hasil = rbRPL1.getText().toString();
        }
        else if(rbRPL2.isChecked())
        {
            hasil = rbRPL2.getText().toString();
        }
        else if(rbRPL3.isChecked())
        {
            hasil = rbRPL3.getText().toString();
        }
        else if(rbRPL4.isChecked())
        {
            hasil = rbRPL4.getText().toString();
        }
        else if(rbRPL5.isChecked())
        {
            hasil = rbRPL5.getText().toString();
        }*/

        if (hasil == null) {
            tvHasilKelas.setText("Belum Memilih Kelas");
        } else {
            tvHasilKelas.setText("Kelas : " + hasil);
        }

        return valid;
    }
}
