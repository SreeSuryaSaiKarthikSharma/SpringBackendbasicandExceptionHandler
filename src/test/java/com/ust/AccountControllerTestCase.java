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


public class AccountControllerTestCase {

@Test
public void testcom.ust.controller.AccountController() { 
 // Arrange
 AccountService param0 = null; 
 //Act 
 AccountControllerinstance = new AccountController(param0); 
//Assert
} 

@Test
public void testaccountService() {
 // Arrange
 Account account = new Account();
 account.setAccountService(null);
 // Act
 // Assert
 Assert.assertEquals(null, account.getAccountService());
}

@Test
public void testhandleAccountNotFoundException() {
 // Arrange
 Account account = new Account();
 AccountNotFoundException param0 = null;
 // Act
 ResponseEntity result = account.handleAccountNotFoundException(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(result).isEqualTo(null);
 softAssertions.assertAll();
}

@Test
public void testhandleNoSuchAccountExistsException() {
 // Arrange
 Account account = new Account();
 NoSuchAccountExistsException param0 = null;
 // Act
 ResponseEntity result = account.handleNoSuchAccountExistsException(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(result).isEqualTo(null);
 softAssertions.assertAll();
}

@Test
public void testhandleAccountAlreadyExistsException() {
 // Arrange
 Account account = new Account();
 AccountAlreadyExistsException param0 = null;
 // Act
 ResponseEntity result = account.handleAccountAlreadyExistsException(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(result).isEqualTo(null);
 softAssertions.assertAll();
}

@Test
public void testsaveAccount() {
 // Arrange
 Account account = new Account();
 Account param0 = null;
 // Act
 ResponseEntity result = account.saveAccount(param0);
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
 ResponseEntity result = account.updateAccount(param0);
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
 ResponseEntity result = account.getAccountById(param0);
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
 ResponseEntity result = account.getAllAccounts();
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(result).isEqualTo(null);
 softAssertions.assertAll();
}

}
