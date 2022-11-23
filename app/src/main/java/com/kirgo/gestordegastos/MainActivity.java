package com.kirgo.gestordegastos;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageSwitcher imageSwitcher;

    int[] imageSwitcherImages ={R.drawable.cabecera_gestor_de_gastos, R.drawable.franmento_login};

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        Button buttonLeft = ( Button ) findViewById (R.id.buttonL);
        Button buttonRight = ( Button ) findViewById (R.id.buttonR);

        imageSwitcher = (ImageSwitcher)findViewById (R.id.CarrouselMain);
        imageSwitcher.setFactory (( ) -> {
            ImageView switcherImageView = new ImageView (getApplicationContext ());
            switcherImageView.setLayoutParams (new ViewGroup.LayoutParams (ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
            switcherImageView.setScaleType (ImageView.ScaleType.FIT_CENTER);

            return switcherImageView;
        });
        buttonLeft.setOnClickListener (v -> {
            Toast.makeText (getApplicationContext ( ), "previous Image", Toast.LENGTH_LONG).show ( );
            imageSwitcher.setImageResource (R.drawable.cabecera_gestor_de_gastos);
        });
        buttonRight.setOnClickListener (v -> {
            Toast.makeText (getApplicationContext (),"Next Image",Toast.LENGTH_LONG).show ();
            imageSwitcher.setImageResource (R.drawable.franmento_login);
        });
        Animation animationOut = AnimationUtils.loadAnimation (this, android.R.anim.slide_out_right);
        Animation animationIn = AnimationUtils.loadAnimation (this, android.R.anim.slide_in_left);

        imageSwitcher.setOutAnimation (animationOut);
        imageSwitcher.setInAnimation (animationIn);
    }



    public ImageSwitcher getImageSwitcher ( ) {
        return imageSwitcher;
    }

    public void setImageSwitcher (ImageSwitcher imageSwitcher) {
        this.imageSwitcher = imageSwitcher;
    }
}