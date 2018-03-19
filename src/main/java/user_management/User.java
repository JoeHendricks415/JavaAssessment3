package user_management;

import user_management.security.Password;
import java.io.*;
import java.util.Objects;

public class User{

    private String email;
    private int id;
    private String name;
    private Password password;

    public User(int id, String name, String email, String password) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = new Password(password);
    }


    public User(int id, String name, String email, Password password) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setPassword(String password){
        this.password = new Password(password);
    }

    public void setPassword(Password password){
        this.password = password;
    }

    public Password getPassword(){
        return this.password;
    }

    @Override
    public String toString() {

        return name + " - " + email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return getId() == user.getId() && Objects.equals(getName(), user.getName()) &&
                Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword());

    }

}
