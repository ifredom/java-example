#  网络编程

- IP
- TCP编程
- UDP编程
- 发送/接受Email
- Applet基础
- HTTP编程
- Socket网络编程
- RMI远程调用



> 指令： netstat -an | more
> > 指令： netstat -anb
常见网络端口号： tomcat:8080 mysql:3306 oracal:1521 sqlserver:1433

## I/O

难点： 

1. 处理文件使用字符流
2. 处理图片，音频，视频，使用字节流

流的分类
1. 按操作数据单位的不同： 字节流(8 bit)， 字符流
2. 按数据流的流向不同分包为： 输入流，输出流
3. 按校色的不同： 节点流， 处理流/包装流

- 字节流： InputStream , OutputStream
- 字符流： Reader, Writer

- FileInputStream
- BufferedInputStream
- ObjectInputStream

包装流

- BufferedRead / BufferedWrite  节点 字符流
- BufferedInputStream / BufferedOutputStream  节点 字节流
- 
## 文件操作

一个英文字符一个字节，一个中文3个字节
