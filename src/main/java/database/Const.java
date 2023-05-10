package database;

public class Const
{
    public static final String USERS_TABLE = "users";
    public static final String TASKS_TABLE = "tasks";
    //USERS Table Column names
    public static final String USERS_ID = "userid";
    public static final String USERS_FIRSTNAME = "firstname";
    public static final String USERS_LASTNAME = "lastname";
    public static final String USERS_USERNAME = "username";
    public static final String USERS_LOCATION = "location";
    public static final String USERS_GENDER = "gender";
    public static final String USERS_PASSWORD = "password";

    //TASKS Table Column names
    public static final String TASKS_ID = "taskid";
    public static final String TASKS_USER_ID = USERS_ID;
    public static final String TASKS_TASK = "task";
    public static final String TASKS_DATE = "datecreated";
    public static final String TASKS_DESCRIPTION = "description";

    //Store userId of logged user
    public static int LOGGED_USER_ID = 0;
}
