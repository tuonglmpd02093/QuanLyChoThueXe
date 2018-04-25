package com.example.pc.quanlychothuexe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pc.quanlychothuexe.DBManager.CustomAdapter;
import com.example.pc.quanlychothuexe.DBManager.DBManager;
import com.example.pc.quanlychothuexe.DBManager.KhachHang;

import java.util.List;

public class DanhSachActivity extends AppCompatActivity {
    private ListView lvList;
    private DBManager dbManager;
    private CustomAdapter customAdapter;
    private List<KhachHang> KHList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach);

        lvList = (ListView) findViewById(R.id.lvList);
        dbManager = new DBManager(this);
        KHList = dbManager.getAllKhachHang();
        setAdapter();
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                KhachHang nv = KHList.get(i);
                final int result = dbManager.deleteKhachHang(nv.getId());
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DanhSachActivity.this);
                alertDialog.setTitle("Xóa");
                alertDialog.setMessage("Bạn có muốn xóa không?");
                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (result >= 0) {
                            Toast.makeText(getApplicationContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
                            updateListKH();
                            KHList.clear();
                            KHList.addAll(dbManager.getAllKhachHang());
                            customAdapter.notifyDataSetChanged();
                        }
                    }
                });
                alertDialog.setNeutralButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Đã hủy xóa", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                });
                alertDialog.show();
                return;
            }
        });
    }
    public void updateListKH(){
        KHList.clear();
        KHList.addAll(dbManager.getAllKhachHang());
        customAdapter.notifyDataSetChanged();
    }
    private void setAdapter(){
        if (customAdapter== null){
            customAdapter = new CustomAdapter(this,R.layout.item_list_kh, KHList);
            lvList.setAdapter(customAdapter);
        }else {
            customAdapter.notifyDataSetChanged();
        }
    }
}

