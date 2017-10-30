package my.edu.taruc.loancalculator;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCarPrice;
    private EditText editTextDownPayment;
    private EditText editTextLoanPeriod;
    private EditText editTextInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCarPrice = (EditText)findViewById(R.id.editTextCarPrice);
        editTextDownPayment = (EditText)findViewById(R.id.editTextDownPayment);
        editTextLoanPeriod = (EditText)findViewById(R.id.editTextLoadPeriod);
        editTextInterest = (EditText)findViewById(R.id.editTextInterest);

    }

    public void calculate_loan(View view){
        //Intent is a message class to transfer
        //an activity to another activity or app
        Intent intent = new Intent(this, ResultActivity.class);

        double car_price;
        double down_payment;
        int loan_period;
        double interest_rate;

        car_price = Double.parseDouble(editTextCarPrice.getText().toString());
        down_payment = Double.parseDouble(editTextDownPayment.getText().toString());
        loan_period = Integer.parseInt(editTextLoanPeriod.getText().toString());
        interest_rate = Double.parseDouble(editTextInterest.getText().toString());

        double car_loan = car_price - down_payment;
        double interest = (car_loan * interest_rate * loan_period);
        double  repayment = (car_loan + interest) / loan_period / 12;

        intent.putExtra("DOWN", down_payment);
        intent.putExtra("LOAN", loan_period);
        intent.putExtra("INTEREST", interest_rate);
        intent.putExtra("REPAYMENT", repayment);
        startActivity(intent);
    }
}
