@echo off
echo [INFO] is config generator.xml?

java -jar %~dp0/generator/mybatis-generator-core-1.3.2.jar -configfile %~dp0/generator/generator.xml -overwrite

pause