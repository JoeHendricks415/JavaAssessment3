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

        User user = this.findByEmail(email);

        if (user.getEmail().equals(email)) {
            if (user.getPassword().matches(password)) {
                return user;
            }
        }
        throw new UserAuthenticationFailedException();
    }

    public int createUser(String name, String email, String password) throws EmailNotAvailableException, InvalidEmailException, PasswordTooSimpleException {

        if (this.findByEmail(email) != null) {
            throw new EmailNotAvailableException();
        }

        if (!email.matches("\"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$\"")) {
            throw new InvalidEmailException();
        }

        if (password.length() < 8 || !password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\\\$%\\\\^&\\\\*])")) {
            throw new PasswordTooSimpleException();
        }

        return 0;
    }
}
