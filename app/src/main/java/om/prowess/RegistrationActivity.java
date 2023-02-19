package om.prowess;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etFirstName, etLastName, etAge, etAddress, etHeight, etWeight;
    private Spinner spDiabetesType;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Initialize widgets and controls
        etFirstName = findViewById(R.id.et_first_name);
        etLastName = findViewById(R.id.et_last_name);
        etAge = findViewById(R.id.et_age);
        etAddress = findViewById(R.id.et_address);
        etHeight = findViewById(R.id.et_height);
        etWeight = findViewById(R.id.et_weight);
        spDiabetesType = findViewById(R.id.sp_diabetes_type);
        btnRegister = findViewById(R.id.btn_sign_up);

        btnRegister.setOnClickListener(v -> {
            // Read user input
            String firstName = etFirstName.getText().toString().trim();
            String lastName = etLastName.getText().toString().trim();
            String ageStr = etAge.getText().toString().trim();
            int age = ageStr.isEmpty() ? 0 : Integer.parseInt(ageStr);
            String address = etAddress.getText().toString().trim();
            String heightStr = etHeight.getText().toString().trim();
            double height = heightStr.isEmpty() ? 0.0 : Double.parseDouble(heightStr);
            String weightStr = etWeight.getText().toString().trim();
            double weight = weightStr.isEmpty() ? 0.0 : Double.parseDouble(weightStr);
            String diabetesType = spDiabetesType.getSelectedItem().toString();

            // Validate input fields
            if (firstName.isEmpty() || lastName.isEmpty() || ageStr.isEmpty() || address.isEmpty() || heightStr.isEmpty() || weightStr.isEmpty()) {
                Toast.makeText(RegistrationActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // TODO: Save user data to database or other storage

            // Show success message
            Toast.makeText(RegistrationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();

            // Go back to login page
            finish();
        });
    }
}