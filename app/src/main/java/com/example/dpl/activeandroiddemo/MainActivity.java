package com.example.dpl.activeandroiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;
//学生数据库的增删改查
public class MainActivity extends AppCompatActivity {
    private Button btn_add;
    private ListView listView;
    private StuAdapter stuAdapter;
    private ArrayList<Student> list=new ArrayList<Student>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_add= (Button) findViewById(R.id.btn_add);
        listView= (ListView) findViewById(R.id.lv);
        stuAdapter=new StuAdapter(this,list);
        listView.setAdapter(stuAdapter);
        initView();
    }
    private void initView(){
        //查询数据
        List<Student> students=new Select().from(Student.class).execute();
        list.addAll(students);
        for (int i=0;i<8;i++){//批量添加数据
            Student student=new Student();
            student.name="朱振鹏"+i;
            student.age=10+i;
            student.save();
            list.add(student);
        }
        stuAdapter.notifyDataSetChanged();//刷新界面
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//添加数据
                Student student=new Student();
                student.name="Lufei";
                student.age=12;
                student.save();
                list.add(student);
                stuAdapter.notifyDataSetChanged();//刷新界面
            }
        });
    }
}
