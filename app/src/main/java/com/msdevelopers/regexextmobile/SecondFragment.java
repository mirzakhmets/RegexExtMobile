package com.msdevelopers.regexextmobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
//import androidx.navigation.fragment.NavHostFragment;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdSize;
//import com.google.android.gms.ads.AdView;
import com.msdevelopers.regexextmobile.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    //private AdView mAdView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);

        /*
        mAdView = new AdView(getActivity());
        mAdView.setAdUnitId("ca-app-pub-8489476546541939/9417871582");
        //mAdView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        mAdView.setAdSize(AdSize.LARGE_BANNER);

        binding.adLayout2.addView(mAdView);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        */

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*
        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        */

        /*
        mAdView = binding.adView2;
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        */
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}