package com.nsbfilesharing.ShareD.app;

import com.nsbfilesharing.ShareD.widget.EditableListAdapter;

/**
 * created by: veli
 * date: 8/24/18 1:36 PM
 */
public interface EditableListFragmentModelImpl<V extends EditableListAdapter.EditableViewHolder>
{
    void setLayoutClickListener(EditableListFragment.LayoutClickListener<V> clickListener);
}
