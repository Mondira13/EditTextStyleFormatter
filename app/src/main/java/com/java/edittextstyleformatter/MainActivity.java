package com.java.edittextstyleformatter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chinalwb.are.AREditText;
import com.chinalwb.are.styles.toolbar.ARE_ToolbarDefault;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_Bold;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_Italic;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_Underline;
import com.chinalwb.are.styles.toolitems.IARE_ToolItem;

public class MainActivity extends AppCompatActivity {

    AREditText arEditText;
    ARE_ToolbarDefault toolbarDefault;
    TextView showText;
    Button button;
    Spanned html;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();
        setFormatToolIcon();
        onClickListener();

    }

    private void initializeView() {
        arEditText = findViewById(R.id.addEmailText);
        toolbarDefault = findViewById(R.id.areToolbar);
        showText = findViewById(R.id.showText);
        button = findViewById(R.id.submitButton);
    }

    private void setFormatToolIcon() {
        IARE_ToolItem bold = new ARE_ToolItem_Bold();
        IARE_ToolItem italic = new ARE_ToolItem_Italic();
        IARE_ToolItem underline = new ARE_ToolItem_Underline();

        toolbarDefault.addToolbarItem(bold);
        toolbarDefault.addToolbarItem(italic);
        toolbarDefault.addToolbarItem(underline);

        arEditText.setToolbar(toolbarDefault);
    }

    private void onClickListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                html = Html.fromHtml(arEditText.getHtml()); // get text with style in html format
                String s = "$html"; // string parsing
                Log.d("html",s); // print text in html format
                showText.setText(html);

            }
        });
    }

}
