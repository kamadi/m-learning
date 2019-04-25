package kz.kamadi.mlearning.extension

import org.json.JSONObject

fun JSONObject.mergeJSON(vararg jsonObjects: JSONObject): JSONObject {
    for (temp in jsonObjects) {
        val keys = temp.keys()
        while (keys.hasNext()) {
            val key = keys.next()
            put(key, temp.get(key))
        }
    }
    return this
}