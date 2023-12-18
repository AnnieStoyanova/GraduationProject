//package com.GraduationProject.graduation.data.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Set;
//
//@Getter
////@Entity
//public class User extends BaseEntity implements UserDetails {
//    private String username;
//    private String password;
//    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
//    private Set<Role> authorities;
//    private boolean accountNonExpired;
//    private boolean accountNonLocked;
//    private boolean credentialsNonExpired;
//    private boolean enabled;
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setAuthorities(Set<Role> authorities) {
//        this.authorities = authorities;
//    }
//
//    public void setAccountNonExpired(boolean accountNonExpired) {
//        this.accountNonExpired = accountNonExpired;
//    }
//
//    public void setAccountNonLocked(boolean accountNonLocked) {
//        this.accountNonLocked = accountNonLocked;
//    }
//
//    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
//        this.credentialsNonExpired = credentialsNonExpired;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
//
//
//    @Override
//    public String toString() {
//        return "User{" +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", authorities=" + authorities +
//                ", accountNonExpired=" + accountNonExpired +
//                ", accountNonBlocked=" + accountNonLocked +
//                ", credentialsNonExpired=" + credentialsNonExpired +
//                ", enabled=" + enabled +
//                '}';
//    }
//}
//
