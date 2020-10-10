# team7
入口位置：team7\main.war<br/>
idea加载team7\main.war\build.gradle<br/>
# 新增工程
1、settings.gradle添加include('third')<br/>
2、lib-common.gradle添加team7_third:"${gcGroup}:third:${gcVersion}",<br/>
3、main.war/build.gradle添加implementation lib.team7_third<br/>

开源excel处理工具：https://github.com/liaochong/myexcel.git<br/>