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


public class TestGenerationTestCase {

@Test
public void testcom.ust.testGenerator.TestGeneration() { 
 // Arrange
 //Act 
 TestGenerationinstance = new TestGeneration(); 
//Assert
} 

@Test
public void testINPUT_FILE() {
 // Arrange
 Account account = new Account();
 account.setINPUT_FILE("Sree");
 // Act
 // Assert
 Assert.assertEquals("Sree", account.getINPUT_FILE());
}

@Test
public void testOUTPUT_DIRECTORY() {
 // Arrange
 Account account = new Account();
 account.setOUTPUT_DIRECTORY("Sree");
 // Act
 // Assert
 Assert.assertEquals("Sree", account.getOUTPUT_DIRECTORY());
}

@Test
public void testimportStatements() {
 // Arrange
 Account account = new Account();
 account.setImportStatements(null);
 // Act
 // Assert
 Assert.assertEquals(null, account.getImportStatements());
}

@Test
public void testgetDefaultValue() {
 // Arrange
 Account account = new Account();
 Class param0 = null;
 // Act
 String result = account.getDefaultValue(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(result).isEqualTo(null);
 softAssertions.assertAll();
}

@Test
public void testcapitalize() {
 // Arrange
 Account account = new Account();
 String param0 = null;
 // Act
 String result = account.capitalize(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(result).isEqualTo(null);
 softAssertions.assertAll();
}

@Test
public void testgenerateTestCases() {
 // Arrange
 Account account = new Account();
 Class param0 = null;
 // Act
 void result = account.generateTestCases(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertAll();
}

@Test
public void testgenerateTestCases() {
 // Arrange
 Account account = new Account();
 String param0 = null;
 // Act
 void result = account.generateTestCases(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertAll();
}

@Test
public void testgenerateImports() {
 // Arrange
 Account account = new Account();
 Class param0 = null;
 StringBuilder param1 = null;
 // Act
 void result = account.generateImports(param0, param1);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertAll();
}

@Test
public void testcollectImportedPackages() {
 // Arrange
 Account account = new Account();
 Executable[] param0 = null;
 // Act
 void result = account.collectImportedPackages(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertAll();
}

@Test
public void testcollectImportedPackages() {
 // Arrange
 Account account = new Account();
 Field[] param0 = null;
 // Act
 void result = account.collectImportedPackages(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertAll();
}

@Test
public void testgenerateFieldAssertions() {
 // Arrange
 Account account = new Account();
 Class param0 = null;
 Field[] param1 = null;
 StringBuilder param2 = null;
 // Act
 void result = account.generateFieldAssertions(param0, param1, param2);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertAll();
}

@Test
public void testgenerateReflectionsData() {
 // Arrange
 Account account = new Account();
 Class param0 = null;
 // Act
 void result = account.generateReflectionsData(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertAll();
}

@Test
public void testscanAndSaveReflectionsData() {
 // Arrange
 Account account = new Account();
 String param0 = null;
 String param1 = null;
 // Act
 void result = account.scanAndSaveReflectionsData(param0, param1);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertAll();
}

@Test
public void testcollectImportedPackage() {
 // Arrange
 Account account = new Account();
 Class param0 = null;
 // Act
 void result = account.collectImportedPackage(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertAll();
}

@Test
public void testgenerateMethodAssertions() {
 // Arrange
 Account account = new Account();
 Class param0 = null;
 Method[] param1 = null;
 StringBuilder param2 = null;
 // Act
 void result = account.generateMethodAssertions(param0, param1, param2);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertAll();
}

@Test
public void testgenerateTestCasesFromReflectionsData() {
 // Arrange
 Account account = new Account();
 String param0 = null;
 // Act
 void result = account.generateTestCasesFromReflectionsData(param0);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertAll();
}

}
