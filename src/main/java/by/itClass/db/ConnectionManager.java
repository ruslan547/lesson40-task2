package by.itClass.db;

import java.sql.*;
import java.util.Objects;

public class ConnectionManager {
    private static Connection cn;

    static  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            if (Objects.isNull(cn) || cn.isClosed()) {
                cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itclassdb?serverTimezone=Europe/Minsk",
                        "root",
                        "");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return cn;
    }

    public static void closeConnection() {
        if (Objects.nonNull(cn)) {
            try {
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement st) {
        if (Objects.nonNull(st)) {
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (Objects.nonNull(rs)) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
