package com.example.pc.quanlychothuexe.DBManager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pc.quanlychothuexe.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<KhachHang> {

    private Context context;
    private int resoure;
    private List<KhachHang> listKH;
    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<KhachHang> objects) {
        super(context,resource,objects);
        this.context = context;
        this.resoure = resource;
        this.listKH = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_kh,parent,false);
            viewHolder = new ViewHolder();

            viewHolder.tvId = (TextView) convertView.findViewById(R.id.tv_id);
            viewHolder.tvCode = (TextView) convertView.findViewById(R.id.tv_code);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tvEmail = (TextView) convertView.findViewById(R.id.tv_email);
            viewHolder.tvPhone = (TextView) convertView.findViewById(R.id.tv_phone);
            viewHolder.tvAddress = (TextView) convertView.findViewById(R.id.tv_address);

            viewHolder.tvXe = (TextView) convertView.findViewById(R.id.tv_xe);
            viewHolder.tvBiensoxe = (TextView) convertView.findViewById(R.id.tv_biensoxe);
            viewHolder.tvMauxe = (TextView) convertView.findViewById(R.id.tv_mauxe);
            convertView.setTag(viewHolder);
        }else {

            viewHolder = (ViewHolder) convertView.getTag();

        }
        KhachHang khachHang = listKH.get(position);
        viewHolder.tvId.setText(String.valueOf(khachHang.getId()));
        viewHolder.tvCode.setText(khachHang.getCode());
        viewHolder.tvName.setText(khachHang.getName());
        viewHolder.tvEmail.setText(khachHang.getEmail());
        viewHolder.tvPhone.setText(khachHang.getPhone());
        viewHolder.tvAddress.setText(khachHang.getAddress());

        viewHolder.tvXe.setText(khachHang.getXe());
        viewHolder.tvBiensoxe.setText(khachHang.getBiensoxe());
        viewHolder.tvMauxe.setText(khachHang.getMauxe());

        return convertView;
    }

    public class ViewHolder{
        private TextView tvId;
        private TextView tvCode;
        private TextView tvName;
        private TextView tvEmail;
        private TextView tvPhone;
        private TextView tvAddress;

        private TextView tvXe;
        private TextView tvBiensoxe;
        private TextView tvMauxe;

    }
}
