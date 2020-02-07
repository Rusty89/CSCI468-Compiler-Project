@echo off

cd src

set arg1=%1

SET CLASSPATH=.;C:\Javalib;%CLASSPATH%

java -jar C:\Javalib\antlr-4.8-complete.jar LITTLESCANNER.g4

javac -Xlint:deprecation *.java

java Driver %1

