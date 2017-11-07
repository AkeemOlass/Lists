package com.example.princeolass.lists;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.TextView;

import java.text.MessageFormat;

import static java.lang.String.*;

public class ArrayList extends AppCompatActivity {
    protected ArrayList(){}

    String courseName;
    java.util.ArrayList<Editable> students = new java.util.ArrayList<>();
    static int numberOfStudents;

    ArrayList(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(Editable student) {
        students.add(student);
        numberOfStudents++;
    }

    public java.util.ArrayList<Editable> getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        students.remove(student);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Button BtnMaStu = (Button) findViewById(R.id.BtnMaStu);
        final Button BtnEngStu = (Button) findViewById(R.id.BtnEngStu);
         final CheckBox Course1 = (CheckBox) findViewById(R.id.Math);
         final CheckBox Course2 = (CheckBox) findViewById(R.id.English);
        final Button buttonN = (Button) findViewById(R.id.buttonN);
        final EditText Stuname = (EditText) findViewById(R.id.StuName);

        final ArrayList course1 = new ArrayList(Course1.toString());
        final ArrayList course2 = new ArrayList(Course2.toString());
        assert buttonN != null;
        buttonN.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Course1.isChecked()) course1.addStudent(Stuname.getText());
                        if (Course2.isChecked())   course2.addStudent(Stuname.getText());

                        }
                    });


                    assert BtnEngStu != null;
                    BtnEngStu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView Results = (TextView) findViewById(R.id.Results);
                assert Results != null;
                Results.setText(valueOf(course2.getCourseName()));
                Results.setText(valueOf(course2.getNumberOfStudents()));
                Results.setText("The students are: " +valueOf( course2.getStudents()));

            }
        });
                    assert BtnMaStu != null;
                    BtnMaStu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView Results = (TextView) findViewById(R.id.Results);
                assert Results != null;
                Results.setText(valueOf(course1.getCourseName()));
                Results.setText(valueOf(course1.getNumberOfStudents()));
                Results.setText(MessageFormat.format("The students are: {0}", valueOf(course1.getStudents())));

            }
        });


                }
}



