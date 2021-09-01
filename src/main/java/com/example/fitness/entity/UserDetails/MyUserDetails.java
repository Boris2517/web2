package com.example.fitness.entity.UserDetails;

import com.example.fitness.entity.Admin;
import com.example.fitness.entity.Member;
import com.example.fitness.entity.Role;
import com.example.fitness.entity.Trainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private String username;
    private String password;
    private Boolean active;
    private Role role;
    private ArrayList<GrantedAuthority> authorityList = new ArrayList<>();


    public MyUserDetails(Member member){
        this.username = member.getUsername();
        this.password = member.getPassword();
        this.active = member.getActive();
        this.role = member.getRole();
        this.authorityList.add(member.getRole());
    }

    public MyUserDetails(Trainer trainer){
        this.username = trainer.getUsername();
        this.password = trainer.getPassword();
        this.active = trainer.getActive();
        this.role = trainer.getRole();
        this.authorityList.add(trainer.getRole());
    }

    public MyUserDetails(Admin admin){
        this.username = admin.getUsername();
        this.password = admin.getPassword();
        this.active = admin.getActive();
        this.role = admin.getRole();
        this.authorityList.add(admin.getRole());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    public MyUserDetails() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<GrantedAuthority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(GrantedAuthority authority) {
        this.authorityList.add(authority);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
