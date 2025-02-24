- set是一个集合，里面放的元素只能是一个key，而两数之和这道题目，不仅要判断y是否存在而且还要记录y的下标位置，因为要返回x 和 y的下标。所以set 也不能用。

此时就要选择另一种数据结构：map ，map是一种key value的存储结构，可以用key保存数值，用value再保存数值所在的下标。

map.put(sum,0) 存放

map.getOrDefault(ch,0) 判断是否存在ch，存在的话返回ch对应的value，不存在返回0；

map.containsKey(ch) 判断是否Key中是否存在ch

map.containsValue(ch) 判断是否value中是否存在ch

map.remove(ch) 移除ch及其对应的key

map.isEmpty() 判断map是否为空









​        



​          `	