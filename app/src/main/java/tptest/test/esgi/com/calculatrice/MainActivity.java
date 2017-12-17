package tptest.test.esgi.com.calculatrice;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements CalulatorInterface
{
    private KeyboardFragment keyboardFragment;
    private ScreenFragment screenFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager supportFragmentManager = getSupportFragmentManager();

        final android.support.v4.app.FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        keyboardFragment = new KeyboardFragment();
        screenFragment = new ScreenFragment();


        fragmentTransaction.add(R.id.keyboardContainer, keyboardFragment);
        fragmentTransaction.add(R.id.previewContainer, screenFragment);

        fragmentTransaction.commit();
    }

    @Override
    public void clickedOnValue(String value)
    {
        screenFragment.changeText(value);
    }

    @Override
    public void clickedOnadd()
    {
        screenFragment.add();
    }

    @Override
    public void clickedOnMinus()
    {
        screenFragment.minus();
    }

    @Override
    public void clickedOnEqual()
    {
        screenFragment.equal();
    }
}
