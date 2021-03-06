package tw.com.nec.justin_chen.messageboxdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button normalDialog;
    private Button listDialog;
    private Button customDialog;
    private List<String> lunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        lunch = new ArrayList<>();
        lunch.add(getString(R.string.lunch1));
        lunch.add(getString(R.string.lunch2));
        lunch.add(getString(R.string.lunch3));
        lunch.add(getString(R.string.lunch4));
        lunch.add(getString(R.string.lunch5));
        lunch.add(getString(R.string.lunch6));
    }

    private void initView() {
        normalDialog = (Button) findViewById(R.id.normal_dialog);
        listDialog = (Button) findViewById(R.id.list_dialog);
        customDialog = (Button) findViewById(R.id.custom_dialog);

        normalDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                normalDialogEvent();
            }
        });
        listDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listDialog();
            }
        });
        customDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog();
//                Toast.makeText(MainActivity.this, "3 customDialog", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void normalDialogEvent(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle(R.string.lunch_time)
                .setMessage(R.string.want_to_eat)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), R.string.gogo, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(R.string.wait_a_minute, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), R.string.i_am_hungry, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton(R.string.not_hungry, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), R.string.diet, Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    private void listDialog(){
        new AlertDialog.Builder(MainActivity.this)
                .setItems(lunch.toArray(new String[lunch.size()]), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = lunch.get(which);
                        Toast.makeText(getApplicationContext(), getString(R.string.u_eat) + name, Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    private void customDialog(){
        final View item = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_layout, null);
        new AlertDialog.Builder(MainActivity.this)
                .setTitle(R.string.input_ur_name)
                .setView(item)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText editText = (EditText) item.findViewById(R.id.edit_text);
                        Toast.makeText(getApplicationContext(), getString(R.string.hi) + editText.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

}
