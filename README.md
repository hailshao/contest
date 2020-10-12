# contest
入口位置：contest\main.war<br/>
idea加载contest\main.war\build.gradle<br/>
# 新增工程
1、settings.gradle添加include('third')<br/>
2、lib-common.gradle添加contest_third:"${gcGroup}:third:${gcVersion}",<br/>
3、main.war/build.gradle添加implementation lib.contest_third<br/>

开源excel处理工具：https://github.com/liaochong/myexcel.git<br/>

后端构建war包方式：
gradle build 会在contest\main.war\build\libs目录生成main.war-1.0.1-SNAPSHOT.war文件