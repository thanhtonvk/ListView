package com.tondz.listview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tondz.listview.Entities.SinhVien;

import org.w3c.dom.Text;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {


    List<SinhVien>list;
    Context context;
    LayoutInflater inflater;
    int layout;
    public  SinhVienAdapter(Context context, int layout,List<SinhVien>list){
        this.list = list;
        this.context = context;
        this.layout = layout;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_sinhvien,null);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_classname = convertView.findViewById(R.id.tv_classname);
        TextView tv_teacher = convertView.findViewById(R.id.tv_teacher);
        tv_name.setText(list.get(position).getName());
        tv_classname.setText(list.get(position).getClassName());
        tv_teacher.setText(list.get(position).getTeacher());
        return convertView;
    }
}
