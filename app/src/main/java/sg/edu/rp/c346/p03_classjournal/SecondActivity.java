package sg.edu.rp.c346.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    int requestCodeForAdd = 1;

    ListView lvGrade;
    ArrayAdapter aa;
    ArrayList<Grade> grade;
    Button btnInfo, btnAdd, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lvGrade = findViewById(R.id.listViewGrade);
        btnAdd = findViewById(R.id.buttonAdd);
        btnInfo = findViewById(R.id.buttonInfo);
        btnEmail = findViewById(R.id.buttonEmail);

        grade = new ArrayList<Grade>();

        Intent i = getIntent();
        this.setTitle("Info for C347");

        grade.add(new Grade("B", "C347", 1));
        grade.add(new Grade("C", "C347", 2));

        aa = new GradeArray(this, R.layout.row, grade);
        lvGrade.setAdapter(aa);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(SecondActivity.this, Add.class);
                i.putExtra("week", lvGrade.getAdapter().getCount()+1);
                startActivityForResult(i, requestCodeForAdd);

            }
        });


        btnEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                StringBuilder sb = new StringBuilder();
                for (Grade s : grade) {
                    sb.append("Week " + s.getWk() + ": DG: " + s.getGrade());
                    sb.append("\n");
                }

                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "");

                email.putExtra(Intent.EXTRA_TEXT,
                        "Hi Faci \n I am ... \n Please see my remarks so far, thank you! \n " + sb.toString());

                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }


        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if(resultCode == RESULT_OK){
            if (data != null) {

                String newGrade = data.getStringExtra("grade");

                grade.add(new Grade(newGrade, "C302", lvGrade.getAdapter().getCount()+1));

                aa.notifyDataSetChanged();



            }
        }
    }
}
