package com.example.pokedex.utils;

import android.app.Dialog;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import com.example.pokedex.R;

public class DialogManager {
    private Context ctx;
    private String title, desc;
    private Button btDialog;
    private TextView tvDialogTitle, tvDialogDesc;

    public DialogManager(Context ctx, String title, String desc) {
        this.ctx = ctx;
        this.title = title;
        this.desc = desc;
    }

    public Dialog buildDialog(){
        final Dialog dialog = new Dialog(ctx);
        dialog.setContentView(R.layout.dialog_pokemon);

        tvDialogTitle= dialog.findViewById(R.id.tvDialogTitle);
        tvDialogTitle.setText(title);


        tvDialogDesc= dialog.findViewById(R.id.tvDialogDesc);
        tvDialogDesc.setText(desc);

        btDialog= dialog.findViewById(R.id.btDialog);

        return dialog;
    }

    public Button getBtDialog() {
        return btDialog;
    }
}
