package com.tondz.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import com.tondz.listview.Entities.SinhVien;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    ArrayList<SinhVien> sinhViens;
    ListView listView;
    SinhVienAdapter sinhVienAdapter;
    Button btn_addStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        references();
        listView.setAdapter(sinhVienAdapter);
        onClickLv_SinhVien();
        btn_addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialogAdd();
            }
        });
    }
    private void references(){
        sinhViens = new ArrayList<>();
        listView = findViewById(R.id.lv_listSinhVien);
        sinhVienAdapter = new SinhVienAdapter(this,R.layout.item_sinhvien,sinhViens);
        btn_addStudent = findViewById(R.id.btn_addStudent);
    }
    private void onClickLv_SinhVien(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                alertDialog(position);
            }
        });
    }
    private void alertDialog(int position){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Tùy chọn");
        alert.setNegativeButton("Sửa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                customDialogEdit(position);
                listView.setAdapter(sinhVienAdapter);
            }
        });
        alert.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                sinhViens.remove(position);
                listView.setAdapter(sinhVienAdapter);
            }
        });
        alert.setNeutralButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.show();
    }
    Spinner spinner;
    String[]teacher = {"Nguyen Hoang Diep","Nguyen Thi Hai Nang","Tran Do Thu Ha","Nguyen Duy Tan"};
    ArrayAdapter adapter;
    private void customDialogAdd(){
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,teacher);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_student);
        EditText edt_tensinhvien= dialog.findViewById(R.id.tv_tensinhvien);
        EditText edt_tenlop= dialog.findViewById(R.id.tv_tenlop);
        Button btn_them = dialog.findViewById(R.id.btn_themSinhVien);
        spinner = dialog.findViewById(R.id.spiner_teacher);
        spinner.setAdapter(adapter);
        final String[] tengv = {""};
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               tengv[0] = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sinhViens.add(new SinhVien(edt_tensinhvien.getText().toString(),edt_tenlop.getText().toString(),tengv[0]));
                dialog.cancel();
            }
        });
        dialog.show();
    }
    ArrayAdapter adapterEdt;
    Spinner spinnerEdt;

    private void customDialogEdit(int position){
        adapterEdt = new ArrayAdapter(this, android.R.layout.simple_spinner_item,teacher);
        adapterEdt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.edit_student);
        EditText edt_tensinhvien= dialog.findViewById(R.id.tv_edt_tensinhvien);
        EditText edt_tenlop= dialog.findViewById(R.id.tv_edt_tenlop);
        Button btn_them = dialog.findViewById(R.id.btn_edt_themSinhVien);
        spinnerEdt = dialog.findViewById(R.id.spiner_edt_teacher);
        spinnerEdt.setAdapter(adapterEdt);
        final String[] tengv = {""};
        spinnerEdt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tengv[0] = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        edt_tensinhvien.setText(sinhViens.get(position).getName());
        edt_tenlop.setText(sinhViens.get(position).getClassName());
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sinhViens.set(position,new SinhVien(edt_tensinhvien.getText().toString(),edt_tenlop.getText().toString(),tengv[0]));
                dialog.cancel();
            }
        });
        dialog.show();
    }


}