package com.example.teste_menu.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.teste_menu.CarouselAdapter;
import com.example.teste_menu.R;
import com.example.teste_menu.databinding.FragmentHomeBinding;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private CarouselAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inicializa o View Binding CORRETAMENTE
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setupCarousel();
        return root;
    }

    private void setupCarousel() {
        List<Integer> images = Arrays.asList(
                R.drawable.ifrs_uniao,
                R.drawable.ifrs_quadra,
                R.drawable.campus_fachada
        );

        adapter = new CarouselAdapter(images);
        binding.viewPager.setAdapter(adapter);

        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> {}).attach();

        // Configurações adicionais
        binding.viewPager.setOffscreenPageLimit(1);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Limpa a referência do binding
    }
}