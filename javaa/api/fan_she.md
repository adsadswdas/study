反射：加载类，并允许以编程的方式解剖类中的各种成分（成员变量、方法、构造器等）

运行时可以创建对象，实现对象的实时编辑

步骤：

###### 1、加载类，获取类的字节码：Class对象

	public void getClassInfo() {
	    //获取类的信息。
	    //1、获取Class对象
	    Class c1 = Student.class;
	    System.out.println(c1.getName());// 全类名
	    System.out.println(c1.getSimpleName()); // 类名 Person
	}

###### 2、获取类的构造器：Constructor对象

	public void getConstructorInfo() throws Exception{
	    Class c1 = Student.class;
	    //获取所有的构造器,只可以获取public修饰的
	    c1.getConstructors();
	    //获取所有的构造器，包括私有的
	    Constructor[] cons = c1.getDeclaredConstructors();
	    for(Constructor con:cons){
	        System.out.println(con.getName() + " " + con.getParameterCount());
	    }
	
	    //获取单个构造器
	
	    // 尝试获取无参构造器
	    Constructor con1 = c1.getDeclaredConstructor();
	    Constructor con = c1.getDeclaredConstructor(String.class,int.class);
	
	    System.out.println(con.getName() + " " + con.getParameterCount());
	
	    //获取构造器的作用是城建对象；
	    //创建对象
	    //暴力反射：忽略访问权限修饰符的安全检查
	    con1.setAccessible(true);//con1是私有的
	    Student obj = (Student) con1.newInstance();
	    System.out.println(obj);
	
	    Student obj2 = (Student) con.newInstance("小黑",3);
	    System.out.println(obj2);
	}

###### 3、获取类的成员变量：Field对象
	public void getFieldInfo() throws Exception{
	    Class c1 = Student.class;
	    //获取所有的成员变量
	    c1.getFields();
	    //获取所有的成员变量，包括私有的
	    Field[] fields = c1.getDeclaredFields();
	    for(Field field:fields){
	        System.out.println(field.getName());
	    }
	}

###### 4、获取类的成员方法：Method对象

	public void getMethodInfo() throws Exception{
	    Class c1 = Student.class;
	    //获取所有的成员方法
	    c1.getMethods();
	    //获取所有的成员方法，包括私有的
	    Method[] me = c1.getDeclaredMethods();
	    for (Method method:me){
	        System.out.println(method.getName());
	    }
	}



## 作用

1、类的全部成分的获取
2、可以破坏封装性
3、可以破坏泛型的约束

	public class reflectDemo3 {
	public static void main(String[] args) throws Exception {
	    // 反射的基本作用
	    // 1、类的全部成分的获取
	    // 2、可以破坏封装性
	    // 3、可以破坏泛型的约束
	    ArrayList<String> list = new ArrayList<>();
	    list.add("hello");
	    list.add("world");
	    // list.add(100);
	
	    Class c1 = list.getClass();
	    //获取Arraylist的add方法
	    Method add = c1.getDeclaredMethod("add",Object.class);
	    //出发list的add方法
	    add.invoke(list,100);
	    add.invoke(list,200); //翻墙
	
	    System.out.println(list);
	}
	}


4、最重要的用途：适合做java的框架，基本上，主流的框架都会基于反射设计出一些通用的功能。

springbot等框架的原理就是反射。

