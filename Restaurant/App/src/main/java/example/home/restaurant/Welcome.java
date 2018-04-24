package example.home.restaurant;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {

    TextView wc;
    EditText name,phno;
    Button cont;
    String w,temp;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        temp="";
        w="Welcome\n to\n Restaurant";
        temp+=w.charAt(i++);
        wc=(TextView)findViewById(R.id.textView);
        name=(EditText)findViewById(R.id.name);
        phno=(EditText)findViewById(R.id.phno);
        cont=(Button)findViewById(R.id.cont);
        new CountDownTimer(3400,120)
        {
            public void onTick(long remain) {
                wc.setText(temp);
                if(i<w.length())
                    temp+=w.charAt(i++);
            }
            public void onFinish() {
                wc.setVisibility(View.GONE);
                name.animate().alpha(1f).setDuration(1000);
                phno.animate().alpha(1f).setDuration(1000);
                cont.animate().alpha(1f).setDuration(1000);
            }
        }.start();
    }
    public void menu(View view)
    {
        if(phno.length()==10||name.length()>=3)
            startActivity(new Intent(getApplicationContext(),Menu.class));
        else
            Toast.makeText(this, "Enter valid details!", Toast.LENGTH_SHORT).show();
    }
}