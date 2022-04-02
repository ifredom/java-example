# doc1

- 代码块先于构造函数执行
- 静态代码块 与属性 根据书写顺序执行，只执行一次
- 静态代码执行完成后，执行普通代码（块）

```bash
private void test(){
    Integer int1 = new Integer(1000);
    Integer int2 = new Integer(1000);
    
    System.out.print(int1 ==int2); // false  比较对象地址是否相同
    System.out.print( int1.equals(int2)); // true   对象对象的值时否相同
}
```
