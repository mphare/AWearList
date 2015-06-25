package com.mphare.awearlist;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity
{
  private static ArrayList<Integer> mIcons;
  private        TextView           mHeader;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mIcons = new ArrayList<Integer>();
    mIcons.add(R.drawable.ic_ac);

    final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
    stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener()
    {
      @Override
      public void onLayoutInflated(WatchViewStub stub)
      {
        mTextView = (TextView) stub.findViewById(R.id.text);
      }
    });
  }
}

