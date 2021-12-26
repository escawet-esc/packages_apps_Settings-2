package com.android.settings.deviceinfo.firmwareversion;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

import com.android.settings.R;

import java.util.Random;

public class KepalaKomodo extends Preference {

    public KepalaKomodo(Context context, AttributeSet attrs) {
        super(context, attrs);
	        setLayoutResource(context.getResources().
                getIdentifier("layout/komodo_logo", null, context.getPackageName()));

    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);

        final boolean selectable = false;
        final Context context = getContext();
        ImageView mKomodoPic = holder.itemView.findViewById(context.getResources().
                getIdentifier("id/komodo_pic", null, context.getPackageName()));
        Animation animShake = AnimationUtils.loadAnimation(context, R.anim.komodo_shake);

        holder.itemView.setFocusable(selectable);
        holder.itemView.setClickable(selectable);
        holder.setDividerAllowedAbove(false);
        holder.setDividerAllowedBelow(false);

        mKomodoPic.setClickable(true);
        mKomodoPic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mKomodoPic.startAnimation(animShake);
                String[] randomStrings = new String[]{"Welcome", "i love komodo", "Support us", "Say hi", "Sabre", "Komodo12"  ,"Local Pride!", "Nekat!"};
                Toast.makeText(context.getApplicationContext(), randomStrings[new Random().nextInt(randomStrings.length)], Toast.LENGTH_SHORT).show();
            }
        });
    }

}
