# Recursion 递归-栈

1. 执行一个方法，就创建一个新的受保护的独立空间（栈空间）
2. 方法的局部变量是独立的，不会相互影响，比如 N 变量
3. 如果方法中使用的引用类型变量（比如 数组，对象），他们指向的是同一个引用类型数据
4. 递归必须想递归条件逼近
5. 当一个方法执行完毕后 或者 遇到 return 时，就会返回，谁调用，那么就返回到对应的调用区间所在位置

```java

@Slf4j
class Recursion {
    public void test(int n) {
        if (n > 1) {
            test(n - 1);
            log.info("here:" + String.valueOf(n));
        } else {
            log.info(String.valueOf(n));
        }
    }

    public void test2(int n) {
        if (n > 1) {
            test(n - 1);
            log.info("here:" + String.valueOf(n));
        }
        log.info(String.valueOf(n));
    }

    public int factorial(int n) {
        if (n==1){
            return 2;
        }else{
            return  factorial(n-1)*n;
        }
    }

    /**
     * 斐波那契额数列
     * ? 给定一个数，求它的斐波那契数列的值
     * 1,1,2,3,5,8,13,21。。。
     * 1. when n==1 , fabonacci value is 1
     * 2. when n==2 , fabonacci value is 1
     * 3. when n>=3 , fabonacci value is (prev value) + (prev+1) value
     *
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        if (n >= 1) {
            if (n == 1 || n == 2) {
                return 1;
            } else {
                return fibonacci(n - 2) + fibonacci(n - 1);
            }
        } else {
            return -1;
        }
    }

    /**
     * 猴子吃桃
     * ? 每天吃一半，再多吃一个，一共10天，最后剩下一个，求最初总数量？
     * 1. day = 10, 1
     * 2. day = 9, return (day8+1)*2
     * 3. day = 8, return (day7+1)*2
     *
     * @param day
     * @return
     */
    public int monkeyEatPeach(int day) {
        if (day == 10) {
            return 1;
        } else {
            return (monkeyEatPeach(day + 1) + 1) * 2;
        }
    }
}
```

### 递归解决问题

1. 汉诺塔问题
2. 迷宫问题
3. 球和篮子问题
4. 八皇后问题
