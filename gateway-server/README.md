# Gateway

### 路由
```
spring:
  cloud:
    gateway:    
      routes:
      - id: app-client1-route
        uri: lb://ms-client1
        predicates:
        - Path=/api-client1/**
```
### 熔断
```
spring:
  cloud:
    gateway:    
      routes:
      - id: app-client1-route
        uri: lb://ms-client1
        predicates:
        - Path=/api-client1/**
        filters:      
        # 熔断降级配置
        - name: Hystrix
          args:
            name: default
            fallbackUri: 'forward:/fallback'
```
### 限流
```
spring:
  cloud:
    gateway:    
      routes:
      - id: app-client1-route
        uri: lb://ms-client1
        predicates:
        - Path=/api-client1/**
        filters:      
        #请求限流
        - name: RequestRateLimiter
          args:
            #允许用户每秒处理多少个请求
            redis-rate-limiter.replenishRate: 10
            #令牌桶的容量，允许在一秒钟内完成的最大请求数
            redis-rate-limiter.burstCapacity: 20
            #使用SpEL按名称引用bean
            #key-resolver: "#{@ipKeyResolver}"
            key-resolver: "#{@apiKeyResolver}"
```
### 重试
```
spring:
  cloud:
    gateway:    
      routes:
      - id: app-client1-route
        uri: lb://ms-client1
        predicates:
        - Path=/api-client1/**
        filters:      
        #重试过滤器
        - name: Retry
          args:
            #用来标识重试次数,默认3
            retries: 3
            series:
            - SERVER_ERROR
            #重试response code的系列，100（info），200（success），300（redirect），400（client error），500（server error），默认500
            statuses:
            - OK
            method: GET #重试的request请求，默认GET
```
### 自定义过滤器

类名一定要为filterName + GatewayFilterFactory
如这里定义为JwtCheckGatewayFilterFactory的话，它的filterName就是JwtCheck

```
spring:
  cloud:
    gateway:    
      routes:
      - id: app-client1-route
        uri: lb://ms-client1
        predicates:
        - Path=/api-client1/**
        filters:      
        #自定义JWT检查过滤器
        - name: JwtCheck
          args:
            status: 200
            url: localhost
```


