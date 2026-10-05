package com.fhp.macro;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(40, 40, 40, 40);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView title = new TextView(this);
        title.setText("FHP Auto");
        title.setTextSize(30);
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER);
        layout.addView(title);

        TextView description = new TextView(this);
        description.setText(
            "Automação de cliques e entrada de texto"
        );
        description.setTextSize(17);
        description.setPadding(0, 20, 0, 30);
        layout.addView(description);

        Button addClick = new Button(this);
        addClick.setText("Adicionar clique");
        layout.addView(addClick);

        Button addText = new Button(this);
        addText.setText("Adicionar texto");
        layout.addView(addText);

        Button start = new Button(this);
        start.setText("▶ Iniciar automação");
        layout.addView(start);

        Button stop = new Button(this);
        stop.setText("■ Parar");
        layout.addView(stop);

        setContentView(layout);
    }
}
