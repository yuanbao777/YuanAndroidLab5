package algonquin.cst2335.guo00093;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author yuan
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {
    /** This holds the text at center of the screen*/
    private TextView tv = null;
    /**This holds the text field to write password*/
    private EditText et = null;
    /**This holds the login button object*/
    private Button btn = null;

    /**This is the starting point for MainActivity
     *
     * @param savedInstanceState  If the activity is being re-initialized after
     *                            previously being shut down, then this Bundle contains the data it
     *                            most recently supplied in {@link #onSaveInstanceState}.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editTextTextPassword);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(clk -> {
            String password = et.getText().toString();
            checkPasswordComplexity(password);
        });
    }

    /**
     *
     * @param pw
     * @return Return true if pw meets password requirements.
     */
    boolean checkPasswordComplexity(String pw){
        // Implement your password complexity checking logic here.
        boolean result = false;
        boolean foundUpperCase = false;
        boolean foundLowerCase = false;
        boolean foundNumber = false;
        boolean foundSpecial = false;


        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            } else if (isSpecialCharacter(c)) {
                foundSpecial = true;
            }
        }

        if (!foundUpperCase) {
            Toast.makeText(this, "You are missing an upper case letter", Toast.LENGTH_SHORT).show();
            tv.setText("You are missing an upper case letter");
            return false;
        } else if (!foundLowerCase) {
            Toast.makeText(this, "You are missing a lower case letter", Toast.LENGTH_SHORT).show();
            tv.setText("You are missing a lower case letter");
            return false;
        } else if (!foundNumber) {
            Toast.makeText(this, "You are missing a number", Toast.LENGTH_SHORT).show();
            tv.setText("You are missing a number");
            return false;
        } else if (!foundSpecial) {
            Toast.makeText(this, "You are missing a special character", Toast.LENGTH_SHORT).show();
            tv.setText("You are missing a special character");
            return false;
        } else {
            tv.setText("Password is valid!");
            return true;  // only get here if they're all true
        }
    }

    /**Checks if the given character is a special character.
     *
     * @param c The character to be checked for special
     * @return Return true if the character is a special character.
     */
    boolean isSpecialCharacter(char c)

    {switch (c) {
        case '#':
        case '$':
        case '%':
        case '^':
        case '&':
        case '*':
        case '!':
        case '@':
        case '?':
            return true; //return true if c is one of: #$%^&*!@?
        default:
            return false; //return false otherwise
    }
    }
}