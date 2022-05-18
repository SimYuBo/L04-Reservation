package sg.edu.rp.c346.id21024095.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declare field variables
    EditText editName;
    EditText editPhoneNum;
    EditText editPax;
    DatePicker dp;
    TimePicker tp;
    CheckBox cbSmoke;
    Button btnConfirm;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link field variables to UI variables in layout
        editName = findViewById(R.id.editTextName);
        editPhoneNum = findViewById(R.id.editTextPhone);
        editPax = findViewById(R.id.editTextPax);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        cbSmoke = findViewById(R.id.checkSmoking);
        btnConfirm = findViewById(R.id.buttonConfirm);
        btnReset = findViewById(R.id.buttonReset);

        // Setting date and time to default
        dp.updateDate(2020, 5, 1);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);

        // Button to display user input in toast
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initalise final output
                String output = "";
                // Create variables for editText
                String name = editName.getText().toString();
                String phone = editPhoneNum.getText().toString();
                String pax = editPax.getText().toString();
                // Create variable for table area
                String isSmoke = "";
                // Create variables for date
                int month = dp.getMonth() + 1;
                int day = dp.getDayOfMonth();
                int year = dp.getYear();
                // Create variables for hour and minute
                int hour = tp.getCurrentHour();
                String minute = String.format("%02d", tp.getCurrentMinute());

                // Check if table is in smoking or non-smoking area
                if (cbSmoke.isChecked()) {
                    isSmoke += "non-smoking";
                } else {
                    isSmoke += "smoking";
                }

                // Create time format
                String timeFormat = String.format("Reservation time is %s:%s", hour, minute);

                // Create date format
                String dateFormat = String.format("Reservation date is %s/%s/%s", day, month, year);

                output += String.format("Name: %s\nPhone Number: %s\nNumber of People in group: %s\nTable is in a %s area\n%s\n%s"
                        , name, phone, pax, isSmoke, dateFormat, timeFormat);

                if ((name == "") || (phone == "") || (pax == "")) {
                    Toast.makeText(getApplicationContext(), "Error, one or more text fields are empty", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG).show();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName.setText("");
                editPhoneNum.setText("");
                editPax.setText("");
                cbSmoke.setChecked(false);
                dp.updateDate(2020, 5, 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);

            }
        });
    }
}