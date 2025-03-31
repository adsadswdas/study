###  HTTP 与 HTTPS 有哪些区别？

![image-20250320110413399](../../../../image/image-20250320110413399.png)

### HTTPS 解决了 HTTP 的哪些问题？

![image-20250320131045778](../../../../image/image-20250320131045778.png)

![HTTP 与 HTTPS 网络层](https://cdn.xiaolincoding.com/gh/xiaolincoder/ImageHost/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%BD%91%E7%BB%9C/HTTP/19-HTTPS%E4%B8%8EHTTP.png)



#### HTTPS 是如何解决上面的三个风险的？

![image-20250320131148873](../../../../image/image-20250320131148873.png)



#### *1. 混合加密*

![混合加密](https://cdn.xiaolincoding.com/gh/xiaolincoder/ImageHost/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%BD%91%E7%BB%9C/HTTP/20-%E6%B7%B7%E5%90%88%E5%8A%A0%E5%AF%86.png)

![image-20250320131253550](../../../../image/image-20250320131253550.png)

#### *2. 摘要算法 + 数字签名*

![image-20250320131404841](../../../../image/image-20250320131404841.png)

![img](https://cdn.xiaolincoding.com/gh/xiaolincoder/ImageHost/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%BD%91%E7%BB%9C/HTTP/%E6%91%98%E8%A6%81%E7%AE%97%E6%B3%95.png)

![image-20250320131535001](../../../../image/image-20250320131535001.png)

![img](https://cdn.xiaolincoding.com/gh/xiaolincoder/ImageHost/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%BD%91%E7%BB%9C/HTTP/%E6%95%B0%E5%AD%97%E7%AD%BE%E5%90%8D.png)

#### *3. 数字证书*

![数子证书工作流程](https://cdn.xiaolincoding.com/gh/xiaolincoder/ImageHost/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%BD%91%E7%BB%9C/HTTP/22-%E6%95%B0%E5%AD%97%E8%AF%81%E4%B9%A6%E5%B7%A5%E4%BD%9C%E6%B5%81%E7%A8%8B.png)





###  HTTPS 是如何建立连接的？其间交互了什么？

SSL/TLS 协议基本流程
	客户端向服务器索要并验证服务器的公钥。

​	双方协商生产「会话秘钥」

​	双方采用「会话秘钥」进行加密通信。

![HTTPS 连接建立过程](https://cdn.xiaolincoding.com/gh/xiaolincoder/ImageHost/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%BD%91%E7%BB%9C/HTTP/23-HTTPS%E5%B7%A5%E4%BD%9C%E6%B5%81%E7%A8%8B.png)

#### TLS 协议建立的详细流程：

##### *1. ClientHello*

![image-20250320132433456](../../../../image/image-20250320132433456.png)

##### *2. SeverHello*

![image-20250320132456032](../../../../image/image-20250320132456032.png)

##### *3.客户端回应*

![image-20250320132544199](../../../../image/image-20250320132544199.png)

![image-20250320132609173](../../../../image/image-20250320132609173.png)

##### *4. 服务器的最后回应*

![image-20250320132645272](../../../../image/image-20250320132645272.png)



#### 客户端校验数字证书的流程是怎样的？

![img](https://cdn.xiaolincoding.com/gh/xiaolincoder/ImageHost4@main/%E7%BD%91%E7%BB%9C/https/%E8%AF%81%E4%B9%A6%E7%9A%84%E6%A0%A1%E9%AA%8C.png)

![image-20250320132745872](../../../../image/image-20250320132745872.png)



###  HTTPS 的应用数据是如何保证完整性的？

![image-20250320133020409](../../../../image/image-20250320133020409.png)

![img](https://cdn.xiaolincoding.com/gh/xiaolincoder/ImageHost/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%BD%91%E7%BB%9C/HTTP/%E8%AE%B0%E5%BD%95%E5%8D%8F%E8%AE%AE.png)

![image-20250320133051299](../../../../image/image-20250320133051299.png)

### HTTPS 一定安全可靠吗？

![image-20250320133303694](../../../../image/image-20250320133303694.png)