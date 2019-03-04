package com.example.menus;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ActionMode mActionMode = null;
    private ImageButton mButton = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView article_text = findViewById(R.id.textField);
        registerForContextMenu(article_text);
        /////////// action mode
        View view = findViewById(R.id.scroll_text);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (mActionMode != null) return false;
                mActionMode = startActionMode(mActionModeCallback);
                view.setSelected(true);
                return true;
            }
        });

        //imagebutton
        mButton = findViewById(R.id.button_popup);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, mButton);
                popup.getMenuInflater().inflate(
                        R.menu.menu_pop, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.popup_1:
                        Toast toast = Toast.makeText(getApplicationContext(),
                        "Debug",
                        Toast.LENGTH_SHORT);
                        toast.show();
                                return true;
                            default:
                                return false;
                        }

                    }
                });
                popup.show();

            }
        });

    }


    public ActionMode.Callback mActionModeCallback =
            new ActionMode.Callback() {
                @Override
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    if(mode != null) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Debug1 not null",
                                Toast.LENGTH_SHORT);
                        toast.show();
                    }else{
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Debug1 null",
                                Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    mode.getMenuInflater().inflate(R.menu.menu_actionmode,menu);
                    mode.setTitle("Choose your option");
                    return true;
                }

                @Override
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                @Override
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.context_option1:{
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Option1",
                                    Toast.LENGTH_SHORT);
                            toast.show();
                            mode.finish();
                            return true;
                        }
                        case R.id.context_option2: {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Option2",
                                    Toast.LENGTH_SHORT);
                            toast.show();
                            mode.finish();
                            return true;
                        }
                        default:
                            return false;
                    }

                }

                @Override
                public void onDestroyActionMode(ActionMode mode) {
                    mActionMode = null;
                }
                // Implement action mode callbacks here.
            };

    //


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_edit: {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Edit",
                        Toast.LENGTH_SHORT);
                toast.show();
                onClickShowAlert();
                return true;
            }
            case R.id.context_share: {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Share",
                        Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }
            default:
                return super.onContextItemSelected(item);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_settings:
                Toast toast = Toast.makeText(getApplicationContext(),
                        "This is a message displayed in a Toast",
                        Toast.LENGTH_SHORT);

                toast.show();                //showSettings();
                return true;
//            case R.id.action_favorites:
                //showFavorites();
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClickShowAlert() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title
        alertDialogBuilder.setTitle("Your Title");

        // set dialog message
        alertDialogBuilder
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }


    }
