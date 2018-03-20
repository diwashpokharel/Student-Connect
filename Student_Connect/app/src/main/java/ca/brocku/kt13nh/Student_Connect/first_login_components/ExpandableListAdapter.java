package ca.brocku.kt13nh.Student_Connect.first_login_components;
import java.util.HashMap;
import java.util.List;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import ca.brocku.kt13nh.Student_Connect.R;

/**
 * This class is used for the ExpandableListView in the HobbiesRegisterPage.
 * Still need to add a button to activity_hobbies_register_page.xml, doesn't show up properly when
 * using ExpandableListView.*******************************************************
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;

    }//constructor

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }//getChild

    @Override
    public long getChildId(int groupPosition, int childPosition) {

        return childPosition;
    }//getChildId

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);

        txtListChild.setText(childText);
        return convertView;

    }//getChildView

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();

    }//getChildrenCount

    @Override
    public Object getGroup(int groupPosition) {

        return this._listDataHeader.get(groupPosition);

    }//getGroup

    @Override
    public int getGroupCount() {

        return this._listDataHeader.size();

    }//getGroupCount

    @Override
    public long getGroupId(int groupPosition) {

        return groupPosition;

    }//getGroupId

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;

    }//getGroupView

    @Override
    public boolean hasStableIds() {

        return false;

    }//hasStableIds

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {

        return true;

    }//isChildSelectable

}//ExpandableListAdapter