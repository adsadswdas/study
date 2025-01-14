String代码字符串，他的对象可以封装字符串数据，并提供了很多方法完成对字符串的处理。



	public class test {
	public static void main(String[] args) {
	    //掌握创建字符串对象
	    String str1 = "abc";
	    System.out.println("str1:" + str1); //1: 存储到字符串常量池中，且相同的字符串只会存储一份
	    System.out.println("str1的长度:" + str1.length());
	    
	    String str2 = new String(); //2:不推荐 每new一个对象就会在堆中开辟一块内存空间
	    System.out.println("str2:" + str2);
	    
	    String str3 = new String("abc"); //3:不推荐
	    System.out.println("str3:" + str3);
	    
	    char[] charArray = new char[]{'A', 'B', 'C'};//4:
	    String str4 = new String(charArray); 
	    System.out.println("str4:" + str4);
	    
	    byte[] byteArray = new byte[]{97, 98, 99};//5:
	    String str5 = new String(byteArray); 
	    System.out.println("str5:" + str5);
	    
	    System.out.println("=====================================");
	    
	    String str6 = "abc";//只有""创建的字符串对象会存储到字符串常量池中，相同的字符串只会存储一份
	    String str7 = "abc";
	    System.out.println(str6 == str7); //true
	    
	    String str8 = new String("abc");
	    String str9 = new String("abc");
	    System.out.println(str8 == str9); //false
	}
	}