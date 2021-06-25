package com.tekup.sawsen;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tekup.sawsen.Adapter.BookAdapter;
import com.tekup.sawsen.Model.Book;
import com.tekup.sawsen.databinding.FragmentFirstBinding;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class FirstFragment extends Fragment {
    public static final String BOOK_DETAIL_KEY = "book";
    private ListView lvBooks;
    private BookAdapter bookAdapter;
    private Book book;
    private ProgressBar progress;
    private FragmentFirstBinding binding;
    private FirebaseDatabase database;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvBooks = (ListView) view.findViewById(R.id.lvBooks);
        ArrayList<Book> aBooks = new ArrayList<Book>();
        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Book");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Book book = dataSnapshot.getValue(Book.class);
                aBooks.add(book);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        aBooks.add(new Book("test","test",R.drawable.ic_launcher_background));
        aBooks.add(new Book("test","test",R.drawable.ic_launcher_background));
        aBooks.add(new Book("test","test",R.drawable.ic_launcher_background));
        // initialize the adapter
        bookAdapter = new BookAdapter(this.getContext(), aBooks);
        // attach the adapter to the ListView
        lvBooks.setAdapter(bookAdapter);
        progress = (ProgressBar) view.findViewById(R.id.progressBar);
        progress.setVisibility(View.GONE);
        lvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}