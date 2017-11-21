# OpenShift SSL Client

To run the client run:
```
oc process -f https://raw.githubusercontent.com/domenicbove/openshift-ssl-client/master/template.yaml | oc create -f -
```
This will automatically start a build and trigger a deployment.
Check the logs to see the response from the server

To cleanup
```
oc delete all -l app=ssl-client
```
