The delivered code is located in 'yimiao' branch.
<<<<<<< HEAD
git checkout -b yimiao origin/yimiao to view locally
(1) To see the Client side, cd to maple_react, execute
"npm run start" directly under maple_react/, making sure that port 3000 is not occupied.
(2) To enable backend functionality, you need to run the Application.java located under 
maple_spring/src/main/java/com/maple/. Making sure that Maven is installed and all dependencies have been loaded.
Mysql is needed to enable database functionality. Install Mysql, create an account with full privilege, then create a database called "MapleTravel" (case sensitive)
edit the application.yml under the maple_spring/src/resources, changing the username and password to be your username and password. If port 8082 is occupied, change to 8080/8081/8083... 
(3)Your IDE should support SpringBoot otherwise error might happen.
(4)When everything is done, run Application.java. And the sign-up/log-in functionality should be enabled.


=======
git checkout -b yimiao origin/yimiao to view locally  

(1) To see the Client side, cd to maple_react, execute
"npm run start" directly under maple_react/, making sure that port 3000 is not occupied.  

(2) To enable backend functionality, you need to run the Application.java located under 
maple_spring/src/main/java/com/maple/. Making sure that Maven is installed and all dependencies have been loaded.
Mysql is needed to enable database functionality. Install Mysql, create an account with full privilege, then create a database called "MapleTravel" (case sensitive)
edit the application.yml under the maple_spring/src/resources, changing the username and password to be your username and password. If port 8082 is occupied, change to 8080/8081/8083...  
 
(3)Your IDE should support SpringBoot otherwise error might happen.  

(4)When everything is done, run Application.java. And the sign-up/log-in functionality should be enabled.





>>>>>>> 1e6e45c655ad74fd4682ea482937d952e92ed602
