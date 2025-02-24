反射：加载类，并允许以编程的方式解剖类中的各种成分（成员变量、方法、构造器等）

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

	public void getConstructorInfo(){
	    Class c1 = Student.class;
	    //获取所有的构造器,只可以获取public修饰的
	    c1.getConstructors();
	    //获取所有的构造器，包括私有的
	    Constructor[] cons = c1.getDeclaredConstructors();
	    for(Constructor con:cons){
	        System.out.println(con.getName() + " " + con.getParameterCount());
	    }
	
	    //获取单个构造器
	    try {
	        // 尝试获取无参构造器
	        Constructor con = c1.getDeclaredConstructor(String.class,int.class);
	        System.out.println(con.getName() + " " + con.getParameterCount());
	    } catch (NoSuchMethodException e) {
	        System.err.println("无参构造器不存在: " + e.getMessage());
	    }
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

