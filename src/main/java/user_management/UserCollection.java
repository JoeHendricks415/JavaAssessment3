package user_management;

import parsing_json.Element;
import sun.security.util.Password;
import user_management.security.UserAuthenticationFailedException;
import user_management.validation.EmailNotAvailableException;
import user_management.validation.InvalidEmailException;
import user_management.validation.PasswordTooSimpleException;

import java.net.Authenticator;
import java.util.ArrayList;
import java.util.regex.Pattern;

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

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getEmail().equals(email)) {
                return this.get(i);
            }
        }
        return null;
    }

    public User attemptLogin(String email, String password) throws UserAuthenticationFailedException {

        User user = findByEmail(email);

        if (user.getEmail().equals(email) && user.getPassword().matches(password)) {
                return user;
            }
        throw new UserAuthenticationFailedException();
    }

    public int createUser(String name, String email, String password) throws EmailNotAvailableException, InvalidEmailException, PasswordTooSimpleException {
        //String emailReg = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";
        String emailReg = "^([A-Z|a-z|0-9](\\.|_){0,1})+[A-Z|a-z|0-9]\\@([A-Z|a-z|0-9])+((\\.){0,1}[A-Z|a-z|0-9]){2}\\.[a-z]{2,3}$";

        if (this.findByEmail(email) != null) {
            throw new EmailNotAvailableException();
        }

        if (!email.matches(emailReg)) {
            throw new InvalidEmailException();
        }

        if (password.length() < 8 || !password.matches("/(?=[#$-/:-?{-~!\"^_`\\[\\]a-zA-Z]*([0-9#$-/:-?{-~!\"^_`\\[\\]]))(?=[#$-/:-?{-~!\"^_`\\[\\]a-zA-Z0-9]*[a-zA-Z])[#$-/:-?{-~!\"^_`\\[\\]a-zA-Z0-9]{4,}/g")) {
            throw new PasswordTooSimpleException();
        }

        return 0;
    }
}
