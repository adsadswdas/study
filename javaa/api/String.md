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

# StringBuilder

`StringBuilder` 是 Java 中一个用于动态构造字符串的类，它提供了多种方法来操作字符串。以下是 `StringBuilder` 的一些常用方法：

### 1. **构造方法**

- `StringBuilder()`: 构造一个不包含任何字符的 `StringBuilder`，初始容量为 16。
- `StringBuilder(int capacity)`: 构造一个不包含任何字符的 `StringBuilder`，初始容量为指定值。
- `StringBuilder(String str)`: 构造一个包含指定字符串内容的 `StringBuilder`。

### 2. **追加方法**

- `StringBuilder append(boolean b)`: 追加布尔值。
- `StringBuilder append(char c)`: 追加字符。
- `StringBuilder append(char[] str)`: 追加字符数组。
- `StringBuilder append(char[] str, int offset, int len)`: 追加字符数组的一部分。
- `StringBuilder append(double d)`: 追加双精度浮点数。
- `StringBuilder append(float f)`: 追加单精度浮点数。
- `StringBuilder append(int i)`: 追加整数。
- `StringBuilder append(long lng)`: 追加长整数。
- `StringBuilder append(Object obj)`: 追加对象。
- `StringBuilder append(String str)`: 追加字符串。
- `StringBuilder append(StringBuffer sb)`: 追加 `StringBuffer`。

### 3. **插入方法**

- `StringBuilder insert(int offset, boolean b)`: 在指定位置插入布尔值。
- `StringBuilder insert(int offset, char c)`: 在指定位置插入字符。
- `StringBuilder insert(int offset, char[] str)`: 在指定位置插入字符数组。
- `StringBuilder insert(int offset, char[] str, int index, int len)`: 在指定位置插入字符数组的一部分。
- `StringBuilder insert(int offset, double d)`: 在指定位置插入双精度浮点数。
- `StringBuilder insert(int offset, float f)`: 在指定位置插入单精度浮点数。
- `StringBuilder insert(int offset, int i)`: 在指定位置插入整数。
- `StringBuilder insert(int offset, long lng)`: 在指定位置插入长整数。
- `StringBuilder insert(int offset, Object obj)`: 在指定位置插入对象。
- `StringBuilder insert(int offset, String str)`: 在指定位置插入字符串。

### 4. **删除方法**

- `StringBuilder delete(int start, int end)`: 删除指定范围内的字符。
- `StringBuilder deleteCharAt(int index)`: 删除指定位置的字符。

### 5. **替换方法**

- `StringBuilder replace(int start, int end, String str)`: 替换指定范围内的字符为指定字符串。

### 6. **反转方法**

- `StringBuilder reverse()`: 反转字符串中的字符顺序。

### 7. **获取方法**

- `int capacity()`: 返回当前容量。
- `char charAt(int index)`: 返回指定索引处的字符。
- `int codePointAt(int index)`: 返回指定索引处的 Unicode 代码点。
- `int codePointBefore(int index)`: 返回指定索引前一个位置的 Unicode 代码点。
- `int codePointCount(int beginIndex, int endIndex)`: 返回指定范围内 Unicode 代码点的数量。
- `void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)`: 将字符从 `StringBuilder` 复制到目标字符数组。
- `int indexOf(String str)`: 返回指定字符串第一次出现的索引。
- `int indexOf(String str, int fromIndex)`: 从指定索引开始，返回指定字符串第一次出现的索引。
- `int lastIndexOf(String str)`: 返回指定字符串最后一次出现的索引。
- `int lastIndexOf(String str, int fromIndex)`: 从指定索引开始，返回指定字符串最后一次出现的索引。
- `int length()`: 返回字符串的长度。
- `String substring(int start)`: 返回从指定索引开始的子字符串。
- `String substring(int start, int end)`: 返回指定范围内的子字符串。

### 8. **设置方法**

- `void setCharAt(int index, char ch)`: 设置指定索引处的字符。
- `void setLength(int newLength)`: 设置字符串的长度。

### 9. **其他方法**

- `void ensureCapacity(int minimumCapacity)`: 确保容量至少等于指定值。
- `void trimToSize()`: 尝试减少存储空间，使其与当前字符串长度匹配。
- `String toString()`: 返回 `StringBuilder` 内容的字符串表示。