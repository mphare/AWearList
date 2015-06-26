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
  private       ArrayList<CustomBean> mItems;
  private final LayoutInflater        mInflater;

  public WearableAdapter(Context context, ArrayList<CustomBean> items)
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
    circledView.setImageResource(mItems.get(position).getIcon());
    TextView textView = itemViewHolder.mItemTextView;
    textView.setText(mItems.get(position).getLabel());
    TextView textDescView = itemViewHolder.mItemDescTextView;
    textDescView.setText(mItems.get(position).getDescription());
    TextView textNumView = itemViewHolder.mItemNumTextView;
    textNumView.setText(String.valueOf(position));
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
    private TextView         mItemDescTextView;
    private TextView         mItemNumTextView;

    public ItemViewHolder(View itemView)
    {
      super(itemView);
      mCircledImageView = (CircledImageView)
          itemView.findViewById(R.id.circle);
      mItemTextView = (TextView) itemView.findViewById(R.id.name);
      mItemDescTextView = (TextView) itemView.findViewById(R.id.description);
      mItemNumTextView = (TextView) itemView.findViewById(R.id.number);
    }
  }
}
