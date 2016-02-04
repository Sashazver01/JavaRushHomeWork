package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {
    public static final class Constants
    {
        public static final String ServerNotAccessibleExceptionText = "Server is not accessible for now.";
        public static final String UnauthorizedUserExceptionText = "User is not authorized.";
        public static final String BannedUserExceptionText = "User is banned.";
        public static final String RestrictionExceptionText = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.ServerNotAccessibleExceptionText);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.ServerNotAccessibleExceptionText, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.UnauthorizedUserExceptionText);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.UnauthorizedUserExceptionText, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.BannedUserExceptionText);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.BannedUserExceptionText, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.RestrictionExceptionText);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.RestrictionExceptionText, cause);
        }
    }
}
