
# word_test

### 本项目旨在模仿现有网站以实现在线词汇量测试功能。
参考原地址为：[扇贝测单词](https://web.shanbay.com/bdc/vocabtest#/)

主要结构图
```
joker
    ├─ WordTestApplication.java
    ├─ config
    │    ├─ AsyncConfig.java
    │    └─ CrosConfig.java
    ├─ controller
    │    └─ WordController.java
    ├─ mapper
    │    └─ WordMapper.java
    ├─ pojo
    │    ├─ ReturnWord.java
    │    └─ Word.java
    ├─ service
    │    ├─ WordService.java
    │    └─ testQueue.java
    └─ serviceImpl  
```

说明：
* AsyncConfig.java：异步调用配置类
* CrosConfig.java：跨域请求配置类
* WordController.java：处理页面请求
* WordMapper.java：数据库查询
* ReturnWord.java：返回单词实体类
* Word.java：数据库单词实体类
* WordService.java：逻辑处理类（实现逻辑直接写入接口类，尚未进行分离）
* testQueue.java：消息队列备用类（未完成）

数据导入：
