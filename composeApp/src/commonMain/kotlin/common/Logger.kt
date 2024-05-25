package common

import co.touchlab.kermit.Logger as KermitLogger

interface Log {
    fun v(message: String)
    fun v(throwable: Throwable)
    fun d(message: String)
    fun d(throwable: Throwable)
    fun i(message: String)
    fun i(throwable: Throwable)
    fun w(message: String)
    fun w(throwable: Throwable)
    fun e(message: String)
    fun e(throwable: Throwable)
}

class LogImpl : Log {
    override fun v(message: String) {
        KermitLogger.v(message)
    }

    override fun v(throwable: Throwable) {
        KermitLogger.v(throwable) {
            throwable.message ?: throwable.stackTraceToString()
        }
    }

    override fun d(message: String) {
        KermitLogger.d(message)
    }

    override fun d(throwable: Throwable) {
        KermitLogger.d(throwable) {
            throwable.message ?: throwable.stackTraceToString()
        }
    }

    override fun i(message: String) {
        KermitLogger.i(message)
    }

    override fun i(throwable: Throwable) {
        KermitLogger.i(throwable) {
            throwable.message ?: throwable.stackTraceToString()
        }
    }

    override fun w(message: String) {
        KermitLogger.w(message)
    }

    override fun w(throwable: Throwable) {
        // TODO: report to crashlytics
        KermitLogger.w(throwable) {
            throwable.message ?: throwable.stackTraceToString()
        }
    }

    override fun e(message: String) {
        KermitLogger.e(message)
    }

    override fun e(throwable: Throwable) {
        // TODO: report to crashlytics
        KermitLogger.e(throwable) {
            throwable.message ?: throwable.stackTraceToString()
        }
    }
}