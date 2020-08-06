package sg.edu.rpc346.id19016011.reservation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etTelephone;
    EditText etSize, etDate, etTime;
    CheckBox checkBox;
    TextView tvDate, tvTime;
    //DatePicker datePicker;
    //TimePicker timePicker;
    Button btReserve;
    Button btReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etTelephone = findViewById(R.id.editTextTelephone);
        etSize = findViewById(R.id.editTextSize);
        etDate = findViewById(R.id.editTextDate);
        etTime = findViewById(R.id.editTextTime);
        checkBox = findViewById(R.id.checkBox);
        tvDate = findViewById(R.id.textViewDate);
        tvTime = findViewById(R.id.textViewTime);
        btReserve = findViewById(R.id.buttonReserve);
        btReset = findViewById(R.id.buttonReset);

        /*datePicker.updateDate(2020, 5, 1);
        timePicker.setCurrentHour(20);
        timePicker.setCurrentMinute(30);*/

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        etDate.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                };

                // Create the Date Picker Dialog
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, 2014, 11, 31);
                myDateDialog.show();
            }
        });

        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the Listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        etTime.setText(hourOfDay + ":" + minute);

                        /*if(hourOfDay >= 13 && hourOfDay < 24){
                            hourOfDay -= 12;
                            tvDemo5.setText("Time: " + hourOfDay + ":" + minute + " PM");
                        }
                        else{
                            tvDemo5.setText("Time: " + hourOfDay + ":" + minute + " AM");
                        }
                         */
                    }
                };

                // Create the Time Picker Dialog
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, 20, 0, true);
                myTimeDialog.show();
            }
        });

        btReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String isSmoke = "";
                if (checkBox.isChecked()) {
                    isSmoke = "smoking";
                }
                else {
                    isSmoke = "non-smoking";
                }

                //Create the dialog builder
                final AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //Set the dialog details
                /*
                myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close", null);
                */
                myBuilder.setTitle("Confirm Your Order");
                myBuilder.setMessage("New Reservation \n Name: " + etName.getText().toString() + " \n Smoking: " + isSmoke + " \n Size: " + etSize.getText().toString() + " \n Date: " + etDate.getText().toString() + "\n Time: " + etTime.getText().toString());
                /*myBuilder.setMessage("Name: " + etName.getText().toString());
                myBuilder.setMessage("Smoking: " + isSmoke);
                myBuilder.setMessage("Size: " + etSize.getText().toString());
                myBuilder.setMessage("Date: " + etDate.getText().toString());
                myBuilder.setMessage("Time: " + etTime.getText().toString());*/

                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String isSmoke = "";
                        if (checkBox.isChecked()) {
                            isSmoke = "smoking";
                        }
                        else {
                            isSmoke = "non-smoking";
                        }
                        String msg = "New Reservation \n Name: " + etName.getText().toString() + " \n Smoking: " + isSmoke + " \n Size: " + etSize.getText().toString() + " \n Date: " + etDate.getText().toString() + "\n Time: " + etTime.getText().toString();
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
                    }
                });

                myBuilder.setNeutralButton("Cancel", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

                /*Toast.makeText(MainActivity.this,
                        "Hi, " + etName.getText().toString() + ", you have booked a "
                                + etSize.getText().toString() + " person(s) "
                                + isSmoke + " table on "
                                + datePicker.getYear() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getDayOfMonth() + " at "
                                + timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute() + ". Your phone number is "
                                + etTelephone.getText().toString() + ".",
                        Toast.LENGTH_LONG).show();*/
            }
        });

        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etTelephone.setText("");
                etSize.setText("");
                checkBox.setChecked(false);
                /*datePicker.updateDate(2020, 5, 1);
                timePicker.setCurrentHour(20);
                timePicker.setCurrentMinute(30);*/
                etDate.setText("");
                etTime.setText("");
            }
        });
    }
}
