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
	 System.out.println("=====================================");
	
	        //调用字符串数据的方法
	        String okLoginName = "admin";
	        System.out.println("请输入用户名:");
	        Scanner sc = new Scanner(System.in);
	        String inputLoginName = sc.next();
	
	        if (okLoginName.equals(inputLoginName)) {
	            System.out.println("登录成功");
	        } else {
	            System.out.println("登录失败");
	        }
	
	        System.out.println("=====================================");
	
	        System.out.println("使用手机号登录:");
	        String phone = sc.next();
	        System.out.println("系统显示一下手机号码:" + phone.replace(phone.substring(3, 7), "****"));
	}
	}





### String生成验证码



	public class test1 {
		public static void main(String[] args) {
	    //生成验证码的程序，每位可能是数字、大小写字母、使用string做
	
	    	String code = generateCode(6);
	    	System.out.println("验证码:" + code);
	
		}
	public static String generateCode(int length){
	
	    //1、定义一个字符串，保存所有的字符
	    //2、随机生成一个下标，通过下标获取字符，拼接到一起
	    //3、重复2的步骤，生成指定长度的字符串
	    //4、返回生成的字符串
	
	    String str = 	"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String code = "";
	    for (int i = 0; i < length; i++) {
	        int index = (int) (Math.random() * str.length()); // Math.random() 生成一个[0,1)之间的随机数
	        code += str.charAt(index); //charAt() 获取指定下标的字符
	    }
	    return code;
	}
	}





String random //需要转换为char数组

for(char ch: random.toCharArray){

}