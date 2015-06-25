package com.mphare.awearlist;

import android.app.Activity;
import android.os.Bundle;
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
    mIcons.add(R.drawable.ic_action_attach);
    mIcons.add(R.drawable.ic_action_call);
    mIcons.add(R.drawable.ic_action_locate);
    mIcons.add(R.drawable.ic_action_mail);
    mIcons.add(R.drawable.ic_action_microphone);
    mIcons.add(R.drawable.ic_action_photo);
    mIcons.add(R.drawable.ic_action_star);
    mIcons.add(R.drawable.ic_action_user);
    mIcons.add(R.drawable.ic_action_video);
    mIcons.add(R.drawable.ic_action_copy);
    mIcons.add(R.drawable.ic_action_cut);

    mHeader = (TextView) findViewById(R.id.header);
  }
}

