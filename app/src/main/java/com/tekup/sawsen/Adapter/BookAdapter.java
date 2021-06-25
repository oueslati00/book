package com.tekup.sawsen.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tekup.sawsen.Model.Book;
import com.tekup.sawsen.R;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<Book> {
    // invoke the suitable constructor of the ArrayAdapter class
    public BookAdapter(@NonNull Context context, ArrayList<Book> arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_book, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        Book currentNumberPosition = getItem(position);

        // then according to the position of the view assign the desired image for the same
        ImageView numbersImage = currentItemView.findViewById(R.id.ivBookCover);
        assert currentNumberPosition != null;
        numbersImage.setImageResource(currentNumberPosition.getNumbersImageId());

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView1 = currentItemView.findViewById(R.id.tvAuthor);
        textView1.setText(currentNumberPosition.getAuthor());

        // then according to the position of the view assign the desired TextView 2 for the same
        TextView textView2 = currentItemView.findViewById(R.id.tvTitle);
        textView2.setText(currentNumberPosition.getTitle());

        // then return the recyclable view
        return currentItemView;
    }
}
