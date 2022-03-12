# 📓 Clean Code Journal
[![Vaadin-14](https://img.shields.io/badge/Vaadin-14.8.5-blue.svg?style=flat)](https://vaadin.com/)
[![Java-17](https://img.shields.io/badge/Java-12-red.svg?style=flat&logo=Java&logoColor=white)](https://www.oracle.com/technetwork/java/javase/12-relnote-issues-5211422.html)
[![Spring-Boot](https://img.shields.io/badge/Spring_Boot-2.6.4-6DB33F.svg?style=flat&logo=Springt&logoColor=white)](https://vaadin.com/)
[![BCH compliance](https://bettercodehub.com/edge/badge/TobseF/CleanCodeDeveloperJournal?branch=dev)](https://bettercodehub.com/)
[![Docker Hub](https://img.shields.io/badge/Docker_Hub-1.0.3-2496ed.svg?style=flat&logo=Docker&logoColor=white)](https://hub.docker.com/repository/docker/tobsef/clean-code-developer-demo)

### 🌍 Live demo: [Clean-Code.rocks](https://clean-code.app.tobse.eu)

> A sample project for Vaadin Flow and Spring Boot

[![Screenshot](https://raw.githubusercontent.com/TobseF/CleanCodeDeveloperJournal/gh-pages/image/screenshot.png)](http://clean-code.rocks)

Have you tried to become a [Clean Code Developer](https://clean-code-developer.de/) and master the white grade?  
This web-app helps you to keep the track and reminds you in your current grade goals.
Log your progress and get achievements for your goals 🏆.

This project was built as a sample application for a [Vaadin 14](https://vaadin.com/) progressive web app. 
It uses [Spring Boot](https://spring.io/projects/spring-boot) and runs on [JDK 17](https://jdk.java.net/17/).

It uses free open source Vaadin Components, so you don't need a Vaadin Pro subscription to run, start or debug it. 

❤ The samples contain content from https://clean-code-developer.de. 
  Big thank you to [Ralf Westphal](https://ralfw.de/) who allowed me to use it for this sample. 

## 🐳 Docker

A prebuild docker image is available at [Docker Hub](https://hub.docker.com/repository/docker/tobsef/clean-code-developer-demo).  
You can start it with the provided `docker-compose.yml`.  
Or if you want to build your own image just use the `dockerfile`. 
  
## 🚀 Start

**Requirements:**
 * Installed [JDK 17](https://jdk.java.net/17/), or higher.
 * Installed [Node JS 10](https://nodejs.org/en/download/) or later.  
   Make sure you have the node package manager `npm` on your _PATH_.

**Start:**
 1. Import the project to the IDE of your choosing as a Maven project.  
 2. To run WebApp just execute the maven task `mvn spring-boot:run` or run the `Application` class in your IDE.  
 3. Open http://localhost:8090 in a browser.

If you want to run the application locally in the production mode, run `mvn spring-boot:run -Pproduction`.

## 🔁 Auto Restart
For fast compile -> see-changes roundtrips the 
[Spring Developer Tolls](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-devtools.html)
are enabled. Every change on the classpath will trigger a server restart. So you can just compile _F9_ in the IDE and 
hit _F5_ ibn the Browser to see the changes. You can disble it, by deleting the `spring-devtools.properties` file.

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

## ⚡ Troubleshooting

#### Cannot resolve custom CSS property
Polymer templates can access CSS Properties of the Vaadin theme.
The theme is also available as web component. But this prevents the IDE to resolve a CSS property because it's stored as a JS String instead of a CSS file.  
So we have to ignore this warning:  
> Cannot resolve '--material-secondary-background-color' custom property
 