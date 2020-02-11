package com.qf.pojo;

/**
 * @Description: 管理员实体类
 * @Author: leilei
 * @Date: 2020/01/07/15:06
 */
public class Admin {
    //id号
    private Integer id;
    //用户名
    private String userName;
    //密码
    private String password;
    //角色
    private String roles;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
