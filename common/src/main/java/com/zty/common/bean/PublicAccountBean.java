/**
  * Copyright 2019 bejson.com 
  */
package com.zty.common.bean;
import java.io.Serializable;
import java.util.List;

/**
 * Auto-generated: 2019-10-30 11:22:27
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class PublicAccountBean implements Serializable {

    private List<String> children;
    private int courseId;
    private int id;
    private String name;
    private long order;
    private int parentChapterId;
    private boolean userControlSetTop;
    private int visible;
    public void setChildren(List<String> children) {
         this.children = children;
     }
     public List<String> getChildren() {
         return children;
     }

    public void setCourseId(int courseId) {
         this.courseId = courseId;
     }
     public int getCourseId() {
         return courseId;
     }

    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setOrder(long order) {
         this.order = order;
     }
     public long getOrder() {
         return order;
     }

    public void setParentChapterId(int parentChapterId) {
         this.parentChapterId = parentChapterId;
     }
     public int getParentChapterId() {
         return parentChapterId;
     }

    public void setUserControlSetTop(boolean userControlSetTop) {
         this.userControlSetTop = userControlSetTop;
     }
     public boolean getUserControlSetTop() {
         return userControlSetTop;
     }

    public void setVisible(int visible) {
         this.visible = visible;
     }
     public int getVisible() {
         return visible;
     }

}