package rafaelacs.com.br.thrateapp.util;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import rafaelacs.com.br.thrateapp.R;

public class RateDialogFeedbackFrag extends RateDialogFrag {

    private static final String RATING_KEY = "rating";
    private float rating;
    private EditText etFeedback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rate_dialog_feedback, container);

        if(savedInstanceState != null){
            rating = savedInstanceState.getFloat(RATING_KEY);
        }

        etFeedback = (EditText) view.findViewById(R.id.et_feedback);

        View bt = view.findViewById(R.id.bt_no);
        bt.setOnClickListener(this);

        bt = view.findViewById(R.id.bt_send);
        bt.setOnClickListener(this);

        return view;
    }

    public void setRating(float rating){
        this.rating = rating;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putFloat(RATING_KEY, rating);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View view) {
        String feedback = etFeedback.getText().toString();

        if(view.getId() == R.id.bt_send && feedback.length() > 0){
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setType("text/plain");
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"rafaelacristina@ymail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Avaliação aplicativo");
            intent.putExtra(Intent.EXTRA_TEXT, "Estrelas: " + rating + "\n\nAvaliação: " + feedback);

            getActivity().startActivity(Intent.createChooser( intent, "Enviar e-mail"));
        } else if(view.getId() == R.id.bt_send){
            Toast.makeText(getActivity(), "Entre com o feedback", Toast.LENGTH_SHORT).show();
            return;
        }
        dismiss();
    }

}
