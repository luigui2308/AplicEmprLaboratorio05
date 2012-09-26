PATH=D:\Program Files\Java\jdk1.7.0_05\bin

javac -classpath lib/servlet-api-2.5.jar;lib/commons-logging-1.1.1.jar;www/WEB-INF/lib/spring-webmvc-3.2.0.M1.jar -d www/WEB-INF/classes src/service/*.java src/domain/*.java src/web/*.java

pause