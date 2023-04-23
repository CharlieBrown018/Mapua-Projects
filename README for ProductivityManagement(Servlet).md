!! NOTE THAT THIS PROJECT IS SERVLET RESTFUL API WEB SERVICES BASED, NOT JERSEY RESTFUL API WEB SERVICES BASED !!

For ProductivityManagement(Servlet):

Source tutorial:
  https://www.youtube.com/watch?v=-3m2_wHWXf4

When importing project to your eclipse workspace:
  Make sure that your compiler version is set to 11
  Your JDK build path to 11
  Your tomcat server to 9.0 (as long as it is 9.0)
  

Be sure to setup your MySQL Workbench with these settings (get the latest version):
  mysql root password - rootpass
  username (admin) - user
  user password - userpass
  mysql service name - MySQL80

  MySQL Server 8.0.33:
  port - 3306
  username - root
  password - rootpass

  Connection:
  Name - TaskMgtConnection
  Hostname - 127.0.0.1
  Port - 3307
  Username - root
  Password - *empty*

When setting up your XAMPP:
  Only turn on MySQL and set the Port to 3307 (the same as Workbench)
  Turn it off before creating your database connection on Workbench because it will say Portt 3307 is already in use.
  But turn it back on before activating your connection on Workbench after setting it up.
