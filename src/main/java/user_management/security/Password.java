package user_management.security;

import org.mindrot.jbcrypt.BCrypt;

public class Password <E>{
    private final static int workload = 12;
    private String salt;
    private static String password;
    private String hash;

    public Password(String password) {
        this.hash = hashPassword(password);
    }

    public static String hashPassword(String password_plaintext) {
         String salt = generateSalt(workload);
         String hash = BCrypt.hashpw(password_plaintext, salt);
         //salt = generateSalt(workload);
         //this.hash = BCrypt.hashpw(password_plaintext, salt);

        return hash;
    }

    public static String generateSalt(int workload){
        return BCrypt.gensalt(workload);
    }

    public boolean matches(String password_plaintext) {
        // Note: normally a match method would include a check to see if the hash is valid but for this exam we will
        //       assume that all the passwords we will check are valid. All of the password hashes in the users.json
        //       file are valid so there should be no worry about this as long as you don't overwrite them manually.
        String hashToCheckAgainst = this.hash;
        return BCrypt.checkpw(password_plaintext, hashToCheckAgainst);

        // hashToCheckAgainst = this.hash
        // hasher.check(password, hashToCheckAgainst)
        // return true if check is true
        // return false if check is false
    }

    public String getHash() {

        return this.hash;
    }
}
