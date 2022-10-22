package com.example.photospostsusingapi.Ui;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.photospostsusingapi.R;
import com.example.photospostsusingapi.data.Model.PhotoResponseItem;
import com.example.photospostsusingapi.data.Source.Remote.RetrofitClient;
import com.example.photospostsusingapi.databinding.FragmentPostsBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostsFragment extends Fragment {

    FragmentPostsBinding binding;
    ProgressDialog mloadingBar ;


    public PostsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentPostsBinding.bind(view);

        fetchPosts();
    }

    private void fetchPosts() {

        waitnig("Loading");
        RetrofitClient.getWebService().getPhotos().enqueue(new Callback<List<PhotoResponseItem>>() {
            @Override
            public void onResponse(Call<List<PhotoResponseItem>> call, Response<List<PhotoResponseItem>> response) {
                Log.d("dddddd", "onResponse: " + response.body());
                mloadingBar.dismiss();
            }

            @Override
            public void onFailure(Call<List<PhotoResponseItem>> call, Throwable t) {
                Log.d("dddddddddd", "onFailure: " + t.getLocalizedMessage());
                mloadingBar.dismiss();
            }
        });

    }


    private void waitnig(String title) {
        mloadingBar = new ProgressDialog(getContext());
        mloadingBar.setTitle(title);
        mloadingBar.setMessage("Please Wait");
        mloadingBar.setCanceledOnTouchOutside(false);
        mloadingBar.show();
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}