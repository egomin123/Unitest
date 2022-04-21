package com.example.unitest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum CorrectUser
{
    UncorrectLenght,
    NoLowerChars,
    NoUpperChars,
    NoNonLetter,
    NoSpechialSimvols,
    nonLetter,
    WrondEmail,
    NoRussianLetters,
    Correct
}

public class User {


    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    private static Pattern pattern;
    private Matcher matcher;

    public User(String emailL, String pas) {
        this.email = emailL;
        this.password = pas;
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);




    }

    public boolean validateEmail(String emailL) {
        matcher = pattern.matcher(emailL);
        return matcher.matches();
    }

    public String email;
    public  String password;
    public CorrectUser CanCreateUser(String log, String pas)
    {
        int digit = 0;
        int lower = 0;
        int upper = 0;
        int nonLetter = 0;
        password = password.trim();
        for (char a: password.toCharArray()) {
            if (Character.isDigit(a))
                digit++;
            if (Character.isLowerCase(a))
                lower++;
            if (Character.isUpperCase(a))
                upper++;
            if (!Character.isLetterOrDigit(a))
                nonLetter++;
        }
        if (password.length() < 7)
            return CorrectUser.UncorrectLenght;
        if (digit < 1)
            return CorrectUser.NoSpechialSimvols;
        if (lower < 1)
            return CorrectUser.NoLowerChars;
        if (upper < 1)
            return CorrectUser.NoUpperChars;
        if (nonLetter < 1)
            return CorrectUser.NoNonLetter;
        if(validateEmail(log) == false)
            return CorrectUser.WrondEmail;
        if(isValid(pas) == false)
            return CorrectUser.NoRussianLetters;

        return CorrectUser.Correct;
    }
    public static boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.UnicodeBlock.of(s.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC)
            ) {
                return false;
            }
        }
        return true;
    }
}
