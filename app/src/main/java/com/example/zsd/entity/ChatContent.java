package com.example.zsd.entity;

/**
 * 作者： 张少丹
 * 时间：  2017/12/21.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class ChatContent {
    private int flag;
    private String content;
    private String time;
    private String iconSend;
    private String iconReceive;

    public ChatContent(int flag, String content, String time, String iconSend, String iconReceive) {
        this.flag = flag;
        this.content = content;
        this.time = time;
        this.iconSend = iconSend;
        this.iconReceive = iconReceive;
    }

    public ChatContent() {
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIconSend() {
        return iconSend;
    }

    public void setIconSend(String iconSend) {
        this.iconSend = iconSend;
    }

    public String getIconReceive() {
        return iconReceive;
    }

    public void setIconReceive(String iconReceive) {
        this.iconReceive = iconReceive;
    }

    @Override
    public String toString() {
        return "ChatContent{" +
                "flag=" + flag +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", iconSend='" + iconSend + '\'' +
                ", iconReceive='" + iconReceive + '\'' +
                '}';
    }
}
