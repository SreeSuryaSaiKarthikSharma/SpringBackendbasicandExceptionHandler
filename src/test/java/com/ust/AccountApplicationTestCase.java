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


public class AccountApplicationTestCase {

@Test
public void testcom.ust.AccountApplication() { 
 // Arrange
 //Act 
 AccountApplicationinstance = new AccountApplication(); 
//Assert
} 

@Test
public void testmain() {
 // Arrange
 Account account = new Account();
 String[] param0 = null;
 // Act
 void result = account.main(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertAll();
}

}
