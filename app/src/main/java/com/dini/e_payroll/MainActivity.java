package com.dini.e_payroll; // Defines the application package

// Importing necessary classes
import android.annotation.SuppressLint;
import android.content.Intent; // For starting new Activities
import android.os.Build; // For checking Android version
import android.os.Bundle; // For saving and retrieving Activity state data
import android.view.View; // For handling View interactions
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast; // For displaying short messages
import androidx.activity.EdgeToEdge; // For enabling Edge-to-Edge mode
import androidx.annotation.NonNull; // For NonNull annotation
import androidx.appcompat.app.AppCompatActivity; // Base class for Activities
import androidx.core.graphics.Insets; // For handling screen insets
import androidx.core.view.ViewCompat; // For View compatibility
import androidx.core.view.WindowInsetsCompat; // For handling window insets
import com.dini.e_payroll.databinding.ActivityMainBinding; // For Data Binding
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity { // MainActivity class, extending AppCompatActivity

    private ActivityMainBinding binding; // Binding object for activity_main layout
    private ImageButton btnInbox;


    @Override // Indicates that this method overrides the onCreate() method from the parent class
    protected void onCreate(Bundle savedInstanceState) { // Method called when the Activity is created
        super.onCreate(savedInstanceState); // Calling onCreate() from the parent class

        setContentView(R.layout.activity_main);
        EditText emailAddress = findViewById(R.id.EmailAddress);
        EditText passwordEditText = findViewById(R.id.TextPassword3);


        // Binding Initialization
        binding = ActivityMainBinding.inflate(getLayoutInflater()); // Initializing the binding object
        setContentView(binding.getRoot()); // Setting the content view using binding

        if (savedInstanceState != null) { // Checking if there is a savedInstanceState
            String myString = savedInstanceState.getString("myKey"); // Retrieving data from savedInstanceState
            // Use the previously saved myString // Using the previously saved data
        }

        // Enable Edge-to-Edge for Android 11 and above
        EdgeToEdge.enable(this); // Enables Edge-to-Edge display

        // Handle system window insets to avoid content overlap
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content),
                (view, windowInsets) -> {
                    Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
                    view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
                    return windowInsets;
                });



        binding.loginButton.setOnClickListener(new View.OnClickListener() { // Setting OnClickListener for the login button
            @Override // Indicates that this method overrides the onClick() method from the OnClickListener interface
            public void onClick(View v) { // Method called when the login button is clicked
                String email = binding.EmailAddress.getText().toString(); // Getting text from the email EditText
                String password = binding.TextPassword3.getText().toString(); // Getting text from the password EditText

                if (email.equals("example@gmail.com") && password.equals("tes123")) { // Checking if email and password are correct
                    // Email and password are correct, start new activity
                    Intent intent = new Intent(MainActivity.this, Beranda.class); // Creating an Intent to start NewActivity
                    startActivity(intent); // Starting NewActivity
                } else { // If email or password is incorrect
                    // Email or password is incorrect, show error message
                    Toast.makeText(MainActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show(); // Displaying an error message
                }
            }
        });
    }



    @Override // Indicates that this method overrides the onSaveInstanceState() method from the parent class
    protected void onSaveInstanceState(@NonNull Bundle outState) { // Method for saving Activity state
        super.onSaveInstanceState(outState); // Calling onSaveInstanceState() from the parent class
        outState.putString("myKey", "myValue"); // Saving data to outState
    }
}



