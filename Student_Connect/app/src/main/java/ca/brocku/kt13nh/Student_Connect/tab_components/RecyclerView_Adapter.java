package ca.brocku.kt13nh.Student_Connect.tab_components;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.brocku.kt13nh.Student_Connect.R;
import ca.brocku.kt13nh.Student_Connect.chatroom_components.Chatroom;


public class RecyclerView_Adapter extends
        RecyclerView.Adapter<DemoViewHolder> {
    private List<Map<String, String>> arrayList;
    private Context context;
    private OnRecyclerClickListener onRecyclerClickListener;

    private TextView Tv;
    private ImageView image;
    private boolean myfav1=false;
    private int k=0;


    public RecyclerView_Adapter(Context context) {
        this.context = context;
        this.arrayList = new ArrayList<>();

    }

    public void addChatroom(Map<String, String> chatroomData){
        arrayList.add(chatroomData);
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

    @Override
    public void onBindViewHolder(DemoViewHolder holder,
                                 int position) {
        final DemoViewHolder mainHolder = (DemoViewHolder) holder;
        //Setting text over textview
        // mainHolder.bind(arrayList.get(position), listener);
        mainHolder.title.setText(arrayList.get(position).get("ChatName"));

    }

    @Override
    public DemoViewHolder onCreateViewHolder(
            ViewGroup viewGroup, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.item_row, viewGroup, false);

        Tv = (TextView) mainGroup.findViewById(R.id.cardTitle);

        //  ArrayList<String> arrayList = new ArrayList<>();
//        for (int i = 0; i <3; i++) {
//
//            //  arrayList.add(courses[i]);//Adding items to recycler view
//            if(arrayList.indexOf(getItemId(i))==1 || arrayList.indexOf(getItemId(i))==2)
//            {
//                // TextView Tv = (TextView) inflater.inflate(R.id.TextView);
//
//                Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
//
//                Tv.setTypeface(boldTypeface);
//            }
//        }
        final DemoViewHolder mainHolder = new DemoViewHolder(mainGroup) {
            @Override
            public String toString() {
                return super.toString();
            }
        };


        k= mainHolder.getLayoutPosition();
        image=(ImageView) mainGroup.findViewById(R.id.iv_image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image=(ImageView) view.findViewById(R.id.iv_image);

                //   image.setFavorite();
                System.out.println("This is my number " + k);
                //     image.setImageResource(R.mipmap.pic);

                if(k==0 || k==1 || k==2)
                    myfav1=false;

                if(!myfav1){
                    myfav1=true;
                    image.setImageResource(R.mipmap.pic);
                }

                else
                {
                    myfav1=false;
                    image.setImageResource(R.mipmap.white);
                }
                int pol[]={0,0,0};
                if(k==0)
                    pol[0]=0;
                else if(k==1)
                    pol[1]=1;
                else if (k==2)
                    pol[2]=2;

            }
        });


        final View.OnClickListener mOnClickListener = new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                int position = mainHolder.getLayoutPosition();
                Map<String, String> chatroom = arrayList.get(position);
                Intent chatroomIntent = new Intent(context, Chatroom.class);
                chatroomIntent.putExtra("chatID", chatroom.get("ChatID"));
                chatroomIntent.putExtra("chatroomName", chatroom.get("ChatName"));
                context.startActivity(chatroomIntent);

            }};

        final View.OnLongClickListener longClickListener= new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View view) {
                //    showChangeLangDialog();
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.menu_add);
                dialog.show();
                return false;
            }
        };

        mainGroup.setOnLongClickListener(longClickListener);
        mainGroup.setOnClickListener(mOnClickListener);

// 13805 ////////////////////////////////
        return mainHolder;

    }



}