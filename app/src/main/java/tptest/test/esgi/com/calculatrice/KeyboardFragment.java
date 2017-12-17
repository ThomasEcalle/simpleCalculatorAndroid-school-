package tptest.test.esgi.com.calculatrice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by thoma on 17/12/2017.
 */

public class KeyboardFragment extends Fragment implements View.OnClickListener
{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.keyboard_fragment, container, false);


        view.findViewById(R.id.one).setOnClickListener(this);
        view.findViewById(R.id.two).setOnClickListener(this);
        view.findViewById(R.id.three).setOnClickListener(this);
        view.findViewById(R.id.four).setOnClickListener(this);
        view.findViewById(R.id.five).setOnClickListener(this);
        view.findViewById(R.id.six).setOnClickListener(this);
        view.findViewById(R.id.seven).setOnClickListener(this);
        view.findViewById(R.id.eight).setOnClickListener(this);
        view.findViewById(R.id.nine).setOnClickListener(this);
        view.findViewById(R.id.plus).setOnClickListener(this);
        view.findViewById(R.id.minus).setOnClickListener(this);
        view.findViewById(R.id.equal).setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.equal:
                ((CalulatorInterface) getActivity()).clickedOnEqual();
                break;
            case R.id.plus:
                ((CalulatorInterface) getActivity()).clickedOnadd();
                break;
            case R.id.minus:
                ((CalulatorInterface) getActivity()).clickedOnMinus();
                break;
            default:
                ((CalulatorInterface) getActivity()).clickedOnValue(((TextView) view).getText().toString());
                break;
        }
    }
}
