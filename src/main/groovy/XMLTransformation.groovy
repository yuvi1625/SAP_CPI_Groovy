
package main

import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.*;
import  groovy.xml.XmlUtil;

def Message processData(Message message) {
    //Body
    def body = message.getBody(java.lang.String);
    def list=new XmlParser().parseText(body);
    list.records.attributes.type[0].value="Order"
    //Headers
    def map = message.getHeaders();
    def value = map.get("oldHeader");
    message.setHeader("oldHeader",value);
    message.setHeader("newHeader", "newHeader");
    //Properties
    map = message.getProperties();
    def value1 = map.get("oldProperty");
    message.setProperty("oldProperty",value1);
    message.setProperty("newProperty", "newProperty");
    message.setBody(XmlUtil.serialize(list))
    return message;
}
