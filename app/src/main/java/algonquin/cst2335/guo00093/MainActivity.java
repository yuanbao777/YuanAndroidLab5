package algonquin.cst2335.guo00093;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.textView);
        EditText et = findViewById(R.id.editTextTextPassword);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(clk -> {
            String password = et.getText().toString();

            checkPasswordComplexity (password);

            void checkPasswordComplexity (String pw);{

            }
        });
    }
}