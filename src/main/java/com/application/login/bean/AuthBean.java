package com.application.login.bean;

import com.application.login.model.User;
import com.application.login.service.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@ManagedBean
@ViewScoped
@Component
public class AuthBean implements Serializable {

    @Autowired
    private UserService userService;

    private String username;
    private String password;
    private String newName;
    private String newSurname;
    private String newMail;
    private String newPhone;
    private String newUsername;
    private String newPassword;

    // Giriş yapma işlevi
    public String login() {
        User existingUser = userService.findByUsername(username);
        if (existingUser != null && existingUser.getPassword().equals(password)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Giriş başarılı!"));
            return "home.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Giriş başarısız!", "Kullanıcı adı veya şifre yanlış."));
            return null;
        }
    }

    // Kayıt olma işlevi
    public void register() {
        try {
            User user = new User();
            user.setUsername(newUsername);
            user.setPassword(newPassword);
            user.setName(newName);
            user.setSurname(newSurname);
            user.setMail(newMail);
            user.setPhone(newPhone);

            userService.save(user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kayıt başarılı! Giriş yapabilirsiniz."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Kayıt başarısız", e.getMessage()));
        }
    }

    // Getters ve Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewSurname() {
        return newSurname;
    }

    public void setNewSurname(String newSurname) {
        this.newSurname = newSurname;
    }

    public String getNewMail() {
        return newMail;
    }

    public void setNewMail(String newMail) {
        this.newMail = newMail;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
