package com.example.recycleview_parttwo.country;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recycleview_parttwo.R;
import com.example.recycleview_parttwo.databinding.FragmentCountryBinding;

import java.util.ArrayList;

public class CountryFragment extends Fragment {
    public FragmentCountryBinding binding;
    private Integer position;
    public ArrayList<Country> countryList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCountryBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        position = getArguments().getInt("keyForPosition");
        CountryAdapter adapter = new CountryAdapter(countryList);
        binding.rvCountry.setAdapter(adapter);
        positionCountry(position);
    }

    private void positionCountry(int position) {
        switch(position){
            case 0 :
                loadEurasia();
                break;
            case 1:
                loadAfrica();
                break;
            case 2:
                loadAustralia();
                break;
            case 3 :
                loadSouthAmerica();
                break;
            case 4 :
                loadNorthAmerica();
                break;
        }
    }


    private void loadEurasia() {
        countryList.add(new Country("Kyrgyzstan"));
        countryList.add(new Country("Kazakhstan"));
        countryList.add(new Country("Russian"));
        countryList.add(new Country("Ukraine"));
        countryList.add(new Country("Uzbekistan"));
    }
    private void loadAfrica() {
        countryList.add(new Country("Nigeria"));
        countryList.add(new Country("Egypt"));
        countryList.add(new Country("Sudan"));
        countryList.add(new Country("South Sudan"));
        countryList.add(new Country("Morocco"));
    }

    private void loadAustralia() {
        countryList.add(new Country("Australia"));
        countryList.add(new Country("Fiji"));
        countryList.add(new Country("Micronesia"));
        countryList.add(new Country("New Zealand"));
        countryList.add(new Country("Palau"));
    }
    private void loadSouthAmerica() {
        countryList.add(new Country("Argentina"));
        countryList.add(new Country("Brazil"));
        countryList.add(new Country("Colombia"));
        countryList.add(new Country("Paraguay"));
        countryList.add(new Country("Ecuador"));
    }
    private void loadNorthAmerica() {
        countryList.add(new Country("Canada"));
        countryList.add(new Country("United States"));
        countryList.add(new Country("Mexico"));
        countryList.add(new Country("Jamaica"));
        countryList.add(new Country("Costa Rica"));

    }
}