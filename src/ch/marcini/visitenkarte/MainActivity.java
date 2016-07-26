package ch.marcini.visitenkarte;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private TextView textViewHalloAndroid;
	private EditText editTextVornameNachname;
	private Button buttonHello;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textViewHalloAndroid = (TextView) findViewById(R.id.textViewHalloAndroid);
        editTextVornameNachname = (EditText) findViewById(R.id.editTextVornameNachname);
        buttonHello = (Button) findViewById (R.id.buttonHello);
        
        buttonHello.setOnClickListener(this);
        buttonHello.setOnClickListener(this);
        
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(View v) {
		textViewHalloAndroid.setText("Hallo\n" + editTextVornameNachname.getText());
		
	}
}
