package c347.rp.edu.sg.p11_mydatabook;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BioFragment extends Fragment {

    Button btnEdit;
    TextView tvBio;

    public BioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View bioFrag = inflater.inflate(R.layout.biofragment, container, false);

        btnEdit = bioFrag.findViewById(R.id.btnEdit);
        tvBio = bioFrag.findViewById(R.id.tvBio);

        final View editView = inflater.inflate(R.layout.edit_dialog, null);
        final EditText etBio = editView.findViewById(R.id.etBio);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setView(editView);

                etBio.setText(tvBio.getText().toString());

                builder.setTitle("Edit Bio")
                        .setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tvBio.setText(etBio.getText().toString());
                            }
                        })
                        .setCancelable(false)
                        .setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog editDialog = builder.create();
                editDialog.show();
            }
        });

        return bioFrag;
    }
}
