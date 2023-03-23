package com.knoldus

import org.scalatest.funsuite.AnyFunSuite

class LinkedListSTest extends AnyFunSuite {

  test("To insert and traverse elements in LinkedList") {
    val list = new LinkedList[Int]
    list.insert(1)
    list.insert(2)
    list.insert(3)
    assert(list.head.data == 1)
    assert(list.head.next.data == 2)
    assert(list.head.next.next.data == 3)

    val result = scala.collection.mutable.ListBuffer.empty[Int]
    list.traverse { data => result += data }
    assert(result == Seq(1, 2, 3))
  }

  test("delete element from LinkedList") {
    val list = new LinkedList[Int]
    list.insert(1)
    list.insert(2)
    list.insert(3)
    list.delete(2)
    assert(list.head.data == 1)
    assert(list.head.next.data == 3)

    val result = scala.collection.mutable.ListBuffer.empty[Int]
    list.traverse { data => result += data }
    assert(result == Seq(1, 3))
  }

  test("search for element in LinkedList") {
    val list = new LinkedList[String]
    list.insert("Ayush")
    list.insert("Rahul")
    list.insert("Tanushi")
    val node = list.search("Rahul")
    assert(node.isDefined)
    assert(node.get.data == "Rahul")
  }
}