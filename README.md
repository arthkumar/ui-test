# Hi there 👋

## Task 1
Write a test document to list the use cases you would test via automation to verify search, filter and add-to-cart functionalities on amazon.in.
      
- Please find my submission below: 
https://docs.google.com/spreadsheets/d/1SZUg-nJ172pHabT1p96hvLuhJ0waqSemF8AEFW0T1yo/edit?usp=sharing


## Task 2: 
Automate the use case listed below using a testing framework of your choice. It’d be great if you make your framework modular, scalable and take care of reports and multi-browser scenarios.

- Before you want to go ahead with execution please make sure the following dependencies are installed in your system:
  1. JDK 11 or above.
  2. Maven 3.6 or above.


- For triggering the test execution, please execute following command in your terminal: 

```
  mvn clean test
``` 

- Please feel free to update the BrowserType parameter in the TestBase.java class. In case, you are looking for executing the test on another browser type.

```
    driver = new BrowserFactory(BrowserType.CHROME).getDriver();
```

- For analysis of test execution reports, you can navigate to the following directory:

```
airbase-ui-tests/target/surefire-reports/index.html
```

