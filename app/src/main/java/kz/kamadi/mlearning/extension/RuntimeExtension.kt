package kz.kamadi.mlearning.extension

fun Runtime.isRoot(): Boolean {
    var process: Process? = null
    return try {
        process = exec("su")
        true
    } catch (e: Exception) {
        false
    } finally {
        if (process != null) {
            try {
                process.destroy()
            } catch (e: Exception) {
            }
        }
    }
}
