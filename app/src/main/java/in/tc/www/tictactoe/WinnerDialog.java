package in.tc.www.tictactoe;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Anoop on 04-01-2018.
 */

public class WinnerDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater  = getActivity().getLayoutInflater();
        View mView = layoutInflater.inflate(R.layout.winner_dialog,null);

        String name = getArguments().getString("winnerName");

        Button coolButton = mView.findViewById(R.id.coolBT);
        TextView winnerName = mView.findViewById(R.id.text);

        winnerName.setText(name+" wins the game");

        coolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        builder.setView(mView);

        return builder.create();

    }
}
