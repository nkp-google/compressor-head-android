package com.community.jboss.compressorhead.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.community.jboss.compressorhead.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
