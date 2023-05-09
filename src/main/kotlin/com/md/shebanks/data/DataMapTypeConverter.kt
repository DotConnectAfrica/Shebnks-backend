package com.md.shebanks.data

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper

class DataMapTypeConverter {


    fun map(data: Any?): Map<String, String> {
        return mapper.convertValue(data, object : TypeReference<Map<String, String>>() {})
    }

    companion object {
        val mapper = ObjectMapper()
    }
}