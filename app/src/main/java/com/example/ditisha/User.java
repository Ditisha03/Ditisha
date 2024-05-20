package com.example.ditisha;

public class User {

        public String username;
        public String phone;
        public int age;
        public String password;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public User(String username, String phone, int age, String password) {
            this.username = username;
            this.phone = phone;
            this.age = age;
            this.password = password;
        }

}
