### HTTP/1.1 的优点有哪些？

![image-20250320104516192](../../../../image/image-20250320104516192.png)

### HTTP/1.1 的缺点有哪些？

#### *1. 无状态双刃剑*

![image-20250320104630257](../../../../image/image-20250320104630257.png)

![Cookie 技术](https://cdn.xiaolincoding.com/gh/xiaolincoder/ImageHost/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%BD%91%E7%BB%9C/HTTP/14-cookie%E6%8A%80%E6%9C%AF.png)

#### *2. 明文传输双刃剑*

![image-20250320104729319](../../../../image/image-20250320104729319.png)

#### *3. 不安全*

![image-20250320104803410](../../../../image/image-20250320104803410.png)



HTTP 的安全问题，可以用 HTTPS 的方式解决，也就是通过引入 SSL/TLS 层，使得在安全上达到了极致



### HTTP/1.1 的性能如何？

HTTP 协议是基于 TCP/IP，并且使用了「请求-应答」的通信模式，所以性能的关键就在这两点里。

#### *1. 长连接*

![image-20250320105906199](../../../../image/image-20250320105906199.png)

![短连接与长连接](https://cdn.xiaolincoding.com/gh/xiaolincoder/ImageHost/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%BD%91%E7%BB%9C/HTTP/16-%E7%9F%AD%E8%BF%9E%E6%8E%A5%E4%B8%8E%E9%95%BF%E8%BF%9E%E6%8E%A5.png)

#### *2. 管道网络传输*

![image-20250320110004927](../../../../image/image-20250320110004927.png)

![管道网络传输](https://cdn.xiaolincoding.com/gh/xiaolincoder/ImageHost/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%BD%91%E7%BB%9C/HTTP/17-%E7%AE%A1%E9%81%93%E7%BD%91%E7%BB%9C%E4%BC%A0%E8%BE%93.png)

![image-20250320110042271](../../../../image/image-20250320110042271.png)

#### *3. 队头阻塞*

![队头阻塞](https://cdn.xiaolincoding.com/gh/xiaolincoder/ImageHost/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%BD%91%E7%BB%9C/HTTP/18-%E9%98%9F%E5%A4%B4%E9%98%BB%E5%A1%9E.png)