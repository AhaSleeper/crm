使用方法与说明：
1.修改generator.xml文件
  按照自己的数据库及jdbc驱动包的位置修改
  按照自己的worksapce修改生代码的目录
  
2.执行generator.bat脚本，执行完后工程中刷新源码目录  

3.其它
  若要手动执行命令，在cmd中执行
java -jar mybatis-generator-core-1.3.2.jar -configfile generator.xml -overwrite