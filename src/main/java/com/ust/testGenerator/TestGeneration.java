package com.ust.testGenerator;

import java.io.File;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;


public class TestGeneration {
	
	static String INPUT_FILE = "C:\\Users\\237979\\Desktop\\Spring\\Account\\AccountUnitTesting.txt";
	static String OUTPUT_DIRECTORY = "C:\\Users\\237979\\Desktop\\Spring\\Account\\src\\test\\java\\com\\ust";
	
	public void generateTestCases(String basePackage) {
		
		String reflectionsOutputFile = INPUT_FILE;
		scanAndSaveReflectionsData(basePackage, reflectionsOutputFile);
		generateTestCasesFromReflectionsData(reflectionsOutputFile);
		
	}
	
	private void scanAndSaveReflectionsData(String basePackage, String outputFile) {
		try {
			Reflections reflections = new Reflections(basePackage, new SubTypesScanner(false));
			Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);
			FileOutputStream fos = new FileOutputStream(outputFile);
			PrintStream ps = new PrintStream(fos);
			System.setOut(ps);
			for(Class<?> targetClass : classes) {
				generateReflectionsData(targetClass);
			}
			
			ps.close();
			fos.close();
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void generateReflectionsData(Class<?> targetClass) {
		
		System.out.println("Class: "+targetClass.getName());
		
		if (targetClass.isArray()) {
			Class<?> componentType = targetClass.getComponentType();
			System.out.println("Array Component Type: "+ componentType.getName());
		}
		/*
		The above code check if target class is an array using isArray() method.
		If it is an array, Retrieves the component Type of an array using getComponentType() 
		method and prints the name of the component type.
		*/
		
		Constructor<?> [] constructors = targetClass.getDeclaredConstructors();
		System.out.println("Constructors: ");
		for(Constructor<?> constructor: constructors) {
			System.out.println(constructor);
		}
		/*
		 * above code retrieve all the declared constructors of the target class using 
		 * getDeclaredConstructors() method. Then iterates through each constructor in the array
		 * and prints the information about each constructor.
		 */
		
		Field[] fields = targetClass.getDeclaredFields();
		System.out.println("Fields: ");
		for(Field field: fields) {
			System.out.println(field);
		}
		/*
		 * above code retrieve all the declared fields of the target class using 
		 * getDeclaredFields() method. Then iterates through each field in the array
		 * and prints the information about each field.
		 */
		
		Method[] methods = targetClass.getDeclaredMethods();
		System.out.println("Methods: ");
		for(Method method: methods) {
			System.out.println(method);
		}
		/*
		 * above code retrieve all the declared methods of the target class using 
		 * getDeclaredMethods() method. Then iterates through each method in the array
		 * and prints the information about each method.
		 */
		System.out.println("________________________________________________________");
	}
	
	private void generateTestCasesFromReflectionsData(String reflectionsOutputFile) {
		
		try {
			File file = new File(reflectionsOutputFile);
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if(line.startsWith("Class: ")) {
					String className = line.substring(7);
					Class<?> targetClass = Class.forName(className);
					generateTestCases(targetClass);
				}
			}
			/*
			 * Above code reads each line of the file using the scanner and checks if the line
			 * starts with the String "Class'. If it does, it extracts the class name from the 
			 * line (after removing "Class") and uses Class.forName() to obtain a 'Class' 
			 * object representing the class. Then, it calls the generateTestCases method with 
			 * th target class to generate the test cases for that class.
			 */
			scanner.close();
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * The above method reads the content of the file specified by reflectionOutputFile
	 * , looks for lines starting with the class, extracts the class name from those lines,
	 * generates the test cases for each identified classes using the generateTestCases method.
	 */
	
	private void generateTestCases(Class<?> targetClass) {
		
	
		StringBuilder testCaseBuilder = new StringBuilder();
		
		testCaseBuilder.append("package com.ust;\n");
		generateImports(targetClass, testCaseBuilder);
		collectImportedPackages(targetClass.getDeclaredConstructors());
	    collectImportedPackages(targetClass.getDeclaredFields());
	    collectImportedPackages(targetClass.getDeclaredMethods());
		testCaseBuilder.append("public class ").append(targetClass.getSimpleName()).append("TestCase {\n\n");
		
		/*
		 * above line adds the class declaration for the test case class. It uses simple name of the 
		 * target class (without package) and appends testcase to form the name of the test case class.
		 */
		
		Constructor<?>[] constructors = targetClass.getDeclaredConstructors();
		Field[] fields = targetClass.getDeclaredFields();
		Method[] methods = targetClass.getDeclaredMethods();
		
		for(Constructor<?> constructor : constructors) {
			String constructorName = constructor.getName();
			Class<?>[] parameterTypes = constructor.getParameterTypes();
			testCaseBuilder.append("@Test\n");
			testCaseBuilder.append("public void test").append(constructorName).append("() { \n");
			testCaseBuilder.append(" // Arrange\n");
			
			for(int i =0; i < parameterTypes.length; i++) {
				Class<?> parameterType = parameterTypes[i];
				String defaultValue = getDefaultValue(parameterType);
				testCaseBuilder.append(" ").append(parameterType.getSimpleName()).append(" param")
				.append(i).append(" = ").append(defaultValue).append("; \n");
				/*
				 * above lines loop through the parameter types of the constructor and create local 
				 * variables in the test method, each name with a name like param0, param1...
				 * to represent the constructor's parameters. It uses getDefaultValue method to get a 
				 * default value for each parameter type.
				 */
			}
			testCaseBuilder.append(" //Act \n");
			testCaseBuilder.append(" ").append(targetClass.getSimpleName()).append("instance = new ")
			.append(targetClass.getSimpleName()).append("(");
			for(int i =0; i< parameterTypes.length; i++) {
				testCaseBuilder.append("param").append(i);
				if(i<parameterTypes.length-1) {
					testCaseBuilder.append(", ");
				}
			}
			testCaseBuilder.append("); \n");
			testCaseBuilder.append("//Assert\n");
			testCaseBuilder.append("} \n\n");
		}
		/*
		 * above lines add the act part of the test case. It creates an instance of the target class by
		 * calling the constructor with the previously prepared parameters. It uses local variables 
		 * created in the previous loop to pass the arguments to the constructor.This instance will
		 * later used for the assertions.
		 */
		
		generateFieldAssertions(targetClass, fields, testCaseBuilder);
		generateMethodAssertions(targetClass, methods, testCaseBuilder);
		testCaseBuilder.append("}\n");
		
		String outputFilePath = OUTPUT_DIRECTORY + File.separator + targetClass.getSimpleName() +
				"TestCase.java";
		
		try (PrintWriter writer = new PrintWriter(outputFilePath)) {
			writer.write(testCaseBuilder.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void generateFieldAssertions(Class<?> targetClass,Field[] fields, StringBuilder testCaseBuilder) {
		
		for (Field field : fields) {
			String fieldName = field.getName();
			Class<?> fieldType = field.getType();
			testCaseBuilder.append("@Test\n");
			testCaseBuilder.append("public void test").append(fieldName).append("() {\n");
			testCaseBuilder.append(" // Arrange\n");
			testCaseBuilder.append(" Account account = new Account();\n");
			/*
			 * above line generates test cases for each field in the targetclass. 
			 * lo0ps through the fields and process eacch and every field. and then appends each 
			 * and every case mentioned above.
			 */
			String fieldValue;
			if (fieldType.equals(String.class)) {
				fieldValue = "\"Sree\"";
			} else if (fieldType.equals(int.class) || fieldType.equals(Integer.class)) {
				fieldValue = "2023";
			} else if (fieldType.equals(Long.class)) {
				fieldValue = "1237L";
			} else {

				fieldValue = "null";
			}
			testCaseBuilder.append(" account.set").append(capitalize(fieldName)).append("(").append(fieldValue)
					.append(");\n");
			testCaseBuilder.append(" // Act\n");

			testCaseBuilder.append(" // Assert\n");
			testCaseBuilder.append(" Assert.assertEquals(").append(fieldValue).append(", account.get")
					.append(capitalize(fieldName)).append("());\n");
			testCaseBuilder.append("}\n\n");
		}
	}
	
	private void generateMethodAssertions(Class<?> targetClass, Method[] methods, StringBuilder testCaseBuilder) {
		
		for (Method method : methods) {
			String methodName = method.getName();
			Class<?>[] parameterTypes = method.getParameterTypes();
			Class<?> returnType = method.getReturnType();
			testCaseBuilder.append("@Test\n");
			testCaseBuilder.append("public void test").append(methodName).append("() {\n");
			testCaseBuilder.append(" // Arrange\n");
			testCaseBuilder.append(" Account account = new Account();\n");

			StringBuilder parametersBuilder = new StringBuilder();
			for (int i = 0; i < parameterTypes.length; i++) {
				Class<?> parameterType = parameterTypes[i];
				String defaultValue = getDefaultValue(parameterType);
				String parameterName = "param" + i;
				testCaseBuilder.append(" ").append(parameterType.getSimpleName()).append(" ").append(parameterName)
						.append(" = ").append(defaultValue).append(";\n");
				parametersBuilder.append(parameterName);
				if (i < parameterTypes.length - 1) {
					parametersBuilder.append(", ");
				}
			}
			testCaseBuilder.append(" // Act\n");
			testCaseBuilder.append(" ").append(returnType.getSimpleName()).append(" result = account.")
					.append(methodName).append("(").append(parametersBuilder.toString()).append(");\n");
			testCaseBuilder.append(" // Assert\n");
			testCaseBuilder.append(" SoftAssertions softAssertions = new SoftAssertions();\n");
			
			
			if (!returnType.equals(void.class)) {
				String returnValue = getDefaultValue(returnType);
				testCaseBuilder.append(" softAssertions.assertThat(result).isEqualTo(").append(returnValue)
						.append(");\n");
			}
			/*
			 * above code check if return type is not void , if it does return a value. it obtains
			 * a default value for that return type , then it uses softAssertions.assertThat
			 * to add an assertion that checks if the result is equal to return value.
			 */

			testCaseBuilder.append(" softAssertions.assertAll();\n");
			testCaseBuilder.append("}\n\n");
		}
	}
	
	
    private void generateImports(Class<?> targetClass, StringBuilder testCaseBuilder) {
        try {
            // Read the import statements from the file
            List<String> importStatements = Files.readAllLines(Paths.get("C:\\Automation_Testing-main\\ImportStatements.txt"));

            // Append the import statements to the testCaseBuilder
            for (String importStatement : importStatements) {
                testCaseBuilder.append(importStatement).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    private Set<String> importStatements = new HashSet<>();

    private void collectImportedPackages(Executable[] executables) {
    	
        for (Executable executable : executables) {
            Class<?>[] parameterTypes = executable.getParameterTypes();
            
            for (Class<?> parameterType : parameterTypes) {
                collectImportedPackage(parameterType);
            }
            
            if (executable instanceof Method) {
                Method method = (Method) executable;
                collectImportedPackage(method.getReturnType());
            }
        }
    }

    private void collectImportedPackages(Field[] fields) {
    	
        for (Field field : fields) {
            collectImportedPackage(field.getType());
        }
    }

    private void collectImportedPackage(Class<?> cls) {
    	
        Package classPackage = cls.getPackage();
        
        if (classPackage != null && !cls.isPrimitive() && !cls.getName().startsWith("java.lang")) {
        	
            String packageName = classPackage.getName();
            String importStatement = "import " + packageName + ".*;";
            importStatements.add(importStatement);
            
        }
    }

	
	String getDefaultValue(Class<?> type) {
		if (type == boolean.class || type == Boolean.class) {
			return "false";
		} else if (type == int.class || type == Integer.class) {
			return "0";
		} else if (type == long.class || type == Long.class) {
			return "0L";
		} else if (type == double.class || type == Double.class) {
			return "0.0";
		} else if (type == float.class || type == Float.class) {
			return "0.0f";
		} else if (type == char.class || type == Character.class) {
			return "'\\u0000'";
		} else if (type == byte.class || type == Byte.class) {
			return "(byte) 0";
		} else if (type == short.class || type == Short.class) {
			return "(short) 0";
		} else {
			return "null";
		}
	}
	
	String capitalize(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		return Character.toUpperCase(str.charAt(0)) + str.substring(1);
	}
}
