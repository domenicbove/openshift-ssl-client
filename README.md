# OpenShift Image Scanner

To create OCP objects:
```
oc process -f template.yml | oc create -f -
```
To build and run the image:
```
mvn clean package
oc start-build ssl-client --from-file=target/ssl-client-0.0.1-SNAPSHOT.jar
```
After the build completes, a deployment will be triggered that calls into the ssl-server repeatedly
Check the logs to see the response from the server

To cleanup
```
oc delete all -l app=ssl-client
```
