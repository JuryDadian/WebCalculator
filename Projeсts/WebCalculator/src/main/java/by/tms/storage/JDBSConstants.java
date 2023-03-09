package by.tms.storage;

public interface JDBSConstants {
    String URL = "jdbc:postgresql://localhost:5432/postgres";
    String USER = "postgres";
    String PASSWORD = "hazhbilkG";
    String SQL_INSERT_OPERATIONS = "INSERT INTO operations VALUES (DEFAULT, ?, ?, ?, ?)";
    String SQL_FIND_ALL_OPERATIONS = "SELECT * FROM operations";
    String SQL_FIND_BY_ID = "SELECT * FROM operations WHERE id = ?";
    String SQL_DELETE_BY_ID = "DELETE FROM operations WHERE id = ?";
    String SQL_INSERT_USERS = "INSERT INTO users VALUES(DEFAULT, ?, ?, ?)";
    String SQL_DELETE_BY_USERNAME = "DELETE FROM users WHERE username = ?";
    String SQL_FIND_ALL_USERS = "SELECT * FROM users";
    String SQL_DELETE_ALL_USERS = "TRUNCATE TABLE users";
    String SQL_FIND_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
}
