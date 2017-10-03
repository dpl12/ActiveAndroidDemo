package com.example.dpl.activeandroiddemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dpl on 2017/10/2 0002.
 */

public class StuAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Student>list;
    public StuAdapter(Context context,ArrayList<Student>lists){
        this.context=context;
        this.list=lists;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if(view==null){
            holder=new ViewHolder();
            view=View.inflate(context,R.layout.item_stu,null);
            holder.tv=view.findViewById(R.id.tv);
            holder.btn_del=view.findViewById(R.id.btn_del);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        final Student student=list.get(position);
        holder.tv.setText(student.name+"\n"+student.age);
        holder.btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                student.delete();
                list.remove(position);
                notifyDataSetChanged();//刷新界面
            }
        });
        return view;
    }
    class ViewHolder{
        TextView tv;
        Button btn_del;
    }
}
