package edu.westga.waynemullinsstaticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataDisplayFragment extends Fragment {


    private TextView textProduct;
    private Button addButton;
    private double value1;
    private double value2;
    private double product;
    private DataAddButtonListener listener;

    public void setValue1(double value) {
        value1 = value;
    }

    public void setValue2(double value) {
        value2 = value;
    }

    public DataDisplayFragment() {
        // Required empty public constructor
    }

    public void multiply() {
        product = (double)Math.round(value1 * value2 * 10000)/10000;
    }

    public void displayProduct() {
        String text = product % 1.0 == 0 ? String.format("%d", (long) product) : String.format("%s", product);
        textProduct.setText(text);
    }

    public interface DataAddButtonListener {
        void onDataAdd(DataDisplayFragment fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_display, container, false);
        textProduct = (TextView)theView.findViewById(R.id.textView2);
        addButton = (Button)theView.findViewById(R.id.addButton);
        //anonymous class to handle onClick
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addButtonClicked(v);
            }
        });

        return theView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (DataAddButtonListener)context;
    }

    private void addButtonClicked(View v) {
        listener.onDataAdd(this);
    }

}
