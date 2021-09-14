package com.example.githubuser;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.example.githubuser.databinding.ActivityLayoutDetailBinding;
import java.io.File;


public class LayoutDetail extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_USER = "extra_user";
    private ActivityLayoutDetailBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_detail);

        binding = ActivityLayoutDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageView btnDetail = findViewById(R.id.btn_back);
        ImageView btnShare = findViewById(R.id.btn_share);
        binding.imgDetail.findViewById(R.id.img_detail);
        binding.nameDetail.findViewById(R.id.name_detail);
        binding.userName.findViewById(R.id.user_name);
        binding.valueCompany.findViewById(R.id.value_company);
        binding.valueLocation.findViewById(R.id.value_location);
        binding.valueRepository.findViewById(R.id.value_repository);
        binding.valueFollower.findViewById(R.id.value_follower);
        binding.valueFollowing.findViewById(R.id.value_following);

       User user = getIntent().getParcelableExtra(EXTRA_USER);
       int imguser = user.getPhotoUser();
       String nameUser = user.getNamaUser();
       String userName = user.getUsername();
       String company = user.getCompanyUser();
       String location = user.getLocationUser();
       String repositosy = user.getRepositoryUser();
       String follower = user.getFollowerUser();
       String following = user.getFollowingUser();

       binding.imgDetail.setImageResource(imguser);
       binding.nameDetail.setText(nameUser);
       binding.userName.setText(userName);
       binding.valueCompany.setText(company);
       binding.valueLocation.setText(location);
       binding.valueRepository.setText(repositosy);
       binding.valueFollower.setText(follower);
       binding.valueFollowing.setText(following);

       btnDetail.setOnClickListener(this);
       btnShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_share:
                ApplicationInfo api = getApplicationContext().getApplicationInfo();
                String apk = api.sourceDir;
                Intent mShare =new Intent(Intent.ACTION_SEND);
                mShare.setType("application/vnd.android.package-archive");
                mShare.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(apk)));
                startActivity(Intent.createChooser(mShare, null));
                break;
        }
    }
}