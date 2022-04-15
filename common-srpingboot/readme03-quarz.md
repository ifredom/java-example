# 集成 Quartz 定时任务

Quartz 将定时器分为：
1. Job 工作内容
2. JobDetail 工作详情
3. Trigger 触发器
4. 控制器

书写流程

1. 导入坐标，坐标默认被spring支持
2. 写job, 写jobDetail, 写Trigger，都写在JobConfig中
3. 定时器随着项目启动就会运行