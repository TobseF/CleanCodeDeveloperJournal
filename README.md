# 📓 Clean Code Journal
[![Vaadin-14](https://img.shields.io/badge/Vaadin-14.1.3-blue.svg?style=flat)](https://vaadin.com/)
[![Java-12](https://img.shields.io/badge/Java-12-red.svg?style=flat&logo=Java&logoColor=white)](https://www.oracle.com/technetwork/java/javase/12-relnote-issues-5211422.html)
[![Spring-Boot](https://img.shields.io/badge/Spring_Boot-2.2.2-green.svg?style=flat&logo=Springt&logoColor=white)](https://vaadin.com/)

### 🌍 Live demo: [Clean-Code.rocks](http://clean-code.rocks)

> A sample project for Vaadin Flow and Spring Boot

Have you tried to become a [Clean Code Developer](https://clean-code-developer.de/) and master the white grade?  
This web-app helps you to keep the track and reminds you in your current grade goals.
Log your progress and get achievements for your goals 🏆.

This project was built as a sample application for a [Vaadin 14](https://vaadin.com/) progressive web app. 
It uses [Spring Boot](https://spring.io/projects/spring-boot) and runs on [Java 12](https://jdk.java.net/13/).

It uses free open source Vaadin Components, so you don't need a Vaadin Pro subscription to run, start or debug it. 

❤ The samples contain content from https://clean-code-developer.de. 
  Big thank you to [Ralf Westphal](https://ralfw.de/) who allowed me to use it for this sample. 
  
## 🚀 Start

**Requirements:**
 * Installed [JDK 12](https://jdk.java.net/13/), or higher.
 * Installed [Node JS 10](https://nodejs.org/en/download/) or later.  
   Make sure you have the node package manager `npm` on your _PATH_.

**Start:**
 1. Import the project to the IDE of your choosing as a Maven project.  
 2. To run WebApp just execute the maven task `mvn spring-boot:run` or run the `Application` class in your IDE.  
 3. Open http://localhost:8080 in a browser.

If you want to run the application locally in the production mode, run `mvn spring-boot:run -Pproduction`.

## 🔧 Config
For editing I18N property files, make sure you use UTF-8 encoding. In IntelliJ:  
_File > Settings > Editor > File Encodings > Properties Files > Default encoding: UTF-8_ 

## 📚 Documentation

For documentation on using Vaadin Flow and Spring, visit [vaadin.com/docs](https://vaadin.com/docs/flow/spring/tutorial-spring-basic.html).  
For more information on Vaadin Flow, visit https://vaadin.com/flow.

The demos show 5 different ways how to build a Vaadin interface component:

1. **Flow components**  
   UI built with Vaadin Flow components.  
   Example: `org.cleancode.journal.view.CompendiumView.createTable`
2. **Element API**  
   Custom component built with HTML elements.  
   Example: `org.cleancode.journal.component.progressbar.GradeProgressBar`
3. **Custom HTML**  
   Direct output of custom HTML.  
   Example: `org.cleancode.journal.view.AboutView`
4. **Polymer Templates**  
   A Polymer Template which is defined in JavaScript and has a Java adapter Component.  
   Example: `org.cleancode.journal.component.logentry.LogEntryComponent`  
   JS-Part: `frontend/src/log-entry.js`
5. **Web-Components**  
   Import of an existing external hosted Web-Component.  
   Example: `org.cleancode.journal.component.speeddial.SpeedDial`

## 📁 Structure
 * frontend
   * `src`[📎](/frontend/src)  
   Polymer templates or vaadin designer files.
   * `styles`[📎](/frontend/styles)  
   CSS-files
 * java
    * `org.cleancode.journal.component`[📎](/src/main/java/org/cleancode/journal/component)  
    Ui-components
    * `org.cleancode.journal.domain`[📎](/src/main/java/org/cleancode/journal/domain)  
    Domain entities which could be saved in a DB
    * `org.cleancode.journal.service`[📎](/src/main/java/org/cleancode/journal/service)  
    Spring services which load, save or manipulate domain entities
    * `org.cleancode.journal.util`[📎](/src/main/java/org/cleancode/journal/util)  
    Stateless helper functions  
    * `org.cleancode.journal.view`[📎](/src/main/java/org/cleancode/journal/view)  
    All views (pages) and dialogs       
* resources
   * `application.properties`[📎](/src/main/resources/application.properties)  
   Static application properties
   * `translation`[📎](/src/main/resources/translation_en.properties)  
   I18N resource bundles

## 📜 Licence
The project initial setup was generated by a free Vaadin starter [start.vaadin.com](https://vaadin.com/start/latest).

This project is licenced under [MIT](https://github.com/TobseF/CleanCodeDeveloperJournal/blob/dev/LICENSE.txt).  
  
You are free to:
 * **Share** — copy and redistribute the material in any medium or format
 * **Adapt** — remix, transform, and build upon the material

This licence does **NOT** apply to the Clean Code Dev content stored in the `grade_x.json` files.
 
No commercial Vaadin components are used in this project. So you don't need a Vaadin Pro subscription to run, start or debug it.