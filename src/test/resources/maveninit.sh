#!/bin/bash
cd /Volumes/Corner0/JavaProjects/TempFolder
pwd
chmod -R 777 `pwd`
mvn archetype:generate -DgroupId=com.ajilisiwei.mvntest -DartifactId=MvnTest -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
cd MvnTest
mvn package
mvn test
mvn test-compile