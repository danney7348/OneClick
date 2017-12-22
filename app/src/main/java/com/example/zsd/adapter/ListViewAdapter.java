package com.example.zsd.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zsd.R;
import com.example.zsd.entity.ChatContent;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/12/21.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class ListViewAdapter extends BaseAdapter{
    private Context context;
    private List<ChatContent> lists;

    public ListViewAdapter(Context context, List<ChatContent> lists) {
        super();
        this.context = context;
        this.lists = lists;
    }

    /**
     * 是否是自己发送的消息
     *
     * @author cyf
     *
     */
    public static interface IMsgViewType {
        int IMVT_COM_MSG = 0;// 收到对方的消息
        int IMVT_TO_MSG = 1;// 自己发送出去的消息
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return lists.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return lists.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    /**
     * 得到Item的类型，是对方发过来的消息，还是自己发送出去的
     */
    public int getItemViewType(int position) {
        ChatContent entity = lists.get(position);

        if (entity.getFlag()==1) {// 收到的消息
            return IMsgViewType.IMVT_COM_MSG;
        } else {// 自己发送的消息
            return IMsgViewType.IMVT_TO_MSG;
        }
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        // TODO Auto-generated method stub
        HolderView holderView = null;
        ChatContent entity = lists.get(arg0);
        int isMeSend = entity.getFlag();
        if (holderView == null) {
            holderView = new HolderView();
            if (isMeSend==0) {
                arg1 = View.inflate(context, R.layout.chat_dialog_right_item,
                        null);
                holderView.tv_chat_me_message = (TextView) arg1
                        .findViewById(R.id.tv_chat_me_message_right);
                holderView.tv_chat_me_message.setText(entity.getContent());
                TextView time = arg1.findViewById(R.id.chat_tv_time_right);
                time.setText(entity.getTime());
                ImageView icon = arg1.findViewById(R.id.iv_chat_imagr_right);
                Glide.with(context).load(entity.getIconReceive()).into(icon);
                Toast.makeText(context, entity.getContent(), Toast.LENGTH_SHORT).show();
            } else {
                arg1 = View.inflate(context, R.layout.chat_dialog_left_item,
                        null);
                holderView.tv_chat_me_message = (TextView) arg1
                        .findViewById(R.id.tv_chat_me_message_left);
                holderView.tv_chat_me_message.setText(entity.getContent());
                TextView time = arg1.findViewById(R.id.chat_tv_time_left);
                time.setText(entity.getTime());
                ImageView icon = arg1.findViewById(R.id.iv_chat_imagr_left);
                Glide.with(context).load(entity.getIconSend()).into(icon);
                Toast.makeText(context, entity.getContent(), Toast.LENGTH_SHORT).show();
            }
            arg1.setTag(holderView);
        } else {
            holderView = (HolderView) arg1.getTag();
        }

        return arg1;
    }

    class HolderView {
        TextView tv_chat_me_message;
    }

    /*@Override
    public boolean isEnabled(int position) {
        return false;
    }*/
}
