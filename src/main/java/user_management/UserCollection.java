package user_management;

import parsing_json.Element;
import user_management.security.UserAuthenticationFailedException;

import java.util.ArrayList;

public class UserCollection extends ArrayList<User> {

    public User findById(int id) {

            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).getId() == id) {
                    return this.get(i);
                }
            }

        return null;

    }

    public User findByEmail(String email) {

        for(int i = 0; i < this.size(); i++){
            if(this.get(i).getEmail().equals(email)){
                return this.get(i);
            }
        }
        return null;
    }

    public User attemptLogin(String email, String password) throws UserAuthenticationFailedException {



        return null;
    }

    public int createUser(String name, String email, String password) {
        return 0;
    }
}
