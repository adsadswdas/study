# 接口

实现类实现多个接口

必须重写所有接口的全部抽象方法，否则这个类必须定义为抽象类



接口可以实现面向接口编程，更利于解耦合



## 接口中的三种方法
	// 1、默认方法（普通实例方法） 必须使用default修饰
	// 默认用public修饰
	// 如何调用：实现类对象.方法名()
	public interface A {
		 default void go(){
		     System.out.println("A go");
		  }
		  
	public class test {
		public static void main(String[] args) {
	    	AImpl a = new AImpl();
	    	a.go();
		}
	}
	
	class AImpl implements A{
	
	}	 
	// 2、私有方法
	// 私有方法只能在接口内部使用
	// 使用接口中的其他方法调用私有方法
	public interface A {
	 
		default void go(){
	    	System.out.println("A go");
	    	go1(); // 这里调用
		}
	
		private void go1(){
	    	System.out.println("A go1");
		}
	}
	// 3、静态方法
	// 默认用public修饰
	// 如何调用：用当前接口名调用
	public interface A {
	 
		default void go(){
	    	System.out.println("A go");
	    	go1();
		}
	
		private void go1(){
	    	System.out.println("A go1");
		}
		
		static void go2(){
	    	System.out.println("A go2");
	}
	}
	
	使用A.go2调用

​	增强了接口的能力，更便于项目的扩展和维护



## 接口的注意事项

1、接口与接口可以多继承，一个接口可以同时继承多个接口（重点)

​	类与类：单继承，

​	类与接口：多实现，一个类可以实现多个接口

​	接口与接口：多继承



	interface A{
		void show1();
	}
	interface B{
		void show2();	
		}
	interface C extends A,B{
		void show3();
	}
	class D implements C{
		@Override
		public void show1() {
	    	System.out.println("show1");
		}
	
		@Override
		public void show2() {
	    	System.out.println("show2");
		}
	
		@Override
		public void show3() {
	    	System.out.println("show3");
		}



2、一个接口继承多个接口，如果多个接口中存在方法签名冲突，则此时还不支持多继承，也不支持多实现



3、一个类继承了父类又同时实现了接口，如果父类中和接口中有同名的方法，实现类会优先使用父类的

	interface A2{
		default void show(){
	    	System.out.println("a2 show")
		}
	}
	class Animal{
		public void show(){
	    	System.out.println("animal show");
		}
	}
	class dog extends Animal implements A2{
		public void go(){
	    	show(); //父类的
	    	super.show(); // 父类的
	    	A2.super.show(); // A2接口
		}
	}

## 接口和抽象类的对比

相同点：

​	1、多是抽象形式，都可以由抽象方法，都不能创建对象

​	2、都是派生子类形式：“抽象类是被子类继承使用，接口时被实现类实现

​	3、一个类继承抽象类，或者实现接口，都必须重写完他们的抽象方法，否则自己要成为抽象类或者报错！

​	4、都能支持的多态，都能实现解耦合



不同点：

​	1、抽象类中可以定义类的全部普通成员，接口只能定义常量，抽象方法

​	2、抽象类只能被类单继承，接口可以被类多实现。

​	3、一个类继承抽象类就不能在继承其他类，一个类实现了接口还可以继承其他类或者实现其他接口

​	4、抽象类体现模板思想：更利于做父类，实现代码的复用性

​	5、接口更适合做功能的解耦合，解耦合性更强更灵活
