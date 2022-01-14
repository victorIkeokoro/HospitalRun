This project was done using Java/Selenium
Reporting tool : Extent report and Surefire Report
Logging tool: Log4j

--------------------------------------------------------------------
Process of executing om command line


------------------------------------------------------
1)Install Maven on your device
Download from https://maven.apache.org/download.cgi
Extract the zip/tar to desired location 
Ensure JAVA_HOME variable is correctly configured to a JDK
For Windows-
Go to MyComputer -> properties -> Advanced System Settings -> Environment variables -> click new button
Add 'MAVEN_HOME' to the directory where Maven is extracted. Eg- "C:\apache-maven-3.8.1"
Edit the path variable and add MAVEN_HOME\bin to it. Use this as it is- "%MAVEN_HOME%\bin" (without quotes)
Save the changes
Check the installation by running the command "mvn -version" in CMD.
----------------------------------------------------------------------
2) Navigate to project directoryon command prompt
3) The project comes with it's dependency in it's pom.xml file
4) Go to the src/main/java-> main.Run->Base.java file edit the "String browsername = prop.getProperty("browser"); Line 35" 
 change the "prop" to "System" -->>"String browsername= System.getProperty("browser");" 
5)To run the code on chrome simple input "mvn test -Dbrowser=chrome" on the cmd
6)To run the code on chrome simple input "mvn test -Dbrowser=firefox" on the cmd


---------------------------------------------------------------------
Reports
At the end of test execution, Refresh "MavenProject" project folder and expand target folder.
-Go to reports -> Open index.html file  It will open testng execution Extent report
-Go to surefire-reports -> Open index.html file. It will open testng execution Surefire report
-Log files can be found on the project directory format "application."****".log"


 
