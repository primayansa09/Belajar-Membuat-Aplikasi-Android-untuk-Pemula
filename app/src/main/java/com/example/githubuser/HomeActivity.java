package com.example.githubuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import com.example.githubuser.databinding.ActivityHomeBinding;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

        private ActivityHomeBinding binding;
        private CardUserAdapter cardUserAdapter;
        private ArrayList<User> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvUser.findViewById(R.id.rv_user);
        binding.rvUser.setHasFixedSize(true);

        list.addAll(DataUser.getListData());
        showRecyclerList();

        binding.search.findViewById(R.id.search);
        binding.search.setMaxWidth(Integer.MAX_VALUE);
        binding.search.setImeOptions(EditorInfo.IME_ACTION_DONE);
        binding.search.setQueryHint("User");
        binding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                cardUserAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    private void showRecyclerList() {
        binding.rvUser.setLayoutManager(new GridLayoutManager(this, 2));
        cardUserAdapter = new CardUserAdapter(list);
        binding.rvUser.setAdapter(cardUserAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}