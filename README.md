# Example Selenium automated test framework

## Introduction
A basic example of a selenium test framework using Junit5 and Gradle

## Run the tests
Command line:  
*gradlew test*   
OR  
*gradlew test -Penv=test*
where Penv is the file name of environment property file, e.g. prod, uat, test

Intellij gradle runner
*-Penv="test"* in the Arguments configuration field