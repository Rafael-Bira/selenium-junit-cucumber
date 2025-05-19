# Selenium + JUnit + Cucumber + ExtentReports

## Introduction
The current repository is just a BDD practice project using __Gherkin (Cucumber)__, __Selenium__ with __JUnit__ as testing framework and __ExtentReports__ for reporting test results. It's a Maven project made upon __Visual Studio Code__, so if you are using *IntelliJ* or *Eclipse* there may be some modifications to be done. 

The website employed is [Swag Labs](https://www.saucedemo.com/ "Sauce Demo") and the spreadsheet with the Test Cases is [here](https://docs.google.com/spreadsheets/d/1Cgl9CKoWKJd1CPceczL5j19Xm7s03_dqzhUnOiia_ZE/edit?gid=0#gid=0 "List of Test Cases").

## Folder structure
The whole project is based upon Page Object Model and the folders are organized according to their functionalities:

### hooks
The Cucumber Hooks used are `@Before`, `@AfterStep` and `@After`. Choose and set the browser driver (*Firefox*, *Edge* or *Chrome*  - by default), choose `headless` mode and prepare the Reporter. Define what happens before and after each scenario and take a screenshot when any step fails.

### pages
Following the POM pattern, this folder contains the structure of every page of the website (including the header, footer and burger menu), the locators for their DOM elements and actions.

### runners
The TestRunner class and its configuration:
- `features` -> Path where the Cucumber features are located.
- `glue` -> The folders of both the Step Definition and the Cucumber Hooks.
- `plugin` -> __"pretty"__ allows more readable logs at the console (optional).
- `name` -> The names of those specific scenarios that are going to be executed (optional).
- `tags` -> Only the specified tags are going to be executed (optional).

> NOTE: I've placed the commas at the beginning of the optional lines and not at the end because that way you can easily comment (and thus disable) them when needed.

### steps
The Step Definition classes for every page. All assertions are placed here.

### utilities
Various classes that are meant to be used in other parts of the project:
- `BasePage` -> The foundation for all the pages. Every page class extends this one.
- `BaseStep` -> It allows ExtentReports to create step logs. Every Step Definition class extends this one.
- `CommonFlows` -> The commmon flows for a normal user: navigating to the Login page, logging in, adding items to the cart, etc. There is also a CommonSteps class for these flows.
- `DriverProvider` -> Sets the WebDriver and makes it available to be used anywhere.
- `ExtentReportManager` -> Sets the Reporter and its configurations: theme, document title, report name, etc. 

### reports
Here are the report HTML file and the screenshots when tests fail.

### resources\features
The files of every Gherkin feature (one per page).

## Final words

I would like to thank [Blass Academy](https://linktr.ee/blassacademy "Blass Academy") for their awesome __Selenium + Cucumber__ free tutorial that served as the base of all this. I've truly learned a lot and without it this project could have never seen the light. It's wonderfully explained, it's divided in 4 videos and you can find the first one [here](https://www.youtube.com/watch?v=jCGCEmaGudU&t=710s "Selenium + Cucumber") (it's in spanish). 

This repo is far from finished. I'm planning to keep it updated with more Test Cases and corrections where needed. Please feel free to send me any feedbacks and suggestions, I'll be most grateful.