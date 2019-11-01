/**
 * FileName: UserBean
 * Author: zty
 * Date: 2019-10-26 12:15
 * Description: 用户的实体类
 */
package com.zty.archdemo.model.bean;

import com.zty.common.base.BaseModel;

import java.util.List;

/**
 * @ClassName: UserBean
 * @Description: java类作用描述
 * @Author: zty
 * @Date: 2019-10-26 12:15
 */
public class UserBean implements BaseModel {
    private List<Integer> collectIds;
    private String icon;
    private String email;
    private int  id;
    private String  password;
    private String username;
    private int type;

    public List<Integer> getCollectIds() {
        return collectIds;
    }

    public void setCollectIds(List<Integer> collectIds) {
        this.collectIds = collectIds;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}