package sg.edu.rp.c346.p03_classjournal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GradeArray extends ArrayAdapter<Grade> {

    private ArrayList<Grade> grade;
    private Context context;
    private TextView tvWeek;
    private TextView tvdailygrade;
    private TextView tvGrade;
    private ImageView ivGrade;

    public GradeArray(Context context, int resource, ArrayList<Grade> objects) {
        super(context, resource, objects);
        grade = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvWeek = rowView.findViewById(R.id.textViewWeek);
        tvdailygrade = rowView.findViewById(R.id.textViewDG);
        tvGrade = rowView.findViewById(R.id.textViewGrade);
        ivGrade = rowView.findViewById(R.id.imageView);

        Grade currentGrade = grade.get(position);

        tvdailygrade.setText("DG");
        tvWeek.setText("Week " + currentGrade.getWk());
        tvGrade.setText(currentGrade.getGrade());
        ivGrade.setImageResource(R.drawable.dg);

        return rowView;



    }
}
