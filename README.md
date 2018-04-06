#SSH tunnel to transfact db

ssh -p 24226 -f oracle@pps03.hs-el.de -L 1563:pps03.hs-el.de:1521 -N

#generate SSL Key for jetty

https://wiki.eclipse.org/Jetty/Howto/Configure_SSL

in shell: 

	keytool -keystore keystore -alias jetty -genkey -keyalg RSA

name needs to be the URL or IP or both (usually seperated by comma)

mv the keystore.jks to the spring boot resources folder and add the following to application.yml:

server:
  port: 8443
  ssl:
    key-store: classpath:keystore.jks
    key-store-password: 12345678!!
    key-password: 12345678!!

the services are now available via SSL using port 8443!
