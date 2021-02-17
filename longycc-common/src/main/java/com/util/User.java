package com.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public String username;
    public String email;
    public String password;
}
