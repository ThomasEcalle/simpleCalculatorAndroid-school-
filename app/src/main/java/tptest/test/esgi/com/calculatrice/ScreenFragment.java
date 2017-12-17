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

public class ScreenFragment extends Fragment
{
    private TextView value;
    private TextView hisory;

    private String previousSymbol;
    private long actualCount;
    private String actualNumber;
    private String previousNumber;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.screen_fragment, container, false);

        this.hisory = view.findViewById(R.id.history);
        this.value = view.findViewById(R.id.value);

        this.actualCount = 0;
        this.previousSymbol = "";
        this.actualNumber = "";

        return view;
    }

    private void updateHistory(String value)
    {
        final String previous = this.hisory.getText().toString();

        this.hisory.setText(previous + value);
    }

    public void changeText(String value)
    {
        updateHistory(value);
        this.value.setText("");
        actualNumber += value;
        this.value.setText(actualNumber);

    }

    public void add()
    {
        updateHistory("+");
        this.value.setText("+");
        this.previousNumber = actualNumber;
        this.actualNumber = "";
        this.value.setText("+");
        this.previousSymbol = "+";
    }

    public void minus()
    {
        updateHistory("-");
        this.value.setText("-");

        this.previousNumber = actualNumber;
        this.actualNumber = "";
        this.previousSymbol = "-";
    }

    public void equal()
    {
        updateHistory("=");
        this.value.setText("");
        if (this.previousSymbol.equals("+"))
        {
            this.actualCount = Long.valueOf(previousNumber) + Long.valueOf(actualNumber);
        }
        else if (this.previousSymbol.equals("-"))
        {
            this.actualCount = Long.valueOf(previousNumber) - Long.valueOf(actualNumber);
        }
        final String result = String.valueOf(this.actualCount);
        updateHistory(result);
        this.value.setText(result);
        this.previousSymbol = "";
        this.previousNumber = String.valueOf(this.actualCount);
        this.actualNumber = String.valueOf(this.actualCount);
    }
}
