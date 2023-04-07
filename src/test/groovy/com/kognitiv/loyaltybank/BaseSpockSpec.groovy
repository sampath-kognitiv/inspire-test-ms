package com.kognitiv.loyaltybank

import org.springframework.util.LinkedMultiValueMap
import spock.lang.Specification

class BaseSpockSpec extends Specification {

    static String readResourceText(String resource) {
        URL url = BaseSpockSpec.getResource(resource)
        assert url, "resource not found: $resource"
        return url.getText("utf-8")
    }

    static LinkedMultiValueMap<String,String> convertToMultiValueMap(Map map) {
        LinkedMultiValueMap<String,String> result = new LinkedMultiValueMap<>()
        map.each {
            result.add(it.key,it.value)
        }
        return result
    }
}
