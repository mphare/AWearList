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
  private static ArrayList<Integer>    mIcons;
  private static ArrayList<String>     mLabels;
  private static ArrayList<String>     mDescriptions;
  private static ArrayList<CustomBean> customBeans;

  private TextView mHeader;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mLabels = new ArrayList<String>();
    mLabels.add("Attach");
    mLabels.add("Call");
    mLabels.add("Locate");
    mLabels.add("Mail");
    mLabels.add("Mic");
    mLabels.add("Photo");
    mLabels.add("Star");
    mLabels.add("User");
    mLabels.add("Video");
    mLabels.add("Cut");
    mLabels.add("Copy");
    mLabels.add("Delete");
    mLabels.add("Done");
    mLabels.add("Edit");
    mLabels.add("Mail Add");
    mLabels.add("Overflow");
    mLabels.add("Paste");
    mLabels.add("Refresh");
    mLabels.add("Send");
    mLabels.add("Share");
    mLabels.add("User Add");
    mLabels.add("Select All");
    mLabels.add("Search");

    mDescriptions = new ArrayList<String>();
    mDescriptions.add("Attach something");
    mDescriptions.add("Call someone");
    mDescriptions.add("Locate somethingg");
    mDescriptions.add("Read mail");
    mDescriptions.add("Talk to something");
    mDescriptions.add("Take a picture");
    mDescriptions.add("Important stuff");
    mDescriptions.add("Identify someone");
    mDescriptions.add("Make a video");
    mDescriptions.add("Cut ot the clipboard");
    mDescriptions.add("Copy to the clipboard");
    mDescriptions.add("Delete something");
    mDescriptions.add("Finished!");
    mDescriptions.add("Change something");
    mDescriptions.add("Create new mail");
    mDescriptions.add("Too much!");
    mDescriptions.add("paste from the clipboard");
    mDescriptions.add("Refresh");
    mDescriptions.add("Send something");
    mDescriptions.add("Share with someone");
    mDescriptions.add("Create a new user");
    mDescriptions.add("Select everything");
    mDescriptions.add("Search for something");

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

    customBeans = new ArrayList<CustomBean>();
    for (int i = 0; i < mIcons.size(); ++i)
    {
      customBeans.add(new CustomBean(mIcons.get(i), mLabels.get(i), mDescriptions.get(i)));
    }

    // This is our list header
    mHeader = (TextView) findViewById(R.id.header);

    WearableListView wearableListView =
        (WearableListView) findViewById(R.id.wearable_list);
    wearableListView.setAdapter(new WearableAdapter(this, customBeans));
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
