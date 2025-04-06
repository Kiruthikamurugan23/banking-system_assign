package com.hexaware.main;

import java.sql.Connection;
import com.hexaware.util.DBUtil; // Use your actual DBUtil class

public class MainApplication {
    public static void main(String[] args) {
        try (Connection conn = DBUtil.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Database connection established successfully.");
            } else {
                System.out.println("❌ Failed to connect to the database.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error while connecting: " + e.getMessage());
            e.printStackTrace();
        }
    }
}