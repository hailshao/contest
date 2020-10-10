# lab
入口位置：lab\main.war<br/>
idea加载lab\main.war\build.gradle<br/>
# 新增工程
1、settings.gradle添加include('third')<br/>
2、lib-common.gradle添加lab_third:"${gcGroup}:third:${gcVersion}",<br/>
3、main.war/build.gradle添加implementation lib.lab_third<br/>

开源excel处理工具：https://github.com/liaochong/myexcel.git<br/>