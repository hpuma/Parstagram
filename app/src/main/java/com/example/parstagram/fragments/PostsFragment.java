package com.example.parstagram.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parstagram.Post;
import com.example.parstagram.PostsAdapter;
import com.example.parstagram.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class PostsFragment extends Fragment {

  private RecyclerView rvPosts;
  public static final String TAG = "PostsFragment";
  private PostsAdapter adapter;
  private List<Post> allPosts;

  public PostsFragment() {
    // Required empty public constructor
  }


  public static PostsFragment newInstance(String param1, String param2) {
    PostsFragment fragment = new PostsFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
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
    rvPosts = view.findViewById(R.id.rvPosts);
    allPosts = new ArrayList<>();
    adapter = new PostsAdapter(getContext(), allPosts);

    rvPosts.setAdapter(adapter);
    rvPosts.setLayoutManager(new LinearLayoutManager(getContext()));
    queryPosts();
  }

  private void queryPosts() {
    // Specify which class to query
    ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
    query.include(Post.KEY_USER);
    query.findInBackground(new FindCallback<Post>() {
      @Override
      public void done(List<Post> posts, ParseException e) {
        if (e != null) {
          Log.e(TAG, "Issue with getting posts", e);
        }
        for (Post post: posts){
          Log.i(TAG, "Post" + post.getDescription() + "username:" + post.getUser().getUsername());
        }
        allPosts.addAll(posts);
        adapter.notifyDataSetChanged();
      }
    });
  }


}