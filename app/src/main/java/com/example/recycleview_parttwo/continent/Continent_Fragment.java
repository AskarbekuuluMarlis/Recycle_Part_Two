package com.example.recycleview_parttwo.continent;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recycleview_parttwo.OnItemClick;
import com.example.recycleview_parttwo.R;
import com.example.recycleview_parttwo.country.CountryFragment;
import com.example.recycleview_parttwo.databinding.FragmentContinentBinding;

import java.util.ArrayList;

public class Continent_Fragment extends Fragment implements OnItemClick {

private FragmentContinentBinding binding;
private ArrayList<Continent> continentList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContinentBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        ContinentAdapter adapter = new ContinentAdapter(continentList,this);
        binding.rvContinent.setAdapter(adapter);

    }

    private void loadData() {
        continentList.add(new Continent("Asia",""));
        continentList.add(new Continent("Africa",""));
        continentList.add(new Continent("Australia",""));
        continentList.add(new Continent("South America",""));
        continentList.add(new Continent("North America",""));
    }
    @Override
    public void onClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("keyForPosition", String.valueOf(position));
        CountryFragment countryFragment = new CountryFragment();
        countryFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, countryFragment).addToBackStack(null).commit();

    }
}