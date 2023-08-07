package com.ust;
import org.junit.jupiter.api.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assert;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.time.*;
import java.util.regex.*;
import javax.swing.*;
import java.net.*;
import java.sql.*;
import org.springframework.http.*;
import org.springframework.boot.test.context.SpringBootTest;


public class AccountServiceTestCase {

@Test
public void testsaveAccount() {
 // Arrange
 Account account = new Account();
 Account param0 = null;
 // Act
 Account result = account.saveAccount(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(result).isEqualTo(null);
 softAssertions.assertAll();
}

@Test
public void testupdateAccount() {
 // Arrange
 Account account = new Account();
 Account param0 = null;
 // Act
 Account result = account.updateAccount(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(result).isEqualTo(null);
 softAssertions.assertAll();
}

@Test
public void testgetAccountById() {
 // Arrange
 Account account = new Account();
 int param0 = 0;
 // Act
 Account result = account.getAccountById(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(result).isEqualTo(null);
 softAssertions.assertAll();
}

@Test
public void testgetAllAccounts() {
 // Arrange
 Account account = new Account();
 // Act
 List result = account.getAllAccounts();
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(result).isEqualTo(null);
 softAssertions.assertAll();
}

}
