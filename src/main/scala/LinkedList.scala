package com.knoldus
/*The programs contains implementation of singly linked list data structure that stores elements of type T
and performs 4 operations which are-
1-insert
2-delete
3-search
4-traverse
                                                        -Ayush Pathak
* */
import scala.annotation.tailrec

class Node[T](val data: T, var next: Node[T])

class LinkedList[T] {
  var head: Node[T] = null


  def insert(data: T): Unit = {
    @tailrec
    def insertHelper(node: Node[T]): Unit = {
      if (node.next == null) {
        node.next = new Node[T](data, null)
      } else {
        insertHelper(node.next)
      }
    }

    if (head == null) {
      head = new Node(data, null)
    } else {
      insertHelper(head)
    }
  }

  def delete(data: T): Unit = {
    @tailrec
    def deleteHelper(node: Node[T]): Unit = {
      if (node == null || node.next == null) return

      if (node.next.data == data) {
        node.next = node.next.next
      } else {
        deleteHelper(node.next)
      }
    }
    if (head != null && head.data == data) {
      head = head.next
    } else {
      deleteHelper(head)
    }
  }

  def traverse(f: T => Unit): Unit = {
    @tailrec
    def traverseHelper(node: Node[T]): Unit = {
      if (node != null) {
        f(node.data)
        traverseHelper(node.next)
      }
    }
    traverseHelper(head)
  }

  def search(data: T): Option[Node[T]] = {
    @tailrec
    def searchHelper(node: Node[T]): Option[Node[T]] = {
      if (node == null) {
        None
      } else if (node.data == data) {
        Some(node)
      } else {
        searchHelper(node.next)
      }
    }
    searchHelper(head)
  }
}