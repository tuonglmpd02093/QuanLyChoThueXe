package com.example.pc.quanlychothuexe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pc.quanlychothuexe.DBManager.CustomAdapter;
import com.example.pc.quanlychothuexe.DBManager.DBManager;
import com.example.pc.quanlychothuexe.DBManager.KhachHang;

import java.util.List;

public class QLCTXActivity extends AppCompatActivity {
    private EditText edCode, edName, edEmail, edPhone, edAddress, edXe, edBiensoxe, edMauxe;
    private Button btAdd, btDelete, btListView, btEdit;
    private DBManager dbManager;
    private List<KhachHang> list;
    CustomAdapter customAdapter;
    ListView lvManage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlctx);

        Init();

        dbManager = new DBManager(this);
        list = dbManager.getAllKhachHang();

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KhachHang khachHang = createKH();
                if (khachHang!=null){
                    dbManager.addKhachHang(khachHang);
                    Toast.makeText(getApplicationContext()
                            ,"Add Employees Successfuly",Toast.LENGTH_SHORT).show();
                }
                list.clear();
                list.addAll(dbManager.getAllKhachHang());

            }
        });
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edCode.setText("");
                edName.setText("");
                edEmail.setText("");
                edPhone.setText("");
                edAddress.setText("");
                edXe.setText("");
                edBiensoxe.setText("");
                edMauxe.setText("");
            }
        });
        btListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QLCTXActivity.this,DanhSachActivity.class);
                startActivity(intent);
            }
        });
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QLCTXActivity.this,DanhSachActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext()
                        ,"Choose Employees",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private KhachHang createKH(){
        String code = edCode.getText().toString();
        String name = edName.getText().toString();
        String email = edEmail.getText().toString();
        String phone = edPhone.getText().toString();
        String address = edAddress.getText().toString();
        String xe = edXe.getText().toString();
        String biensoxe = edBiensoxe.getText().toString();
        String mauxe = edMauxe.getText().toString();

        KhachHang khachHang = new KhachHang(code,name,email,phone,address,xe,biensoxe,mauxe);
        return khachHang;
    }
    public void Init(){
        edCode = (EditText) findViewById(R.id.edCode);
        edName = (EditText) findViewById(R.id.edName);
        edEmail = (EditText) findViewById(R.id.edEmail);
        edPhone = (EditText) findViewById(R.id.edPhone);
        edAddress = (EditText) findViewById(R.id.edAddress);
        edXe = (EditText) findViewById(R.id.edXe);
        edBiensoxe = (EditText) findViewById(R.id.edBiensoxe);
        edMauxe = (EditText) findViewById(R.id.edMauxe);
        btAdd = (Button) findViewById(R.id.btAdd);
        btDelete = (Button) findViewById(R.id.btDelete);
        btListView = (Button) findViewById(R.id.btList);
        btEdit = (Button) findViewById(R.id.btEdit);

    }
}
