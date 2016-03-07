package phonedialer.lab03.pdsd.systems.cs.pub.ro.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    class OnClickListenerCustom implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            EditText editText = (EditText) findViewById(R.id.editText);
            String text = editText.getText().toString();

            if (v instanceof Button) {
                text += ((Button) v).getText().toString();
                editText.setText(text);
            } else if (v instanceof ImageButton) {
                ImageButton imageButton = (ImageButton) v;
                switch (imageButton.getId()){
                    case R.id.imageButton: {
                        text = text.substring(0,text.length() - 1);
                        editText.setText(text);
                        break;
                    }
                    case R.id.imageButton2: {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + text));
                        startActivity(intent);
                        break;
                    }
                    case R.id.imageButton3: {
                        finish();
                    }
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OnClickListenerCustom onClickListenerCustom = new OnClickListenerCustom();

        GridLayout gridLayout = (GridLayout)findViewById(R.id.grid_layout);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            View view = gridLayout.getChildAt(i);
            view.setOnClickListener(onClickListenerCustom);
        }

        ImageButton imageButton1 = (ImageButton)findViewById(R.id.imageButton);
        ImageButton imageButton2 = (ImageButton)findViewById(R.id.imageButton2);
        ImageButton imageButton3 = (ImageButton)findViewById(R.id.imageButton3);

        imageButton1.setOnClickListener(onClickListenerCustom);
        imageButton2.setOnClickListener(onClickListenerCustom);
        imageButton3.setOnClickListener(onClickListenerCustom);
    }
}
