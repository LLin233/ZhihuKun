package androidpath.ll.zhihukun.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidpath.ll.zhihukun.R;
import androidpath.ll.zhihukun.models.Story;
import androidpath.ll.zhihukun.utils.Utils;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Le on 2015/11/8.
 */
public class StoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ANIMATED_ITEMS_COUNT = 2;

    private Context mContext;
    private int lastAnimatedPosition = -1;
    private int itemsCount = 0;
    private List<Story> mStories;

    public StoryAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_story, parent, false);
        return new CellFeedViewHolder(view);
    }

    private void runEnterAnimation(View view, int position) {
        if (position >= ANIMATED_ITEMS_COUNT - 1) {
            return;
        }

        if (position > lastAnimatedPosition) {
            lastAnimatedPosition = position;
            view.setTranslationY(Utils.getScreenHeight(mContext));
            view.animate()
                    .translationY(0)
                    .setInterpolator(new DecelerateInterpolator(3.f))
                    .setDuration(700)
                    .start();
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        runEnterAnimation(viewHolder.itemView, position);
        CellFeedViewHolder holder = (CellFeedViewHolder) viewHolder;
        holder.storyTitle.setText(mStories.get(position).getTitle());
        Picasso.with(mContext)
                .load(mStories.get(position).getImages())
                .into(holder.storyImage);
    }

    @Override
    public int getItemCount() {
        return itemsCount;
    }

    public void setDataSet(List<Story> stories) {
        mStories = stories;
    }

    public static class CellFeedViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.list_item_story_img)
        ImageView storyImage;
        @Bind(R.id.list_item_story_title)
        TextView storyTitle;

        public CellFeedViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void updateItems(int num) {
        itemsCount = num;
        notifyDataSetChanged();
    }
}