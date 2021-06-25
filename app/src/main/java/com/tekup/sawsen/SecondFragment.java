package com.tekup.sawsen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.tekup.sawsen.Model.Book;
import com.tekup.sawsen.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    private ImageView ivBookCover;
    private TextView tvTitle;
    private TextView tvAuthor;
    private TextView tvPublisher;
    private TextView tvPageCount;
    private Book book;
    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Fetch views
        ivBookCover = (ImageView) view.findViewById(R.id.ivBookCover);
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvAuthor = (TextView) view.findViewById(R.id.tvAuthor);
        tvPublisher = (TextView) view.findViewById(R.id.tvPublisher);
        tvPageCount = (TextView) view.findViewById(R.id.tvPageCount);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}