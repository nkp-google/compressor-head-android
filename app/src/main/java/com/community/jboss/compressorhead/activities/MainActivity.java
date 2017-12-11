package com.community.jboss.compressorhead.activities;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.community.jboss.compressorhead.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    private int flagProportionConstrained = 0, width = 0, height = 0,dontChangew = 0, dontChangeh = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextInputEditText pxWidth = findViewById(R.id.widthInPx);
        TextInputEditText pxHeight = findViewById(R.id.heightInPx);
        TextView Percent = findViewById(R.id.percent);
        SeekBar percentBar = findViewById(R.id.percentageGuide);
        percentBar.setMax(100);
        percentBar.setProgress(100);
        percentBar.setEnabled(false);
        percentBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                Percent.setText(getString(R.string.percent, progress));
                if(flagProportionConstrained == 1) {
                    pxWidth.setText(valueOf(width * progress /100));
                    pxHeight.setText(valueOf(height * progress /100));
                }
            }
        });

        CheckBox constrainProportions = findViewById(R.id.constrainProps);
        constrainProportions.setOnCheckedChangeListener((CompoundButton buttonView,boolean isChecked) -> {

                if(isChecked) {
                    if(width == 0 && height == 0) {
                        constrainProportions.setChecked(false);
                        Toast.makeText(MainActivity.this, "Please preview image before constraining proportions", Toast.LENGTH_LONG).show();
                    }
                    else {
                        flagProportionConstrained = 1;
                        percentBar.setEnabled(true);
                    }
                }
                else {
                    flagProportionConstrained = 0;
                    percentBar.setEnabled(false);
                }
        });
        Button Preview = findViewById(R.id.preview);
        Preview.setOnClickListener((View v) -> {
                TextInputEditText imageLink = findViewById(R.id.imageURL);
                ImageView imagePreview = findViewById(R.id.imagePreview);
                Picasso.with(MainActivity.this).load(imageLink.getText().toString()).into(imagePreview, new Callback() {
                    @Override
                    public void onSuccess() {
                        Picasso.with(MainActivity.this).load(imageLink.getText().toString()).into(new Target() {
                            @Override
                            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                width = bitmap.getWidth();
                                height = bitmap.getHeight();
                                dontChangew = dontChangeh = 1;
                                pxWidth.setText(valueOf(width));
                                pxHeight.setText(valueOf(height));
                                dontChangew = dontChangeh = 0;
                            }

                            @Override
                            public void onBitmapFailed(Drawable errorDrawable) {
                                Toast.makeText(MainActivity.this, "Error: Please try checking image URL", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onPrepareLoad(Drawable placeHolderDrawable) {

                            }
                        });

                    }

                    @Override
                    public void onError() {
                        Toast.makeText(MainActivity.this, "Error: Please try checking URL and your internet connection", Toast.LENGTH_SHORT).show();
                    }
                });

        });
        pxWidth.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0 && dontChangew == 0 && flagProportionConstrained == 1) {
                    dontChangeh = 1;
                    pxHeight.setText(valueOf(height * Integer.parseInt(s.toString()) / width));
                    dontChangeh = 0;
                }
            }
        });

        pxHeight.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0 && dontChangeh == 0 && flagProportionConstrained == 1) {
                    dontChangew = 1;
                    pxWidth.setText(valueOf(width * Integer.parseInt(s.toString()) / height));
                    dontChangew = 0;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        final MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_menu_info:
                final InfoDialogFragment dialog = new InfoDialogFragment();
                dialog.show(getSupportFragmentManager(), "info_dialog");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static class InfoDialogFragment extends AppCompatDialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(R.string.title_info);
            builder.setMessage(R.string.description_info_dialog);
            builder.setPositiveButton(R.string.button_info_dialog, null);
            return builder.create();
        }
    }
}
