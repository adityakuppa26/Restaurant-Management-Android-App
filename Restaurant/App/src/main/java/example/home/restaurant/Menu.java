package example.home.restaurant;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    TextView[] quantity;
    int q;
    int qa[];
    String s="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        quantity=new TextView[6];
        quantity[0]=(TextView)findViewById(R.id.q0);
        quantity[1]=(TextView)findViewById(R.id.q1);
        quantity[2]=(TextView)findViewById(R.id.q2);
        quantity[3]=(TextView)findViewById(R.id.q3);
        quantity[4]=(TextView)findViewById(R.id.q4);
        quantity[5]=(TextView)findViewById(R.id.q5);
    }
    @Override
    public void onBackPressed(){

    }
    public void increment(View view)
    {
        String tag=view.getTag().toString();
        tag=String.valueOf(tag.charAt(1));
        int p=Integer.parseInt(tag);
        String pq=quantity[p].getText().toString();
        q=Integer.parseInt(pq);
        if(q==99)
            Toast.makeText(this,"Quantity cannot be greater than 99!",Toast.LENGTH_SHORT).show();
        else{
            q++;
            quantity[p].setText(String.valueOf(q));}
    }
    public void decrement(View view)
    {
        String tag=view.getTag().toString();
        tag=String.valueOf(tag.charAt(1));
        int p=Integer.parseInt(tag);
        String pq=quantity[p].getText().toString();
        q=Integer.parseInt(pq);
        if(q==0)
            Toast.makeText(this,"Quantity cannot be less than 0!",Toast.LENGTH_SHORT).show();
        else{
            q--;
            quantity[p].setText(String.valueOf(q));}
    }
    public void sort()
    {
        String d[]={"Dish-1","Dish-2","Dish-3","Dish4","Dish-5","Dish-6"};
        qa =new int[6];
        for(int i=0;i<6;i++)
        {
            qa[i]= Integer.parseInt(quantity[i].getText().toString());
        }
        for(int i=0;i<6;i++)
        {
            if(qa[i]!=0)
            {
                s=s+(d[i]+"    :      "+qa[i]+"\n"+"\n");
            }
        }

    }

    public void postMenu(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this,R.style.Theme_AppCompat_Dialog);
        sort();
        if (s != "") {
            alertDialogBuilder.setMessage("\n" + "DISH " + "        " + "QUANTITY" + "\n" + "\n" + s);
            alertDialogBuilder.setTitle("Order Summary :");
            alertDialogBuilder.setIcon(R.drawable.order_summary);
            alertDialogBuilder.setPositiveButton("Confirm",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            Toast.makeText(Menu.this, "Under Development!", Toast.LENGTH_LONG).show();
                        }
                    });
            alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    s="";
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        else
            Toast.makeText(this, "No items selected!", Toast.LENGTH_SHORT).show();
    }
}
