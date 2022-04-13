package ru.mrwinwon.core

open abstract class Abstract {
    interface Mapper {
        class Empty: Mapper
    }
    abstract class Object<T, M: Mapper> {
        abstract fun map(mapper: M): T
    }
}