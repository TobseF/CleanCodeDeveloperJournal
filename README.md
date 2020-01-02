# 📓 Clean Code Developer Journal 
[![Vaadin-14](https://img.shields.io/badge/Vaadin-14.1.3-blue.svg?style=flat&logo=Vagrant&logoColor=white)](https://vaadin.com/)
[![Java-12](https://img.shields.io/badge/Java-12-red.svg?style=flat&logo=Java&logoColor=white)](https://www.oracle.com/technetwork/java/javase/12-relnote-issues-5211422.html)
[![Spring-Boot](https://img.shields.io/badge/Spring-Boot-green.svg?style=flat&logo=Springt&logoColor=white)](https://vaadin.com/)

> A sample project for Vaadin Flow and Spring Boot

### 🌍 Live demo: [Clean-Code.rocks](http://clean-code.rocks)

Have you tried to become a [Clean Code Developer](https://clean-code-developer.de/) and master the white grade?  
This webapp helps you to keep the track and reminds you in your current grade goals.
Log your progress and get achievements for your goals 🏆.

This project was built as a sample application for a [Vaadin 14](https://vaadin.com/) progressive web app. 
It uses [Spring Boot](https://spring.io/projects/spring-boot) and runs on [Java 12](https://www.oracle.com/technetwork/java/javase/12-relnote-issues-5211422.html).

It uses free open source Vaadin Components, so you don't need a Vaadin Pro subscription to run, start or debug it. 

❤ The samples contain content from https://clean-code-developer.de. 
  Big thank you to [Ralf Westphal](https://ralfw.de/) who allowed me to use it for this sample. 
  
## 🚀 Start
 1. Import the project to the IDE of your choosing as a Maven project.  
 2. To run WebApp just execute the maven task `mvn spring-boot:run` or run the `Application` class in your IDE.  
 3. Open http://localhost:8080/ in a browser.

If you want to run the application locally in the production mode, run `mvn spring-boot:run -Pproduction`.

## 🔧 Config
For editing I18N property files, make sure you use UTF-8 encoding. In IntelliJ:  
_File > Settings > Editor > File Encodings > Properties Files > Default encoding: UTF-8_ 

## 📚 Documentation

For documentation on using Vaadin Flow and Spring, visit [vaadin.com/docs](https://vaadin.com/docs/flow/spring/tutorial-spring-basic.html).

For more information on Vaadin Flow, visit https://vaadin.com/flow.

## 📜 Licence
The project initial setup was generated by a free Vaadin starter [start.vaadin.com](https://vaadin.com/start/latest).

This project is licenced under [MIT](https://github.com/TobseF/CleanCodeDeveloperJournal/blob/dev/LICENSE.txt).  
  
You are free to:
 * **Share** — copy and redistribute the material in any medium or format
 * **Adapt** — remix, transform, and build upon the material

This licence does **NOT** apply to the Clean Code Dev content stored in the `grade_x.json` files.
 
No commercial Vaadin components are used in this project. So you don't need a Vaadin Pro subscription to run, start or debug it.
