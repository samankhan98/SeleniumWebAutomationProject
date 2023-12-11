Selenium Java Automation Project with Reporting 

**Overview**
This README provides essential information for using and contributing to the Selenium Java automation project.

**Prerequisites**
Java Development Kit (JDK) 8 or later
Maven
Allure Zip File (for ALlure Reporting)

**Installation**
- Clone the repository: git clone **https://github.com/samankhan98/SeleniumWebAutomationProject.git**
- Navigate to the project: cd SeleniumWebAutomationProject
- Build with Maven: mvn clean install

**Usage**

**Configuration**
Update config.properties for settings like the browser type and application URL.

**Running Tests**
Open terminal and Execute tests with: mvn test ( if maven is added to System Path) or  Run **testng.xml** file 

**Reports**
Extent reports are generated in the ExtentTestReport directory with name **Test-Automaton-Report_timeStamp.html**.
Allure reports are generated in the  directory with name **allure-results_1timestamp**.

**Open Reports**

**Extent Report:** 
 - Copy Absolute path
 - Go to chrome or any Web
 - paste url and Enter
   
**Allure Report**
- if Allure is not added to system PATH
  * Go to directory
  * There is a folder name with **allure-2.8.1** and bin in a folder
  * copy path to bin eg: D:\WebAutomationTest\TestAutomation\allure-2.8.1\bin
  * Add allure to system PATH
- Open Terminal or cmd prompt
- write cmd:  allure server **pathOfAllureReport**  eg: allure serve D:\WebAutomationTest\TestAutomation\allure-results_12-12-2023-[02-14-29]

**Contributing**
Feel free to report issues, submit pull requests, or provide feedback.
