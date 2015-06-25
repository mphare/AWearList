package com.mphare.awearlist;

import android.content.Context;
import android.support.wearable.view.CircledImageView;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mhare on 6/25/15.
 */
public class WearableAdapter extends WearableListView.Adapter
{
  private       ArrayList<Integer> mItems;
  private final LayoutInflater     mInflater;

  public WearableAdapter(Context context, ArrayList<Integer> items)
  {
    mInflater = LayoutInflater.from(context);
    mItems = items;
  }

  @Override
  public WearableListView.ViewHolder onCreateViewHolder(
      ViewGroup viewGroup, int i)
  {
    return new ItemViewHolder(mInflater.inflate(R.layout.list_item, null));
  }

  @Override
  public void onBindViewHolder(WearableListView.ViewHolder viewHolder,
                               int position)
  {
    ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
    CircledImageView circledView = itemViewHolder.mCircledImageView;
    circledView.setImageResource(mItems.get(position));
    TextView textView = itemViewHolder.mItemTextView;
    textView.setText(String.format("Item %d", position + 1));
  }

  @Override
  public int getItemCount()
  {
    return mItems.size();
  }

  private static class ItemViewHolder extends WearableListView.ViewHolder
  {
    private CircledImageView mCircledImageView;
    private TextView         mItemTextView;

    public ItemViewHolder(View itemView)
    {
      super(itemView);
      mCircledImageView = (CircledImageView)
          itemView.findViewById(R.id.circle);
      mItemTextView = (TextView) itemView.findViewById(R.id.name);
    }
  }
}
