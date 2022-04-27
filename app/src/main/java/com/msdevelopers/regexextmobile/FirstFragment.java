package com.msdevelopers.regexextmobile;

import static com.msdevelopers.regexextmobile.R.*;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdSize;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.msdevelopers.regexextmobile.databinding.FragmentFirstBinding;
import com.regexplus.automaton.dfa.DeterministicAutomaton;
import com.regexplus.automaton.model.Automaton;
import com.regexplus.automaton.model.StringStream;
import com.regexplus.match.common.IMatch;

import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    //private AdView mAdView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        /*
        mAdView = new AdView(getActivity());
        mAdView.setAdUnitId("ca-app-pub-8489476546541939/9417871582");
        //mAdView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        mAdView.setAdSize(AdSize.LARGE_BANNER);

        binding.adLayout1.addView(mAdView);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        */

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast aaa = Toast.makeText(FirstFragment.this.getContext(), "aaa", Toast.LENGTH_LONG);
                //aaa.show();

                String pattern = binding.pattern.getText().toString();

                if (pattern.trim().length() == 0) {
                    Toast.makeText(getContext(), "Pattern empty", Toast.LENGTH_LONG).show();
                    return;
                }

                String text = binding.text.getText().toString();

                Automaton automaton = new Automaton();

                automaton.build(new StringStream(pattern));

                DeterministicAutomaton deterministicAutomaton = new DeterministicAutomaton(automaton);

                if (deterministicAutomaton.matches(new StringStream(text))) {
                    List<IMatch> matches = deterministicAutomaton.match(new StringStream(text));

                    Toast.makeText(getContext(), "Matched", Toast.LENGTH_LONG).show();

                    String result = text.substring(matches.get(0).start(), matches.get(0).end());

                    binding.result.setText(result);
                } else {
                    Toast.makeText(getContext(), "Not matched", Toast.LENGTH_LONG).show();

                    binding.result.setText("");
                }
            }
        });

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(id.action_FirstFragment_to_SecondFragment);
            }
        });

        /*
        MobileAds.initialize(this.getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        */

        /*
        mAdView = binding.adView;
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        */
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    //@Override
    //public void onClick(View view) {
    //    Toast.makeText(this.getActivity(), "aaa", Toast.LENGTH_LONG);
    //}
}