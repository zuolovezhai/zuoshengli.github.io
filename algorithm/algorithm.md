# 算法

## 时间复杂度

### O(1)

```java
int n = 1000;
System.out.println("hello " + n);
```

```java
int n = 1000;
System.out.println("hello " + n);
n++;
System.out.println("hello " + n);
```

### O(n)

```java
for (int i = 0; i < n; i++) {
	System.out.println("hello " + i);
}
```



### O(n^2)

```java
for (int i = 0; i < n; i++) {
	for (int j = 0; j < n; j++) {
  	System.out.println("hello " + n);
  }
}
```

### O(log(n))

```java
for (int i = 0; i < n; i=i*2) {
	System.out.println("hello " + i);
}
```

### O(k^n)

```java
int fib(n) {
	if (n < 2) {
    return n;
  }
	return fib(n-1) + fib(n-2);
}
```

## 空间复杂度

* 如果程序中定义了数组,那么空间复杂度就是数组的大小
* 如果是递归程序,空间复杂度就是递归的深度,但是如果递归中有数组,那么空间复杂度就是数组大小和递归程序的最大值

## 不同时间复杂度对比

<img src="Big-O.png" alt="avatar" style="zoom:75%;" />



