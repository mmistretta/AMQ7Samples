This repository is for samples of AMQ 7 topology.  It also includes a sample amqp camel producer and consumer project for quick and easy testing. 

For the SASL auth to work for the routers you will need to setup the SASL DB using the following steps: 

saslpasswd2 -c -f qdrouterd.sasldb -u <DOMAIN_NAME> <USER_NAME>

Then you need to configured the conf file for the sasl db based on your setup. Note the need for a fully qualified path for sasldb_path.

/etc/sasl2/qdrouterd.conf:

pwcheck_method: auxprop
auxprop_plugin: sasldb
sasldb_path: /etc/sasl2/qdrouterd.sasldb
mech_list: ANONYMOUS DIGEST-MD5 EXTERNAL PLAIN


