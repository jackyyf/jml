# JML, a Java-based miniJava lexer

Author: 余一夫 (13307130355)

## Build Tools

- ANTLR 4.6  
- Oracle(R) Java(TM) SE Development Kit 1.8 Update 111
- IntelliJ IDEA 2016.3.2

## Build instructions

请使用IntelliJ IDEA打开本项目，然后在`Build -> Build Artifacts`中选择jml:jar，然后选择Build或者Rebuild，在`out/artifacts/jml_jar`中能找到生成的jml.jar文件。

## Run

使用构建好的jml.jar，然后使用`java -jar jml.jar`即可运行。程序默认从标准输入读入MiniJava程序，并将AST输出至标准输出。如果有任何的错误，程序将会将日志输出到标准错误输出中。  
同时，程序默认会在输出AST后，弹出一个GUI窗口，以树形表示生成的AST。如果不需要此功能，可以使用`-nogui`选项禁用此功能。

## Dependency

- Java(TM) Runtime 1.8 (推荐使用Oracle(R) Java(TM) SE Runtime Environment)
- \* 图形化环境 (可以使用-nogui在非图形化环境下运行)