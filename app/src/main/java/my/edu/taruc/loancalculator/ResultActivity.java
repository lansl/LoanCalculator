package my.edu.taruc.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView textViewDownPayment;
    TextView textViewLoanPeriod;
    TextView textViewInterest;
    TextView textViewMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewDownPayment = (TextView) findViewById(R.id.textViewDownPayment);
        textViewLoanPeriod = (TextView) findViewById(R.id.textViewLoanPeriod);
        textViewInterest = (TextView) findViewById(R.id.textViewInterest);
        textViewMonth = (TextView) findViewById(R.id.textViewMonth);

        Intent intent = getIntent();
        double down = getIntent().getDoubleExtra("DOWN", 0);
        int loan = getIntent().getIntExtra("LOAN", 0);
        double interest = getIntent().getDoubleExtra("INTEREST", 0);
        double month_repayment = getIntent().getDoubleExtra("REPAYMENT", 0);

        textViewDownPayment.setText("Down payment: " + Double.toString(down));
        textViewLoanPeriod.setText("Loan period: " + Integer.toString(loan));
        textViewInterest.setText("Interest rate (%): " + Double.toString(interest));
        textViewMonth.setText("Month repayment: " + Double.toString(month_repayment));

    }

    public void closeActivity(View view){
        finish(); //to terminate an activity
    }
}
