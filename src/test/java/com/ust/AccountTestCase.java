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


public class AccountTestCase {

@Test
public void testcom.ust.model.Account() { 
 // Arrange
 int param0 = 0; 
 String param1 = null; 
 String param2 = null; 
 int param3 = 0; 
 //Act 
 Accountinstance = new Account(param0, param1, param2, param3); 
//Assert
} 

@Test
public void testcom.ust.model.Account() { 
 // Arrange
 //Act 
 Accountinstance = new Account(); 
//Assert
} 

@Test
public void testaccountId() {
 // Arrange
 Account account = new Account();
 account.setAccountId(2023);
 // Act
 // Assert
 Assert.assertEquals(2023, account.getAccountId());
}

@Test
public void testaTitle() {
 // Arrange
 Account account = new Account();
 account.setATitle("Sree");
 // Act
 // Assert
 Assert.assertEquals("Sree", account.getATitle());
}

@Test
public void testaCreator() {
 // Arrange
 Account account = new Account();
 account.setACreator("Sree");
 // Act
 // Assert
 Assert.assertEquals("Sree", account.getACreator());
}

@Test
public void testyearOfCreation() {
 // Arrange
 Account account = new Account();
 account.setYearOfCreation(2023);
 // Act
 // Assert
 Assert.assertEquals(2023, account.getYearOfCreation());
}

@Test
public void testtoString() {
 // Arrange
 Account account = new Account();
 // Act
 String result = account.toString();
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(result).isEqualTo(null);
 softAssertions.assertAll();
}

@Test
public void testgetAccountId() {
 // Arrange
 Account account = new Account();
 // Act
 int result = account.getAccountId();
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(result).isEqualTo(0);
 softAssertions.assertAll();
}

@Test
public void testsetAccountId() {
 // Arrange
 Account account = new Account();
 int param0 = 0;
 // Act
 void result = account.setAccountId(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertAll();
}

@Test
public void testgetaTitle() {
 // Arrange
 Account account = new Account();
 // Act
 String result = account.getaTitle();
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(result).isEqualTo(null);
 softAssertions.assertAll();
}

@Test
public void testsetaTitle() {
 // Arrange
 Account account = new Account();
 String param0 = null;
 // Act
 void result = account.setaTitle(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertAll();
}

@Test
public void testgetaCreator() {
 // Arrange
 Account account = new Account();
 // Act
 String result = account.getaCreator();
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(result).isEqualTo(null);
 softAssertions.assertAll();
}

@Test
public void testgetYearOfCreation() {
 // Arrange
 Account account = new Account();
 // Act
 int result = account.getYearOfCreation();
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(result).isEqualTo(0);
 softAssertions.assertAll();
}

@Test
public void testsetYearOfCreation() {
 // Arrange
 Account account = new Account();
 int param0 = 0;
 // Act
 void result = account.setYearOfCreation(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertAll();
}

@Test
public void testsetaCreator() {
 // Arrange
 Account account = new Account();
 String param0 = null;
 // Act
 void result = account.setaCreator(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertAll();
}

}
