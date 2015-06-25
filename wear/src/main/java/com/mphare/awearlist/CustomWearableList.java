package com.mphare.awearlist;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mhare on 6/25/15.
 */
public class CustomWearableList extends Activity
{
  private static ArrayList<Integer> mIcons;
  private        TextView           mHeader;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Sample icons for the list
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
    mIcons.add(R.drawable.ic_action_cut);
    mIcons.add(R.drawable.ic_action_copy);
    mIcons.add(R.drawable.ic_action_delete);
    mIcons.add(R.drawable.ic_action_done);
    mIcons.add(R.drawable.ic_action_edit);
    mIcons.add(R.drawable.ic_action_mail_add);
    mIcons.add(R.drawable.ic_action_overflow);
    mIcons.add(R.drawable.ic_action_paste);
    mIcons.add(R.drawable.ic_action_refresh);
    mIcons.add(R.drawable.ic_action_send);
    mIcons.add(R.drawable.ic_action_share);
    mIcons.add(R.drawable.ic_action_user_add);
    mIcons.add(R.drawable.ic_action_select_all);
    mIcons.add(R.drawable.ic_action_search);

    // This is our list header
    mHeader = (TextView) findViewById(R.id.header);

    WearableListView wearableListView =
        (WearableListView) findViewById(R.id.wearable_list);
    wearableListView.setAdapter(new WearableAdapter(this, mIcons));
    wearableListView.setClickListener(mClickListener);
    wearableListView.addOnScrollListener(mOnScrollListener);
  }

  // Handle our Wearable List's click events
  private WearableListView.ClickListener mClickListener =
      new WearableListView.ClickListener()
      {
        @Override
        public void onClick(WearableListView.ViewHolder viewHolder)
        {
          Toast.makeText(CustomWearableList.this,
                         String.format("You selected item #%s",
                                       viewHolder.getLayoutPosition() + 1),
                         Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onTopEmptyRegionClick()
        {
          Toast.makeText(CustomWearableList.this,
                         "Top empty area tapped", Toast.LENGTH_SHORT).show();
        }
      };

  // The following code ensures that the title scrolls as the user scrolls up
  // or down the list
  private WearableListView.OnScrollListener mOnScrollListener =
      new WearableListView.OnScrollListener()
      {
        @Override
        public void onAbsoluteScrollChange(int i)
        {
          // Only scroll the title up from its original base position
          // and not down.
          if (i > 0)
          {
            mHeader.setY(-i);
          }
        }

        @Override
        public void onScroll(int i)
        {
          // Placeholder
        }

        @Override
        public void onScrollStateChanged(int i)
        {
          // Placeholder
        }

        @Override
        public void onCentralPositionChanged(int i)
        {
          // Placeholder
        }
      };
}
