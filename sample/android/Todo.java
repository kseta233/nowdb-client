package com.eworkbandung.nowdb.example.model;

/**
 * Created by Seta on 9/3/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Todo {

    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("mark")
    @Expose
    private String mark;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     *
     * @return
     * The action
     */
    public String getAction() {
        return action;
    }

    /**
     *
     * @param action
     * The action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     *
     * @return
     * The time
     */
    public String getTime() {
        return time;
    }

    /**
     *
     * @param time
     * The time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     *
     * @return
     * The mark
     */
    public String getMark() {
        return mark;
    }

    /**
     *
     * @param mark
     * The mark
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[Todo = id:"+id+" , action:"+action+" , time: "+time+" , mark: "+mark+" ]";
    }

}
/* manual
public class Todo {
    String id;
    String action;
    long time;
    boolean mark;

    @Override
    public String toString() {
        return "[Todo = id:"+id+" , action:"+action+" , time: "+time+" , mark: "+mark+" ]";
    }
}
*/
