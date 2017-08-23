package tw.com.nec.justin_chen.messageboxdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
                // normalDialogEvent();
                Toast.makeText(MainActivity.this, "1 normalDialog", Toast.LENGTH_SHORT).show();
            }
        });
        listDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // listDialog();
                Toast.makeText(MainActivity.this, "2 listDialog", Toast.LENGTH_SHORT).show();
            }
        });
        customDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // customDialog();
                Toast.makeText(MainActivity.this, "3 customDialog", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
