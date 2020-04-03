
# OAUTH-EXAMPLE


[![Build Status](https://travis-ci.com/yanzhenyidai/oauth-example.svg?branch=master)](https://travis-ci.org/yanzhenyidai/oauth-example)

> this project is sample example for oauth2, implements resource & authorize.

---

## OAUTH-EXAMPLE-AUTH

 if you want run it. you must me do this operations. 
 
 - change the redis address in application.yaml, if you has mysql server, you can change too, if not, you can use mine cloud server.
 
 - the table sys_user has do check the user login, if you want do more implements, you can write business code in this way `impl/UserServiceImpl`.
 
 - if springboot project run successfully, you can use `POSTMAN`, input the request address and send this request.
    
 ![oauth-auth.png](https://i.loli.net/2020/04/03/gSny94I1KRiUqaH.png)

---

## OAUTH-EXAMPLE-RESOURCE
    
  `oauth-example-resource`, this project is implement oauth resource, for example, you can do this operations.
  
  - run `AuthResouceConfig`, wait it bee successfully, you can input this request address `localhost:8082/test?access_token=****` in your browser. 
  
  **remark**  *** is the `oauth-example-auth` project generate token.

---

## CONTACT

  if you has any questions, you can send email to me, email address: [frank-tan@outlook.com](mailto:frank-tan@outlook.com)
  
---